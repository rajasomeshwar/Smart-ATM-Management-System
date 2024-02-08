package javaproject_Banking;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
class jdbcCustomer implements colourchange
{
     	Connection con;
     	Statement st;
     	String user;
     	ResultSet rs;
     	Double curam=0.0;
     	BufferedReader bf;
	protected void getDetails(String s)
    	{
		try {
			bf=new BufferedReader(new InputStreamReader(System.in));
		Class.forName("com.mysql.cj.jdbc.Driver");
		user=s;
	    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/tree","root","au@123456");
	    st=con.createStatement();
	    ResultSet rs=st.executeQuery("select * from   templist1 where id="+s);
		
	   if(rs.next()) {
		   curam=rs.getDouble("amount");
	   // System.out.println("current amoutn -"+rs.getDouble("amount"));
	   }
	   else
	   {
		   System.out.println(RED+"pleas try againg");
	   }
		}
		catch(Exception e)
		{
			
		}
    	}
	protected void addAmount(Double x)
	{
		try {
		int y=st.executeUpdate("update templist1 set amount="+(x+curam)+" where id="+user);
		if(y>0)
		{
			System.out.println(CYAN_BOLD_BRIGHT+"COMPLETED TRANSCTION ");
			st.executeUpdate("insert into ministatement values("+user+",'Credit',"+x+","+(x+curam)+","+System.currentTimeMillis()+")");
		}
		}
		catch(Exception e)
		{
			System.out.println("happy"+e);
		}
	}
	private void CashFast()
	{
		System.out.println(BLUE+"Please Enter Amount.");
		System.out.println(PURPLE_BOLD+"(Cash Available:Rs 100,Rs 200,Rs 500,Rs 2000,Rs 200)");
		System.out.print(YELLOW_BOLD+"Rs : "+WHITE_BOLD_BRIGHT);
		try {
			Double d=Double.parseDouble(bf.readLine().trim());
			System.out.flush();
			st=con.createStatement();
			
			ResultSet rs=st.executeQuery("select id,amount,name from templist1 where id="+user);
			rs.next();
			if(rs.getDouble("amount")>=d)
			{
				Double ord=rs.getDouble("amount");
				
				if(ord-d<2000)
				{
					System.out.println(RED+"WARNING\n"+rs.getString("name")+" your balances less than 2000\n make sure to deposite some money into your account");
				}
			
				System.out.println(YELLOW_BOLD_BRIGHT+"Successfully debited");
		    st.executeUpdate("insert into ministatement values("+user+",'Debit',"+d+","+(ord-d)+","+System.currentTimeMillis()+")");
		    st.executeUpdate("update templist1 set amount="+(ord-d)+" where id="+user);
		    return;
			}
			else
			{
				System.out.println(RED_BOLD_BRIGHT+"YOU DOESN'T HAVE ENOUGH MONEY"+RESET);
			}
		}
		catch(Exception e)
		{
			System.out.println(RED+"money can't be Debited"+e);
			CashFast();
		}
	}
	protected void CashWithDrawal()
	{
		System.out.println(BLUE+"Please Select Account Type");
		System.out.println("1                     KCC");
		System.out.println("2                     CURRENT");
		System.out.println("3                     SAVINGS"+WHITE_BOLD_BRIGHT);
		try{int s=Integer.valueOf(bf.readLine().trim());
		 if(1<=s && s<=3) {
			  CashFast();
			  return;
		 }
		System.out.flush();
		}
		catch(Exception e)
		{
			System.out.println(RED+"SOMTHING WENT WORNG PLEASE ENTER AGAIN");
			
		}
		System.out.println(RED+"Please enter correct option");
		CashWithDrawal();
		
	}
	private void finalChange()throws Exception
	{
		System.out.println(BLUE+"enter new pin number : "+WHITE_BOLD_BRIGHT);
		   String new1=bf.readLine();
		   System.out.println(BLUE+"ENTER again pin number :"+WHITE_BOLD_BRIGHT);
		   String new2=bf.readLine();
		   if(new2.equals(new1))
		   {
			   st.executeUpdate("update idpass set pss='"+new2+"' where id='"+user+"'");
			   System.out.println(CYAN_BOLD_BRIGHT+"Updated!");
		   }
		   else
		   {
			   System.out.println(RED_BOLD+"Doesn't matched entered ");
			   finalChange();
		   }
	}
	protected void PinChange()
	{
		System.out.println(BLUE+"Please ENTER previouse PIN number :"+WHITE_BOLD_BRIGHT);
		try
		{
			String prevind=bf.readLine();
			st=con.createStatement();
			//"select * from idpass where id='"+s+"' and pss='"+psw+"'"
		   rs=st.executeQuery("select  * from idpass where id='"+user+"' and pss='"+prevind+"'");
		   if(rs.next())
		   {
			   finalChange();
		   }
		   else {
			   System.out.println(RED+"Invalid pin");
		   
		   PinChange();
		   }
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	protected void FastCash()
	{
		CashFast();
	}
	
	protected void BalanceInquiry()
	{
		try{rs=st.executeQuery("select amount from templist1 where id="+user);
		if(rs.next())
		System.out.println(CYAN_BOLD_BRIGHT+"current Balance => "+WHITE_BOLD_BRIGHT+rs.getDouble("amount"));
		}
		catch(Exception e)
		{
			System.out.println("happing bad");
		}
	}
	protected void Others()
	{
		try {
			System.out.println(PURPLE_BOLD_BRIGHT+"About Account");
			rs=st.executeQuery("select * from templist1 where id="+user);
			if(rs.next())
			{/*
			* after table 
			**/
				
				
				System.out.println(BLUE+         "CARD NUMBER       : "+WHITE_BOLD_BRIGHT+user);
				System.out.println(CYAN+         "ACCOUNT HOLDER    : "+WHITE_BOLD+rs.getString("name"));
				System.out.println(YELLOW_BRIGHT+"BALANCE           : "+WHITE_BOLD_BRIGHT+rs.getDouble("amount"));
				System.out.println(PURPLE+       "TYPE OF ACCOUNT   : "+WHITE_BOLD_BRIGHT+rs.getString("type"));
			    System.out.println(BLUE_BOLD_BRIGHT+"PHONE NUMBER      : "+WHITE_BOLD_BRIGHT+rs.getString("phno"));
				System.out.println(GREEN+        "AGE               : "+WHITE_BOLD_BRIGHT+agecal(rs.getString("dob")));
				System.out.println(BLUE+         "ADDRESS           : "+WHITE_BOLD_BRIGHT+(rs.getString("addres").isEmpty()?"Null":rs.getString("addres")));
				System.out.println(YELLOW_BOLD+  "PIN CODE          : "+WHITE_BOLD_BRIGHT+(rs.getString("pin").isEmpty()?"Null":rs.getString("pin")));
			}
		}
		catch(Exception e)
		{
		   System.out.println(e);	
		}
	}
	private static int agecal(String dobs)
	{
		 
			    LocalDate dob = LocalDate.of(Integer.valueOf(dobs.substring(6)),Integer.valueOf(dobs.substring(3,5)),Integer.valueOf(dobs.substring(0,2)));

			    LocalDate today = LocalDate.now();

			    Period period = Period.between(dob, today);

			    // get the age
			    return period.getYears();

			    // print the age
			   
			  
	}
	protected void MiniStatements()
	{try {
		System.out.println("Details about \n");
		rs=st.executeQuery("select * from ministatement where id="+user);
		int count=1;
	System.out.println(CYAN_BOLD+"S.NO  "+GREEN_BOLD+"TRANSCTION_TYPE   "+PURPLE_BOLD_BRIGHT+"TRAN_AMMOUNT   "+BLUE+"TOTAL_AMMOUNT   "+YELLOW_BOLD_BRIGHT+"DATE_TIME "+WHITE_BOLD_BRIGHT);
	//st.executeUpdate("create table ministatement(id int,type text,curAmt decimal(10,2),afrAmt decimal(10,2),atmde decimal(20))");
	//st.executeUpdate("insert into ministatement values("+user+",'Debit',"+x+","+(x+curam)+","+System.currentTimeMillis());
		while(rs.next())
		{                                 
			System.out.print(count+++"      "+rs.getString("type")+"        "+(rs.getDouble("curAmt")==0.0?"0.0   ":rs.getDouble("curAmt"))+"       ");
			System.out.print(rs.getString("afrAmt")+"        ");
			Date date= new Date(rs.getLong("atmde"));
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String formattedDate = dateFormat.format(date);
			System.out.println("   "+formattedDate);
			
		}
	}
	catch(Exception e)
	{
		
	}
	}
}
public class taskcustomer extends jdbcCustomer {
	String user_id;
	
	private void Deposit()
	{try {
		System.out.println(BLUE+"Enter the money you want to deposit");
		System.out.print(BLUE+" \n Rs: "+WHITE_BOLD_BRIGHT);
		String amount=bf.readLine().trim();
		System.out.flush();
		if(amount.matches("[0-9]*.[0-9]*"))
		{
		
			addAmount(Double.parseDouble(amount));
			return;
		}
		else {
		System.out.println(RED+"Enter correct AMOUnt");
		Deposit();
		}
	}
	catch(Exception e)
	{
		System.out.println(RED_BOLD+"INVALID AMOUNT");
		Deposit();
	}
		
	}
	protected void exit()
	{
		try {
			System.out.print("\033\143");
			pattern.print_visit();
			
			Thread.sleep(6600);
			System.out.println("\033\143");
			System.out.println(WHITE_BOLD_BRIGHT);
			System.exit(0);
		}
		catch(Exception e)
		{
			
		}
	}
	public void performAction(String user_id,int option) throws IOException
	{
		this.user_id=user_id;
		  getDetails(user_id);
		 switch(option)
		 {
		 case 1:Deposit();break;
		 case 2:FastCash();break;
		 case 3:CashWithDrawal();break;
		 case 4:PinChange();break;
		 case 5:BalanceInquiry();break;
		 case 6:Others();break;
		 case 7:MiniStatements();break;
		 case 8:exit();break;
		 }
		 System.out.println(GREEN_BOLD_BRIGHT+"Press any key to continue menu page"+WHITE_BOLD_BRIGHT);
		 bf.readLine().trim();
		 System.out.print("\033\143");
	}

}

