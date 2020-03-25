//
package com.vti.template.funcion;

import java.util.Scanner;

import com.vti.template.form.LoginInput;
import com.vti.template.utils.ScannerUtil;

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
public class Function {
	public void Login() {
		Scanner scanner = new Scanner(System.in);
		LoginInput input = null;
		String email, password;
		
		System.out.println("Login Program");
		System.out.println();
		
		// nhập email
		
		email = ScannerUtil.readString(scanner, "Invalid value, Please input string: ");
		
		// nhập password 
		password = ScannerUtil.readString(scanner, "Invalid value, Please input string: ");
		
		input = new LoginInput().setPassword(password).setEmail(email);
		
		
		
		
	}
}
