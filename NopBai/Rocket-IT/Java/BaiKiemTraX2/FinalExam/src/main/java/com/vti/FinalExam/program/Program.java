//
package com.vti.FinalExam.program;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.vti.FinalExam.Function.Functions;
import com.vti.FinalExam.controller.LoginController;
import com.vti.FinalExam.controller.RegisterController;
import com.vti.FinalExam.utils.ScannerUtil;


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
public class Program {
	public static void main(String[] args)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		
		Functions f = new Functions();
		LoginController login = new LoginController();
		RegisterController register = new RegisterController();
		int kind;
		Scanner scanner=new Scanner(System.in);
		while(true) {
			System.out.println("Manager Candidate");
			System.out.println("1. Login");
			System.out.println("2. Register");
		kind =  ScannerUtil.readInt(scanner,  "Nhập số");
		switch (kind) {
			case 1:
			{
				f.Login(login);
				break;
			}
			case 2:{
				
				f.Register(register);
				break;
			}

			default:
				break;
			}
		}
	}
}
