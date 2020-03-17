
public  class SelectionSort extends SequenceNumber implements Sort{

	public SelectionSort(int n) {
		super(n);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		int n = arr.length; 
		  
        // One by one move boundary of unsorted subarray 
        for (int i = 0; i < n-1; i++) 
        { 
            // Find the minimum element in unsorted array 
            int min_idx = i; 
            for (int j = i+1; j < n; j++) 
                if (arr[j] < arr[min_idx]) 
                    min_idx = j; 
  
            // Swap the found minimum element with the first 
            // element 
            int temp = arr[min_idx]; 
            arr[min_idx] = arr[i]; 
            arr[i] = temp; 
        } 
		
	}

	@Override
	public void sort(int[] arr, int low, int high) {
		// TODO Auto-generated method stub
		
	}

}
