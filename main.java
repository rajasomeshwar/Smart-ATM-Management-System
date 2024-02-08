package javaproject_Banking;
import java.util.Scanner;
public class main  implements colourchange {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		try {
			System.out.print("\033\143");
			pattern.display();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Scanner sc=new Scanner(System.in);
		
		System.out.println(PURPLE_BOLD_BRIGHT+"\t\t\t\t\t\t\t\t\t\t\t\t Press any key to continue"+WHITE_BOLD_BRIGHT);
		String bs=sc.nextLine();
		System.out.print("\033\143");

		display displaypurp = new display();
		while(true) {
			
		System.out.print("\033\143");
        displaypurp.main_page();
		}
	}
	

}

