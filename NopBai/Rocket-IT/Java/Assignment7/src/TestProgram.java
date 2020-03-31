import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class TestProgram {
	
		List<Officials> of = new ArrayList<Officials>();
		List<Professor> pr = new ArrayList<Professor>();
		
		
		
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
		
		TestProgram tp = new TestProgram();
		
		System.out.println("DANH SÁCH NHÂN VIÊN TRƯỜNG NEU");
		System.out.println("------------------------------");
		
		while(true) {
		
		System.out.println("1. Giáo sư");
		System.out.println("2. Cán bộ");
		System.out.println("3. Tìm kiếm nhân viên theo tên phòng ban");
		System.out.println("4. Sắp xếp danh sách giáo sư");
		System.out.println("Bạn hãy chọn số bạn muốn:");
		int number = scanner.nextInt();
		
		switch (number) {
		case 1:
			tp.inputListProfessor();
			break;
				
		case 2:
			tp.inputListOfficials();
			break;	
		case 3:
			tp.searchOfficials();
			break;
		case 4:
			tp.sortByNameProfessor();
			break;
		default:
			System.out.println("Chon tu 1-->4!");
			break;
		}
		
		
		}
		
		
		
	}



	/**
	 * This method is . 
	 * 
	 * @Description: .
	 * @author: TienBui
	 * @create_date: Mar 31, 2020
	 * @version: 1.0
	 * @modifer: TienBui
	 * @modifer_date: Mar 31, 2020
	 */
	private void inputListOfficials() {
		int number;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập số nhân viên vào danh sách:");
		number = scanner.nextInt();
		for (int i = 0; i < number; i++) {
			System.out.println("Nhập thông tin nhân viên thứ " + (i+1) + " :");
			Officials o = new Officials();
			o.input();
			of.add(o);
		}
		
	}



	/**
	 * This method is . 
	 * 
	 * @Description: .
	 * @author: TienBui
	 * @create_date: Mar 31, 2020
	 * @version: 1.0
	 * @modifer: TienBui
	 * @modifer_date: Mar 31, 2020
	 */
	private void inputListProfessor() {
		int number;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập số giáo sư vào danh sách:");
		number = scanner.nextInt();
		for (int i = 0; i < number; i++) {
			System.out.println("Nhập thông tin giáo sư thứ " + (i+1) + " :");
			Officials o = new Officials();
			o.input();
			of.add(o);
		}
	}



	/**
	 * This method is . 
	 * 
	 * @Description: .
	 * @author: TienBui
	 * @create_date: Mar 31, 2020
	 * @version: 1.0
	 * @modifer: TienBui
	 * @modifer_date: Mar 31, 2020
	 */
	private void searchOfficials() {
		List<Officials> off = new ArrayList<Officials>();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Nhập tên bạn muốn kiểm tra: ");
		String name = scanner.nextLine();
		
		int res = 0;
		
		for(Officials nv : off ) {
			if(name ==  nv.fullName) {
				res++;
				off.add(nv);
			}
		}
		
		System.out.println("\nKet qua tim kiem");
		for (Officials nv : off) {
			nv.ouput();;
		}

		if (res == 0) {
			System.out.println("Khong co ket qua nao dc tim thay!");
		} 
		
		
	}



	/**
	 * This method is . 
	 * 
	 * @Description: .
	 * @author: TienBui
	 * @create_date: Mar 31, 2020
	 * @version: 1.0
	 * @modifer: TienBui
	 * @modifer_date: Mar 31, 2020
	 */
	private void sortByNameProfessor() {
		Collections.sort(pr, new Comparator<Professor>() {

			@Override
			public int compare(Professor o1, Professor o2) {
				// TODO Auto-generated method stub
				return o1.fullName.compareTo(o2.fullName);
			}

		});

		System.out.println("Danh sach cac Giao su");
		for (Professor gs : pr) {
			gs.ouput();;
		}
	}

	

}
