//
package MainProgaram;

import java.util.Scanner;


import form.form;
import utils.ScannerUtil;

/**
 * This class is . 
 * 
 * @Description: .
 * @author: TienBui
 * @create_date: Mar 31, 2020
 * @version: 1.0
 * @modifer: TienBui
 * @modifer_date: Mar 31, 2020
 */
public class Test {
	public static void main(String[] args) {
		form f = new form();
		Scanner scanner = new Scanner(System.in);
		

//		while (true) {
//			
//			String account = "";
//			String email = "";
//			System.out.println("Email: ");
//			email = ScannerUtil.readString(scanner, "Can't not null! \nPlease try again: ");
//			System.out.println("Account: ");
//			account = ScannerUtil.readString(scanner, "Can't not null! \nPlease try again: ");
//			boolean bl = new LoginController().login(email, account);
//			if (!bl) {
//				System.out.println("Please login again!");
//				
//			} else {
//				System.out.println("Login successfully!");
//				System.out.println("----------Welcome " + email + "---------");
				boolean login = true;
				int choose;
				while (login) {
					System.out.println("1.	Insert Trainee.");
					System.out.println("2.	Update Trainee.");
					System.out.println("3.	Logout.");
					System.out.println("Please choose: ");
					choose = ScannerUtil.readInt(scanner, "Please input data as INTEGER! \nPlease input again: ");
					switch (choose) {
					case 1:
						// insert Trainee
						f.insertTrainee();
						break;
					case 2:
						// update Trainee
						f.updateTrainee();
						break;
					case 3:
						// logout
						login = false;
						System.out.println("Logout succesfully!");
						break;
					default:
						System.out.println("Please choose from 1-->3");
						break;
					}
				}
			}
}

