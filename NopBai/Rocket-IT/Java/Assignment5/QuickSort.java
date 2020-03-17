
public class QuickSort extends SequenceNumber implements Sort{

	public QuickSort(int n) {
		super(n);
		// TODO Auto-generated constructor stub
	}
	
	int partition(int arr[], int low, int high) 
    { 
        int pivot = arr[high];  
        int i = (low-1); 
        for (int j=low; j<high; j++) 
        { 
            
            if (arr[j] < pivot) 
            { 
                i++; 
  
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    } 
  
	@Override
	public void sort(int arr[], int low, int high) {
		// TODO Auto-generated method stub    	    
	        if (low < high) 
	        { 
	            int pi = partition(arr, low, high); 
	            sort(arr, low, pi-1); 
	            sort(arr, pi+1, high); 
	        } 
	}

	@Override
	public void sort() {
		// TODO Auto-generated method stub
		
	}
	

}
