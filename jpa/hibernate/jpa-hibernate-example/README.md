# JPA - Hibernate Example
An example project demonstrating JPA (Java Persistence API) using Hibernate ORM in Java

Below summarises key features of project. See code for detailed information

Using persistence.xml instead of hibernate.cfg.xml because we are using JPA's entity manager rather than the proprietary Hibernate SessionFactory & related classes.

### One to One relationship

in owner entity (Customer):

```java
public class Customer {
  
  	// other properties omitted...
  
	private CustomerPaymentDetail customerPaymentDetail;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "customer")
	public CustomerPaymentDetail getCustomerPaymentDetail() {
		return customerPaymentDetail;
	}
	...
}

```

and in the inverse entity (CustomerPaymentDetail):

```java
public class CustomerPaymentDetail {

	// other properties omitted...
	
	private Customer customer;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", nullable = false)
	public Customer getCustomer() {
		return customer;
	}

...
}
	
```

### One to Many relationship (inverse Many to One relationship):

A Customer can have many orders (therefore 1:M)... So

```java
public class Customer {

	// other properties omitted
	
	private Set<Order> orders = new HashSet<Order>(0);
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "customer")
	public Set<Order> getOrders() {
		return orders;
	}
	
	...
}
	
```

and the Order entity:

```java
public class Order {

	// other properties omitted...
	
	private Customer customer;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id", nullable = false)
	public Customer getCustomer() {
		return customer;
	}
	
	...
}
```
*note the inverse entity has the opposite mapping of @ManyToOne as opposed to @OneToMany on the owner entity

### Many to Many relationship

An order can have many items and an item can belong to many different orders. A mapping (join) table orders_items exists.

```java
public class Order {

	// other properties omitted
	
	private Set<Item> items = new HashSet<Item>(0);
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "orders_items",
		joinColumns = { @JoinColumn(name = "order_id", nullable = false, updatable = false)},
		inverseJoinColumns = { @JoinColumn(name = "item_id", nullable = false, updatable = false)}
			)
	public Set<Item> getItems() {
		return items;
	}
	
	...
}
```

Item entity:

```java
public class Item {

	// other properties omitted
	
	private Set<Order> orders = new HashSet<Order>();
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "items")
	public Set<Order> getOrders() {
		return orders;
	}
	
	...
}
```

here in this example we use @JoinTable to specify the mapping information about the database mapping table "orders_items". Not having an entity to represent this mapping table because it does not contain any 'extra' columns apart from the 2 mapping foreign keys to their respective tables (i.e Orders & Items).

If mapping table "orders_items" contained extra columns we would use a separate entity to hold that information but for this example we don't need.
