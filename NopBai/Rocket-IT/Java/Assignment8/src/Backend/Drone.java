package Backend;

public class Drone extends Bee {


	@Override
	public boolean CheckHealthStatus() {
		if(floatingPointHealth > 50) {
			
			System.out.println(floatingPointHealth + " Drone is living.");
			return true;
		}
		else {
			
			System.out.println(floatingPointHealth + " Drone is die.");
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
			System.out.println("Drone còn " + floatingPointHealth + " không thể trừ tiếp.");
		}
			
	}
}
