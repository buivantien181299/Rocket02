import java.util.Scanner;

public class SequenceNumber {
	static Scanner scanner = new Scanner(System.in);
	
	public static int[] arr;
	
	
	
	public void input() {
		for (int i = 0; i < arr.length; i++) {
			System.out.println("Nhập phần tử thứ " + (i+ 1) + " là: ");
			arr[i] = scanner.nextInt();
		}
	}
	
	
	public void print(int arr[]) {
		int n = arr.length;
		
		for (int i = 0; i < n; i++) {
			System.out.println(arr[i]);
		}
		
	}
	SequenceNumber(int n) {
		arr = new int[n];
	}
	
}
