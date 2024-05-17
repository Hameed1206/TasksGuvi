package MavenFirst.MavenProjectOne;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//Task 23 MYSQL
public class JDBCconnection {

	static Statement stmnt;
	public void connectToSQL() throws SQLException {
		//Connect to SQL Database
		Connection connect = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/organization", "organization", "Hameed@12");
		stmnt = connect.createStatement();
	}
	
	//A, Write a query to display employee name and salary of employees whose salary are greater than or equal to 2200.
	public void firstQue() throws SQLException {
		System.out.println("           1st Question");
		System.out.println("           ============");
		//Query statement to execute
		ResultSet set = stmnt.executeQuery("select EName, Sal from Employee where Sal>=2200;");
		//getting the salary value as float and formatting to 2 decimal values , Print name and salary
		while (set.next()) {
		float float1 = set.getFloat(2);
		String format = String.format("%.2f", float1);
		System.out.println(set.getString(1)+"     "+format);
	}
		System.out.println("");	    
	}
	
	//B, Write a query to display details of employees who are not getting commission.
	public void secondQue() throws SQLException {
		System.out.println("           2nd Question");
		System.out.println("           ============");
		ResultSet set = stmnt.executeQuery("select * from Employee where Comm is null or comm=0.00;");
		//Get the decimal Values as float and format it to 2 decimal values
	    while (set.next()) {
		float float1 = set.getFloat(6);
		String format = String.format("%.2f", float1);
		float float2 = set.getFloat(7);
		String format2 = String.format("%.2f", float2);
		//Print all values with respect to query
		System.out.println(set.getInt(1)+" || "+set.getString(2)+" || "+set.getString(3)+" || "+set.getInt(4)+" || "+set.getDate(5)+" || "+format+" || "+format2+" || "+set.getInt(8));
	}
	    System.out.println("");
	}
	
	//C, Write a query to display employee name and salary of those employees who don't have their salary in the range of 2500 to 4000.
	public void thirdQue() throws SQLException {
		System.out.println("           3rd Question");
		System.out.println("           ============");
		ResultSet set = stmnt.executeQuery("select EName, Sal from Employee where Sal<2500 or Sal>4000;");
	    while (set.next()) {
		float float1 = set.getFloat(2);
		String format = String.format("%.2f", float1);
		System.out.println(set.getString(1)+"     "+format);
    }
	    System.out.println("");
	}
	
	//D, Write a query to display the name, job title, and salary of employees who don't have a manager.
	public void fourthQue() throws SQLException {
		System.out.println("           4th Question");
		System.out.println("           ============");
		ResultSet set = stmnt.executeQuery("select EName, Job , Sal from Employee where MGR is Null;");
	    while (set.next()) {
		float float1 = set.getFloat(3);
		String format = String.format("%.2f", float1);
		System.out.println(set.getString(1)+"   "+set.getString(2)+"   "+format);
    }
	    System.out.println("");
	}
	//E, Write a query to display the name of an employee whose name contains 'A' as third alphabet.
	public void fifthQue() throws SQLException {
		System.out.println("           5th Question");
		System.out.println("           ============");
		ResultSet set = stmnt.executeQuery("select EName from Employee where substring(EName , 3, 1) = 'A';");
	    while (set.next()) {
		System.out.println(set.getString(1));	
    }
	    System.out.println("");
	}

	//F, Write a query to display the name of an employee whose name contains 'T' as the last alphabet.
	public void sixthQue() throws SQLException {
		System.out.println("           6th Question");
		System.out.println("           ============");
		ResultSet set = stmnt.executeQuery("select EName from Employee where right(EName , 1) = 'T';");
	    while (set.next()) {
		System.out.println(set.getString(1));
	}
	}
	//2, Create Table and add values
	public void createTableinSQL() throws SQLException {
		 //commands to create table and add values
		 stmnt.executeUpdate("create table Employee_Details (EmpCode int(10), EmpName varchar(40), EmpAge int(3), EmpSalary int(10))");
         stmnt.executeUpdate("insert into Employee_Details (EmpCode, EmpName, EmpAge, EmpSalary) "
         + "values(101, 'Jenny', 25, 10000), (102, 'Jacky', 30, 20000), (103, 'Joe', 20, 40000), (104, 'John', 40, 80000), (105, 'Shameer', 25, 90000); ");
         System.out.println("Table create and values added");
	}
	public static void main(String[] args) throws SQLException {
		JDBCconnection con = new JDBCconnection();
		con.connectToSQL();
		con.firstQue();
		con.secondQue();
		con.thirdQue();
		con.fourthQue();
		con.fifthQue();
		con.sixthQue();
		con.createTableinSQL();
		
		
		
		
	
		
		    
		
			
		
		

	}

}
 