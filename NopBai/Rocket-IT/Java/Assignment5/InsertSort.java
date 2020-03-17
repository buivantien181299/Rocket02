
public class InsertSort extends SequenceNumber implements Sort{

	public InsertSort(int n) {
		super(n);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		int n = arr.length; 
        for (int i = 1; i < n; ++i) { 
            int key = arr[i]; 
            int j = i - 1; 
  
            /* Move elements of arr[0..i-1], that are 
               greater than key, to one position ahead 
               of their current position */
            while (j >= 0 && arr[j] > key) { 
                arr[j + 1] = arr[j]; 
                j = j - 1; 
            } 
            arr[j + 1] = key; 
        } 
		
	}

	@Override
	public void sort(int[] arr, int low, int high) {
		// TODO Auto-generated method stub
		
	}

}
