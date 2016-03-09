/**
 * 
 */
package com.mycompany.jpa.hibernate.xml_mapping;

/**
 * @author colin
 *
 */
public class DBUser {

	private int userId;
	private String username;
	private String createdBy;
	
	public int getUserId() {
		return userId;
	}
	
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
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
