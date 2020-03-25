package com.vti.template.utils;

import java.util.Scanner;


/**
 * This class is is enter input from User 
 * 
 * @Description: .
 * @author: TienBui
 * @create_date: Mar 25, 2020
 * @version: 1.0
 * @modifer: TienBui
 * @modifer_date: Mar 25, 2020
 */
public class ScannerUtil {

	/**
	 * This method is enter input Integer.
	 * 
	 * @Description: .
	 * @author: TienBui
	 * @create_date: Mar 25, 2020
	 * @version: 1.0
	 * @modifer: TienBui
	 * @modifer_date: Mar 25, 2020
	 * @param scanner
	 * @param errorMessage
	 * @return
	 */
	public static int readInt(Scanner scanner, String errorMessage) {
		while (true) {
			try {
				return Integer.parseInt(scanner.nextLine());
			} catch (Exception e) {
				showError(errorMessage);
			}
		}
	}

	/**
	 * This method is . 
	 * 
	 * @Description: .
	 * @author: TienBui
	 * @create_date: Mar 25, 2020
	 * @version: 1.0
	 * @modifer: TienBui
	 * @modifer_date: Mar 25, 2020
	 * @param scanner
	 * @param errorMessage
	 * @return
	 */
	public static double readDouble(Scanner scanner, String errorMessage) {
		while (true) {
			try {
				return Double.parseDouble(scanner.nextLine());
			} catch (Exception e) {
				showError(errorMessage);
			}
		}
	}

	
	/**
	 * This method is is enter input float. 
	 * 
	 * @Description: .
	 * @author: TienBui
	 * @create_date: Mar 25, 2020
	 * @version: 1.0
	 * @modifer: TienBui
	 * @modifer_date: Mar 25, 2020
	 * @param scanner
	 * @param errorMessage
	 * @return
	 */
	public static float readFloat(Scanner scanner, String errorMessage) {
		while (true) {
			try {
				return Float.parseFloat(scanner.nextLine());
			} catch (Exception e) {
				showError(errorMessage);
			}
		}
	}

	/**
	 * This method is enter input String. 
	 * 
	 * @Description: .
	 * @author: TienBui
	 * @create_date: Mar 25, 2020
	 * @version: 1.0
	 * @modifer: TienBui
	 * @modifer_date: Mar 25, 2020
	 * @param scanner
	 * @param errorMessage
	 * @return
	 */
	public static String readString(Scanner scanner, String errorMessage) {
		while (true) {
			try {
				String result = scanner.nextLine().trim();
				if (result != null & !result.isEmpty()) {
					return result;
				}
			} catch (Exception e) {
				showError(errorMessage);
			}
		}
	}

	
	/**
	 * This method show error message when validating. 
	 * 
	 * @Description: .
	 * @author: TienBui
	 * @create_date: Mar 25, 2020
	 * @version: 1.0
	 * @modifer: TienBui
	 * @modifer_date: Mar 25, 2020
	 * @param message
	 */
	private static void showError(String message) {
		System.out.println("Error: " + message);
	}

}

