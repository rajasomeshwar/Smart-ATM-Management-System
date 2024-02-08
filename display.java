package javaproject_Banking;
import java.io.*;
import java.sql.*;
class jdbcSet implements colourchange {
	protected boolean jbdcpm(String s,String psw)throws Exception
	{ 
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tree","root","au@123456");
    Statement st=con.createStatement();
    ResultSet r=st.executeQuery("select * from idpass where id='"+s+"' and pss='"+psw+"'");
    if(r.next())
    {
    	return true;
    }
		}
			catch(Exception e)
			{
				System.out.println(e);
			}
	return false;
	}
}
class ATM extends jdbcSet 
{
	BufferedReader bf;
	private void SIMPLE()throws Exception
	{
		System.out.println(YELLOW+"\tENTER ANY NUMBER \n\tBETWEEN 10 AND 99\n\tFor eg.\"26\": "+WHITE_BOLD_BRIGHT);
		String tet=bf.readLine().trim();
		System.out.flush();
		if(tet.matches("[1-9][0-9]"))
		{
			System.out.println(YELLOW+"\tENTERED Number: "+WHITE_BOLD_BRIGHT+tet);
		}
		System.out.println(CYAN_BOLD+"\tENTER "+GREEN+"\"YES\""+CYAN_BOLD+" IF THE NUMBER IS DISPLAYED");
		System.out.println(CYAN_BOLD+"\tENTER "+GREEN+"\"NO\""+CYAN_BOLD+" IF THE NUMBER IS NOT DISPLAYED."+WHITE_BOLD_BRIGHT);
		tet=bf.readLine().trim().toLowerCase();
		if(tet.contains("no"))
		{
			System.out.println(RED_BOLD_BRIGHT+"Try After some time !");
			System.exit(0);
		}
		System.out.flush();
		
	}
	public String  ATM_ENTER() throws Exception
	{
		bf=new BufferedReader(new InputStreamReader(System.in));
	
		System.out.println(YELLOW_BOLD_BRIGHT+"\t\t\t\t************"+BLUE_BOLD+"WECLOME"+YELLOW_BOLD_BRIGHT+"**************");
		String s="121 2";
		while(true) {
		if(s!="121 2")
			System.out.println(RED_BOLD_BRIGHT+"wrong password"+ANSI_RESET);
		s="121 2";
				while(s.matches("[0-9]*")!=true)
				{
				System.out.print(BLUE+"ENTER YOUR CARD NUMBER: "+WHITE_BOLD_BRIGHT);
					s=bf.readLine().trim();
					System.out.flush();
					if(s.matches("[0-9]*")!=true)
					{
						System.out.println(RED_BOLD+"INCORRECT CARD NUMBER PLEASE ENTER VALID CARD NUMBER");
					}
			
			}
			System.out.print(BLUE+"ENTER YOUR PASSWORD: "+WHITE_BOLD_BRIGHT);
			String password=bf.readLine();
			System.out.flush();
			if(jbdcpm(s,password))
			{
				System.out.println(YELLOW_BOLD_BRIGHT+"\n\t\tCONNECTED TO USER...");
				/*
				 * for next page 
				 */
				Thread.sleep(3000);
			     System.out.print("\033\143");
				return s;
			}
	}
		
		
	}
	int a=-1;
	public int MENU()throws Exception
	{
	
        if(a!=-1)
		 a=-32;
		 if(a==-1) {
		SIMPLE();
		 }
		 System.out.println(GREEN_BOLD_BRIGHT+"PLEASE SELECT TRANSACTION");
		String y=YELLOW_BOLD_BRIGHT;
		System.out.println("\t"+BLUE+"1"+YELLOW_BOLD_BRIGHT+"->"+BLUE+"CREDIT                                        "+2+y+"->"+BLUE+"FAST CASH");
		System.out.println(     "\t3"+y+"->"+BLUE+"CASH WITHDRAWAL                               4"+y+"->"+BLUE+"PIN CHANGE");
		System.out.println(     "\t5"+y+"->"+BLUE+"BALANCE INQUIRY                               6"+y+"->"+BLUE+"OTHERS");
		System.out.println(     "\t7"+y+"->"+BLUE+"MINI STATEMENTS                               8"+y+"->"+BLUE+"EXIT ");
		System.out.print("ENTER your OPTION :"+WHITE_BOLD_BRIGHT);
         try {
		a=Integer.parseInt(bf.readLine().trim());
		System.out.flush();
		
         }
         catch(Exception e)
         { System.out.print("\033\143");
        	 System.out.println(RED_BOLD_BRIGHT+"enter correct option");
        	return MENU();
         }
         if(1<=a && a<=8) {
	   return a;
         }
         System.out.println(RED_BOLD_BRIGHT+"INVALID");
         return MENU();
	}
}
public class display extends CreateAccnt{
	ATM object = new ATM();
       public void main_page() throws Exception
                        {
    	          
	                System.out.println(BLUE+"                          ****************WELCOME********************");
	                 System.out.flush();
	                 System.out.println(GREEN_BOLD_BRIGHT +"         "+1+"-->BANKING");
	                 System.out.println(YELLOW_BOLD_BRIGHT+"         "+2+"-->CREATE ACCOUNT"+BLUE);
	                 System.out.print("CHOOSE YOUR OPTION :");
	             System.out.flush();
	             System.out.print(WHITE_BOLD_BRIGHT );
	             BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	             String s="";
	             do {
	              s=bf.readLine().trim();
	              System.out.flush();
	             }while(s.isEmpty());
	             s=s.toLowerCase();
	             if(s.contains("1")||s.contains("one"))
	             {
	            	 
	              System.out.print(RED);
	              /*
	               * FLUSH FUNCTION
	               */
	            	 String user_id=object.ATM_ENTER();
	            	 /*
	            	  * welcome user_id
	            	  * 
	            	  */
	            	 while(true) {
	            	 int option=object.MENU();
	            	 taskcustomer tc = new taskcustomer();
	            	 tc.performAction(user_id,option);
	            	 }
	             }
	             else if(s.contains("2")||s.contains("second")||s.contains("two"))
	             {
	            	//CreateAccnt object =new CreateAccnt();
	            	create_Account();
	             }
	             else
	             {
	            	 System.out.print("\033\143");
	            	 System.out.println(RED_BOLD_BRIGHT+"ENTER CORRECT OPTION\n"+ANSI_RESET);
	            	 main_page();
	             }
	             
	                
           }

}
