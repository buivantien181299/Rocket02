
public class Ford extends Car{
	int year;
	int manufacturerDiscount;
	
	Ford(int speed, double regularPrice, int year, int manufacturerDiscount){
		super(speed, regularPrice);
		this.year = year;
		this.manufacturerDiscount= manufacturerDiscount;
	}
	
	double getSalePrice(double price) {
		return price -= manufacturerDiscount;
	}
}
