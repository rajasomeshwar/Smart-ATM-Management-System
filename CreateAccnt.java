package javaproject_Banking;
import java.io.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;
public class CreateAccnt implements colourchange {

	Connection con;
	Statement st;
	PreparedStatement pst;
	BufferedReader bf;
	protected void create_table()
	{try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tree","root","au@123456");
	
		
		st= con.createStatement();
		//st.executeUpdate("create table test(col int,name text,add text,acc)");
     	st.executeUpdate("create table templist1(id int,name text,phno text,addres text,pin text,amount decimal(10,2),dob text,type text)");
		st.executeUpdate("create table ministatement(id int,type text,curAmt decimal(10,2),afrAmt decimal(10,2),atmde decimal(20))");
	}
	catch(Exception e)
	{
		//System.out.println("nothing"+e);
	}
	
		
		
	}
	protected void enter_details()
	{
		try
		{
			bf=new BufferedReader(new InputStreamReader(System.in));
			Random random = new Random();
			String name,ph,addres,pin,dob;
			int rand=random.nextInt(100000-9999)+9999;
			System.out.println(PURPLE_BOLD+"Provided Account no=> "+YELLOW_BOLD_BRIGHT+rand);
			create_table();
			while(true) {
			System.out.print(BLUE+"enter your name : "+WHITE_BOLD_BRIGHT);
			String s=bf.readLine();
			System.out.flush();
			if(!s.matches("[a-zA-Z\\s]+"))
			{
				 System.out.println(RED_BOLD_BRIGHT+"Name doesn't Conatins special Sysmbol or any numbers");
			}
			else
			{
				name=s;
				break;
			}
			}
			while(true) {
			System.out.print(BLUE+"enter your phone number : "+WHITE_BOLD_BRIGHT);
			ph=bf.readLine();
			ph=ph.trim();
			if(!(ph.matches("[0-9]{10,15}")))
			{
				System.out.println(RED_BOLD_BRIGHT+"Enter Valid phone number");
			}
			else
			{
			  break;	
			}
			}
			System.out.print(BLUE+"enter your address : "+WHITE_BOLD_BRIGHT);
			addres=bf.readLine();
			System.out.flush();
			System.out.print(BLUE+"enter pin code : "+WHITE_BOLD_BRIGHT);
			pin=bf.readLine();
			System.out.flush();
			while(true)
			{
			System.out.print(BLUE+"enter Date of Birth(DD-MM-YYYY) : "+WHITE_BOLD_BRIGHT);
			dob=bf.readLine();
			  if(!DateValidator.check1(dob))
			  {
				  System.out.println(RED_BOLD_BRIGHT+"INVALID DATE");
			  }
			  else
			  {
				  break;
			  }
			}
			String sv;
			while(true)
			{
			
				System.out.print(BLUE+"Enter account type: "+WHITE_BOLD_BRIGHT);
				System.out.flush();
				sv=bf.readLine().trim().toLowerCase();
				System.out.flush();
				if(sv.contains("saving")||sv.contains("current"))
					break;
				else
				{
					System.out.println(RED_BOLD_BRIGHT+"INVALID ACCOUNT TYPE");
				}
			}
			
			
			st=con.createStatement();             
		    st.executeUpdate("insert into templist1 values("+rand+",'"+name+"','"+ph+"','"+addres+"','"+pin+"',"+(sv.contains("current")?2000:0)+",'"+dob+"','"+sv+"')");
		    st.executeUpdate("insert into idpass values("+rand+",'12345')");
		    st.executeUpdate("insert into ministatement values("+rand+",'Creadit',"+(sv.contains("current")?2000:0)+","+(sv.contains("current")?2000:0)+","+System.currentTimeMillis()+")");
 			con.setAutoCommit(true);
		}
		catch (Exception e)
		{
			System.out.println("j"+e);
		}
		
	}
	private void all_d()
	{
		try {
			System.out.println("list ");
		st=con.createStatement();
		ResultSet rs=st.executeQuery("select * from templist1");
		while(rs.next()==true)
		{
			System.out.println(rs.getInt("id")+"   "+rs.getString("name")+"   "+rs.getDouble("amount"));
		}
		}
		catch(Exception e)
		{
			
		}
		
	}
 public void create_Account()throws Exception
 {
	 create_table();
	 enter_details();
	// all_d();
	 System.out.println(YELLOW_BOLD+"Account Created Completed !");
	 //detailsofacc();
	 //edit();
	 System.out.println(GREEN_BOLD+"Press any key to continue ");
	 bf.read();
	 System.out.println("\033\143");
 }
}

 class DateValidator {
    public static boolean isDateValid(String dateStr, String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false); // disable lenient parsing

        try {
            Date date = sdf.parse(dateStr);
            return date != null;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean check1(String dateStr) {
        String dateFormat = "dd-MM-yyyy";
         return isDateValid(dateStr, dateFormat);
        
       
    }
}




