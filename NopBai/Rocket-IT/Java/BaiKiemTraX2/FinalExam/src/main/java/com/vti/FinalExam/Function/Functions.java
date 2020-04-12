//
package com.vti.FinalExam.Function;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.vti.FinalExam.DTO.LoginDTO;
import com.vti.FinalExam.controller.LoginController;
import com.vti.FinalExam.controller.RegisterController;
import com.vti.FinalExam.form.LoginForm;
import com.vti.FinalExam.form.RegisterEmployeeInput;
import com.vti.FinalExam.form.RegisterManagerInput;
import com.vti.FinalExam.form.RegisterUserInput;
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
public class Functions {
	
	
	public void Login(LoginController controller) 
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		Scanner scanner = new Scanner(System.in);
		LoginForm input = null;
		String email, password;

		System.out.println(" Login Program");
		// input Email
		System.out.println("Nhap Email: ");
		email = ScannerUtil.readString(scanner, "Nhập chuỗi.");

		// input Password
		System.out.println("Nhap Password: ");
		password = ScannerUtil.readString(scanner, "Nhập chuỗi");

		// design pattern Builder
		input = new LoginForm().setEmail(email).setPass(password);

		LoginDTO dto = controller.Login(input);
		if (dto != null) {
			System.out.println("Login Success!!!");
			System.out.println("Chao mung " + dto.getEmail());

		} else {
			System.out.println("Login Fail!!!");
		}
	}
	
	
	public void Register(RegisterController controller)
			throws FileNotFoundException, ClassNotFoundException, IOException, SQLException {
		;
		Scanner scanner = new Scanner(System.in);

		RegisterEmployeeInput inputE = null;
		RegisterManagerInput inputM = null;
		RegisterUserInput inputU = null;

		String email, password, phone, firstName, lastName, proSkill;
		String projectName = null;
		int ExpInYear;
		int id;
		System.out.println("Chương trình đăng nhập");

		System.out.println("Nhập email: ");
		email = ScannerUtil.readString(scanner, "Nhập một chuỗi");
		System.out.println("Nhập số điện thoại");
		phone = ScannerUtil.readString(scanner, "Nhập một chuỗi");
		System.out.println("Nhập mật khẩu:");
		password = ScannerUtil.readString(scanner, "Nhập một chuỗi");
		System.out.println("Nhập tên đầu tiên:");
		firstName = ScannerUtil.readString(scanner, "Nhập một chuỗi");
		System.out.println("Nhập tên sau: ");
		lastName = ScannerUtil.readString(scanner, "Nhập một chuỗi");
		System.out.println("Nhap IDuser : ");
		id = ScannerUtil.readInt(scanner, "Nhập số");

		System.out.println("Register Employee or Manager? ");
		System.out.println("1. Employee");
		System.out.println("2. Manager");
		System.out.println("Nhập sô bạn muốn:");
		int value = ScannerUtil.readInt(scanner, "Nhập số");
		switch (value) {
		case 1: {
			System.out.println("Nhập pro skin:");
			proSkill =  ScannerUtil.readString(scanner, "Nhập một chuỗi");
			System.out.println("Nhập projectName:");
			System.out.println("1. Testing System");
			System.out.println("2. CRM");
			System.out.println("3. TimeSheet");
			System.out.println("Nhập project bạn muốn:");
			int key = ScannerUtil.readInt(scanner, "Nhập số");

			switch (key) {
			case 1:
				projectName = "Testing System";
				break;

			case 2:
				projectName = "CRM";
				break;

			case 3:
				projectName = "TimeSheet";
				break;

			default:
				break;
			}

			inputU = new RegisterUserInput().setEmail(email).setFirstName(firstName).setLastName(lastName)
					.setPassword(password).setPhone(phone);
			inputE = new RegisterEmployeeInput().setId(id).setProjectName(projectName).setProSkill(proSkill);

			if (controller.RegisterEmployee(inputE) || controller.RegisterUser(inputU)) {
				System.out.println("đăng ký thành công.");
			} else {
				System.out.println("đăng ký thất bại.");
			}
			break;
		}
		case 2: {
			System.out.println("Nhập số năm kinh nghiệm: ");
			ExpInYear = ScannerUtil.readInt(scanner, "chỉ nhập số.");

			inputU = new RegisterUserInput().setEmail(email).setFirstName(firstName).setLastName(lastName)
					.setPassword(password).setPhone(phone);

			inputM = new RegisterManagerInput().setExpInYear(ExpInYear).setId(id);
			if (controller.RegisterManager(inputM) || controller.RegisterUser(inputU)) {
				System.out.println("đăng ký thành công.");
			} else {
				System.out.println("đăng ký thất bại.");
			}
			break;
		}

		default:
			break;
		}
	}

}
