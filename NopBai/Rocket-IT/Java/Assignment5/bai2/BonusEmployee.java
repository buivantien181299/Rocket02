package bai2;

abstract class Employee {
	private String name, address;
	protected int basicSalary;
	
	public String getName(){
		return name;
	}
	
	public String getAddress(){
		return address;
	}
	
	public int getBasicSalary(){
		return basicSalary;
	}
	
	public void setAddress(String add){
		address = add;
	}
	
	public void setName(String nm){
		name = nm;
	}
	
	public void setBasicSalary(int sal){
		basicSalary = sal;
	}
	
	public abstract int getMonthlySalary();
}

class NormalEmployee extends Employee{
	
	@Override
	public int getMonthlySalary() {
		
		return basicSalary;
	}
}

public  class BonusEmployee extends Employee{

	private int bonus;
	
	public int getBonus() {
		return bonus;
	}
	public void setBonus(int bonus) {
		this.bonus = bonus;
	}
	@Override
	public int getMonthlySalary() {
		return bonus + basicSalary;
		
	}
	public static void main(String[] args) {
		NormalEmployee ne = new NormalEmployee();
		ne.setName("Nguyễn Thu An");
		ne.setAddress("Thái Bình");
		ne.setBasicSalary(15000000);
		System.out.println("Họ và tên là: " + ne.getName());
		System.out.println("Địa chỉ là: " + ne.getAddress());
		System.out.println("Lương tháng cơ bản là: " + ne.getMonthlySalary());
		
		BonusEmployee be = new BonusEmployee();
		be.setName("Hà Thu Hoài");
		be.setAddress("Bình Dương");
		be.setBonus(1200000);
		be.setBasicSalary(12200000);
		System.out.println("Họ và tên là: " + be.getName());
		System.out.println("Địa chỉ là: " + be.getAddress());
		System.out.println("Lương tháng là: " + be.getMonthlySalary());
	}
	
}
