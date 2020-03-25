//
package com.vti.template.form;

/**
 * This class is . 
 * 
 * @Description: .
 * @author: TienBui
 * @create_date: Mar 25, 2020
 * @version: 1.0
 * @modifer: TienBui
 * @modifer_date: Mar 25, 2020
 */
public class LoginInput {
	private String email, password;

	
	public String getEmail() {
		return email;
	}

	
	public String getPassword() {
		return password;
	}

	public LoginInput setEmail(String email) {
		this.email = email;
		return this;
		
	}

	
	public LoginInput setPassword(String password) {
		this.password = password;
		return this;
	}

	

	

}
