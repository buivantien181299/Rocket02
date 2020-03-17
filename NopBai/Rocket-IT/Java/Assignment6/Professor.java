

public class Professor extends NhanVien implements Salary{

	protected	String faculty;				// năng lực
	protected 	String academicDegree;		// bằng cấp
	protected 	int monthlyTeachingTime;	// thời gian dạy theo giờ
	
	
	
	public void input() {
		System.out.println("Full name is: ");
		fullName = scanner.nextLine();
		System.out.println("Faculty is: ");
		faculty = scanner.nextLine();
		System.out.println("Academic degree is: ");
		academicDegree = scanner.nextLine();
		System.out.println("Salary multiplier is:");
		salaryMultiplier =  scanner.nextFloat();
		System.out.println("Monthly teaching time is: ");
		monthlyTeachingTime = scanner.nextInt();
		
		if(academicDegree.equals("bachelor")) {
			allowance = 300;
		}
		else if(academicDegree.equals("master")) {
			allowance = 500;
		}
		else if(academicDegree.equals("doctor")) {
			allowance = 1000;
		}
		else {
			allowance = 0;
		}
		
	}
	
	public void ouput() {
		System.out.println("Full name is: " + fullName);
		System.out.println("Faculty is: " + faculty);
		System.out.println("Academic degree is: " + academicDegree);
		System.out.println("Salary multiplier is:" + salaryMultiplier);
		System.out.println("Monthly teaching time is: " + monthlyTeachingTime);
		System.out.println("Allowance is: " + allowance);
	}
	
	
	@Override
	public void salarymultiplier() {
		float salary = salaryMultiplier*730 + allowance + monthlyTeachingTime*45;
		System.out.println("Your salary is :" + salary);
	}

}
