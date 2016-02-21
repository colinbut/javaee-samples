/**
 * 
 */
package com.mycompany.jsf.datatables;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.ArrayDataModel;
import javax.faces.model.DataModel;

/**
 * @author colin
 *
 */
@ManagedBean
@SessionScoped
public class PersonBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final Person[] personList = new Person[] {
			new Person("Ajantha", "Malwatta", 36),
			new Person("Colin", "But", 27),
			new Person("Naga", "Raju", 50),
			new Person("Peter", "Jurkovic", 25),
			new Person("James", "Lawrie", 40)
	};
	
	private DataModel<Person> personModel = new ArrayDataModel<Person>(personList);
	
	public DataModel<Person> getPersonList() {
		return personModel;
	}

}
