//
package com.vti.template.entity;

/**
 * This class is mô tả người dùng
 * 
 * @Description: .
 * @author: TienBui
 * @create_date: Mar 25, 2020
 * @version: 1.0
 * @modifer: TienBui
 * @modifer_date: Mar 25, 2020
 */
public class User {
	
	private String firstName;
	private String lastName;
	private String phone;
	private String email;
	
	
	/**
	 * Constructor for class User.
	 * 
	 * @Description: .
	 * @author: TienBui
	 * @create_date: Mar 25, 2020
	 * @version: 1.0
	 * @modifer: TienBui
	 * @modifer_date: Mar 25, 2020
	 */
	public User() {
		
	}
	
	
	/**
	 * Constructor for class User.
	 * 
	 * @Description: .
	 * @author: TienBui
	 * @create_date: Mar 25, 2020
	 * @version: 1.0
	 * @modifer: TienBui
	 * @modifer_date: Mar 25, 2020
	 * @param firstName
	 * @param lastName
	 * @param phone
	 * @param email
	 */
	public User(String firstName, String lastName, String phone, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
		
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
		
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;	
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
		
	}
}
