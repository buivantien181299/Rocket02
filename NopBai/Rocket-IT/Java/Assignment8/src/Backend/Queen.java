package Backend;

public class Queen extends Bee {

	@Override
	public boolean CheckHealthStatus() {
		if(floatingPointHealth > 20) {
			
			System.out.println( floatingPointHealth + " Queen is living.");
			return true;
		}
		else {
			
			System.out.println( floatingPointHealth + " Queen is die.");
			return false;
		}
	}	
	
	
	@Override
	public void Dame(int dame) {
		super.Dame(dame);
		
		if(CheckHealthStatus()) {
			floatingPointHealth -= dame;
			
		}
		else {
			System.out.println("Queen còn " + floatingPointHealth + " không thể trừ tiếp.");
		}
			
	}
	
	
	
}
