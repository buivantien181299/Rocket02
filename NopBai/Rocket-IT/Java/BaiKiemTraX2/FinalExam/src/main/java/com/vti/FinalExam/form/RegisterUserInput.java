//
package com.vti.FinalExam.form;

/**
 * This class is . 
 * 
 * @Description: .
 * @author: TienBui
 * @create_date: Apr 12, 2020
 * @version: 1.0
 * @modifer: TienBui
 * @modifer_date: Apr 12, 2020
 */
public class RegisterUserInput {
	private String email, password, firstName, lastName,  phone;

	public String getEmail() {
		return email;
	}

	public RegisterUserInput setEmail(String email) {
		this.email = email;
		return this;
		
	}

	public String getPassword() {
		return password;
	}

	public RegisterUserInput setPassword(String password) {
		this.password = password;
		return this;
		
	}

	public String getFirstName() {
		return firstName;
	}

	public RegisterUserInput setFirstName(String firstName) {
		this.firstName = firstName;
		return this;
		
	}

	public String getLastName() {
		return lastName;
	}

	public RegisterUserInput setLastName(String lastName) {
		this.lastName = lastName;
		return this;
		
	}

	public String getPhone() {
		return phone;
	}

	public RegisterUserInput setPhone(String phone) {
		this.phone = phone;
		return this;
		
	}
}
