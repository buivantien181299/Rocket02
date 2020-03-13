
public class Sedan extends Car {
	int length;
	
	Sedan(int speed, double regularPrice, int length){
		super(speed,regularPrice);
		this.length = length;
	}
	
	double getSalePrice(double price) {
		if(length > 20) {
			return price = price - price*0.05;
		}
		else {
			return price = price - price*0.1;
		}
	}
}