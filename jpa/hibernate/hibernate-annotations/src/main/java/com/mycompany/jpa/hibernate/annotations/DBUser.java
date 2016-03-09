/**
 * 
 */
package com.mycompany.jpa.hibernate.annotations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author colin
 *
 */
@Entity
@Table(name = "DBUSER")
public class DBUser {

	private int userId;
	private String username;
	private String createdBy;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "USER_ID")
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Column(name = "USERNAME", nullable = false, length = 30)
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name = "CREATED_BY", nullable = false, length = 30)
	public String getCreatedBy() {
		return createdBy;
	}
	
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Override
	public String toString() {
		return "DBUser [userId=" + userId + ", username=" + username
				+ ", createdBy=" + createdBy + "]";
	}
	
	
}
