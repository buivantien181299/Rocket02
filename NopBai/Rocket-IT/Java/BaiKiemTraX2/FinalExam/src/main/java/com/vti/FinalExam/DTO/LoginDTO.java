//
package com.vti.FinalExam.DTO;

import com.vti.FinalExam.view.UserView;


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
public class LoginDTO {
	private String email, pass;

	public String getEmail() {
		return email;
	}

	public LoginDTO setEmail(String email) {
		this.email = email;
		return this;
		
	}

	public String getPass() {
		return pass;
	}

	public LoginDTO setPass(String pass) {
		this.pass = pass;
		return this;
		
	}
	
	public LoginDTO(UserView view) {
		email = view.getEmail();
		pass = view.getPass();
	}
	
	public UserView toEntity(LoginDTO dto) {
		return new UserView()
				.setEmail(email)
				.setPass(pass);
	}
}
