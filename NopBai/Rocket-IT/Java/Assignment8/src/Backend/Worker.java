package Backend;

public class Worker extends Bee {
	
	
	@Override
	public boolean CheckHealthStatus() {
		if(floatingPointHealth > 70) {
			
			System.out.println(floatingPointHealth + " Worker is living.");
			return true;
		}
		else {
			
			System.out.println(floatingPointHealth + " Worker is die.");
			return false;
		}
	}
	
	@Override
	public void Dame(int dame) {
		super.Dame(dame);
		
		if(CheckHealthStatus()) {
			floatingPointHealth -= dame;
			System.out.println();
		}
		else {
			System.out.println("Workwe còn " + floatingPointHealth + " không thể trừ tiếp.");
		}
		
	}

}
