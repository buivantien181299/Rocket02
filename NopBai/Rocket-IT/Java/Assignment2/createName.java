
import java.time.LocalDate;
import java.time.Month;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class createName {
	
	public static LocalDate between(LocalDate startInclusive, LocalDate endExclusive) {
	    long startEpochDay = startInclusive.toEpochDay();
	    long endEpochDay = endExclusive.toEpochDay();
	    long randomDay = ThreadLocalRandom
	      .current()
	      .nextLong(startEpochDay, endEpochDay);
	 
	    return LocalDate.ofEpochDay(randomDay);
	}

	public static void main(String[] args) {
		Random random = new Random();
		String[] ho = { "bui", "cao","ha", "nguyen", "le", "ngo", "vo" };
		String[] dem = { "thi", "van", "thu", "viet", "minh", "trung", "lan"  };
		String[] ten = { "ngan", "tien", "thao", "tuan", "anh", "huong", "nguyet" };

		String[] hovaten = new String[10];
		
		for (int i = 0; i < hovaten.length ; i++) {

			int randomHo = random.nextInt(ho.length);
			int randomDem = random.nextInt(dem.length);
			int randomTen = random.nextInt(ten.length);
			

			hovaten[i] = ho[randomHo] + " " + dem[randomDem] + " " + ten[randomTen];
			
			System.out.println(hovaten[i]);

		}

		String[] Id = new String[10];
		for(int i = 0; i < Id.length ; i++) {
			int randomId1 = random.nextInt(10);
			int randomId2 = random.nextInt(10);
			int randomId3 = random.nextInt(10);
			int randomId4 = random.nextInt(10);
			int randomId5 = random.nextInt(10);
			int randomId6 = random.nextInt(10);
			int randomId7 = random.nextInt(10);
			
			Id[i] = "SV" + randomId1 + randomId2 + randomId3 + randomId4 + randomId5 + randomId6 + randomId7;
			
			System.out.println(Id[i]);
		}
		
		LocalDate[] dateMonth = new LocalDate[10];
		
//		for(int i = 0; i < dateMonth.length; i++ ) {
//			int date = 2 + random.nextInt(29);
//			int month = 2+ random.nextInt(11);
//			
//			dateMonth[i] = date + "/" + month + "/" + 1991;
//			
//			System.out.println(dateMonth[i]);
//		}
//		
		
		LocalDate  start 	= 	LocalDate.of(1991, Month.FEBRUARY, 01);
		LocalDate  end 		= 	LocalDate.of(1991, Month.DECEMBER,31);
		
		for(int i = 0; i < dateMonth.length; i++ ) {
			LocalDate randomDate = createName.between(start, end);
			dateMonth[i] = randomDate;
			System.out.println(dateMonth[i]);
		}
		
		
		System.out.println("full name	"  +"				ID	" + "	Date	");
		System.out.println("__________________________________________________________________________");
		
		for(int i =0; i <10; i++) {
			System.out.println(hovaten[i]+ "					" + Id[i] + "	" + dateMonth[i]);
		}
		
		
		
	}

	

}
