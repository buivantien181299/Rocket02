
public class Officials extends NhanVien implements Salary{
	
	protected String department; // phòng ban làm việc
	protected int workingTime;	// thời gian làm việc theo ngày
	protected String position;	//vị trí công việc
	
	
	
	public void input() {
		System.out.println("Full name is: ");
		fullName = scanner.nextLine();
		System.out.println("Department is: ");
		department = scanner.nextLine();
		System.out.println("Position is: ");
		position = scanner.nextLine();
		System.out.println("Salary multiplier is:");
		salaryMultiplier =  scanner.nextFloat();
		System.out.println("Working time is: ");
		workingTime = scanner.nextInt();
		
		if(position.equals("department head")) {
			allowance = 2000;
		}
		else if(position.equals("vice head")) {
			allowance = 1000;
		}
		else if(position.equals("staff")) {
			allowance = 500;
		}
		else {
			allowance = 0;
		}
	}
	
	public void ouput() {
		System.out.println("Full name is: " + fullName);
		System.out.println("Department is: " + department);
		System.out.println("Position is: " + position);
		System.out.println("Salary multiplier is:" + salaryMultiplier);
		System.out.println("Working time is: " + workingTime);
		System.out.println("Allowance is: " + allowance);
	}
	
	@Override
	public void salarymultiplier() {
		// TODO Auto-generated method stub
		float salary = salaryMultiplier*730 + allowance + workingTime*30;
		System.out.println("Tiền lương là: " + salary);
		
	}

}
