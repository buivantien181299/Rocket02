
public class Truck extends Car {
	int weight;
	
	Truck(int speed, double regularPrice, int weight){
		super(speed, regularPrice);
		this.weight = weight;
	}
	
	double getSalePrice(double price){
		if(weight > 2000) {
			return price = price - price*0.1;
		}
		else {
			return price = price - price*0.2;
		}
	}
}
