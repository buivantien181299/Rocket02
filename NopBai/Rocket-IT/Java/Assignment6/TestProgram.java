import java.util.ArrayList;

public class TestProgram {
	public static void showList(ArrayList<String> list) {
        // Show list through for-each
        for (String obj : list) {
            System.out.print("\t" + obj + ", ");
        }
        System.out.println();
    }

	public static void main(String[] args) {
		
		ArrayList<String> list = new ArrayList<String>();
		
		Professor p = new Professor();
		
		p.input();
		p.ouput();
		p.salarymultiplier();
		
		
		Officials o = new Officials();
		
		o.input();
		o.ouput();
		o.salarymultiplier();
		
		
	}

}
