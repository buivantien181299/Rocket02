//
package form;

import java.util.List;
import java.util.Scanner;

import controller.LoginController;
import entity.SVThucTap;
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
public class form {
	static List<SVThucTap> list;

	
	/**
	 * This method is . 
	 * 
	 * @Description: .
	 * @author: hung34atp
	 * @create_date: Mar 24, 2020
	 * @version: 1.0
	 * @modifer: hung34atp
	 * @modifer_date: Mar 24, 2020
	 */
	public void insertTrainee() {
		Scanner sc = new Scanner(System.in);
		SVThucTap trainee = new SVThucTap();
		System.out.println("Account: ");
		trainee.setAccount(ScannerUtil.readString(sc, "Not null! \nTry again"));
		System.out.println("FirstName: ");
		trainee.setFirstName(ScannerUtil.readString(sc, "Not null! \nTry again"));
		System.out.println("LastName: ");
		trainee.setLastName(ScannerUtil.readString(sc, "Not null! \nTry again"));
		System.out.println("Email: ");
		trainee.setEmail(ScannerUtil.readString(sc, "Not null! \nTry again"));
		
		boolean bl = new LoginController().insertTrainee(trainee);
		if (bl) {
			System.out.println("Insert Successfully!");
		}else {
			System.out.println("Insert Failed!");
		}
	}
	
	/**
	 * This method is . 
	 * 
	 * @Description: .
	 * @author: hung34atp
	 * @create_date: Mar 24, 2020
	 * @version: 1.0
	 * @modifer: hung34atp
	 * @modifer_date: Mar 24, 2020
	 * @param userName
	 */
	public void updateTrainee() {
		Scanner sc = new Scanner(System.in);
		SVThucTap trainee = new SVThucTap();
		System.out.println("Account: ");
		trainee.setAccount(ScannerUtil.readString(sc, "Not null! \nTry again"));
		System.out.println("FirstName: ");
		trainee.setFirstName(ScannerUtil.readString(sc, "Not null! \nTry again"));
		System.out.println("LastName: ");
		trainee.setLastName(ScannerUtil.readString(sc, "Not null! \nTry again"));
		System.out.println("Email: ");
		trainee.setEmail(ScannerUtil.readString(sc, "Not null! \nTry again"));
	
		boolean bl = new LoginController().updateTrainee(trainee);
		if (bl) {
			System.out.println("Update Successfully!");
		}else {
			System.out.println("Update Failed!");
		}
	}
}
