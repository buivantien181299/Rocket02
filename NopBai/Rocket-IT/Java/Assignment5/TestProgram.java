
public class TestProgram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//QuickSort 		qs = new QuickSort(6);
		SelectionSort	ss = new SelectionSort(7);
	//	InsertSort		is = new InsertSort(5);
		
//		is.input();
//		is.sort();
//		is.print(arr);
		
		int[] arr = SequenceNumber.arr;
		
//		qs.input();
//		qs.sort(arr, 0, 5);
//		qs.print(arr);
//		
		
		ss.input();
		ss.sort();
		ss.print(arr);
		

		
		
	}

}
