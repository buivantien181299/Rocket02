package PracticInheritan;

public class Car {
	int speed;
	double regularPrice;
	
	Car(int speed, double regularPrice){
		this.speed = speed;
		this.regularPrice = regularPrice;
	}
	
	String color;
	double getSalePrice(double price) {
		return price;
	}
}
