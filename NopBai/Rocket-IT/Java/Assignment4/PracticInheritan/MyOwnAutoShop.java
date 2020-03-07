package PracticInheritan;

public class MyOwnAutoShop {
	public static void main(String[] args) {
		Truck truck = new Truck(25, 50.5, 100);
		Ford ford = new Ford(30, 70.25, 1995, 30);
		Sedan sedan = new Sedan(35, 35.54, 35);
		System.out.println("Giá của truck là:" + truck.getSalePrice(500)); 
		System.out.println("Giá của ford là: " + ford.getSalePrice(450)); 
		System.out.println("Giá của sedan là: " + sedan.getSalePrice(600));
		
	}
}
