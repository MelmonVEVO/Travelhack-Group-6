package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class dbstart {
	
	//VALIDATE LOGIN
	@SuppressWarnings({ "null", "unused" })
    public static String validateUserLogin (String username, String password){
        
        String URL = "jdbc:mysql://localhost:3306/traveldb";
        String USER = "root";
        String PASS = "pwd";
        String QUERY = "SELECT * FROM users WHERE username = '"+
            username+"'          AND password = '"+password+"' ";
        try {
			Connection myconn= DriverManager.getConnection("jdbc:mysql://localhost:3306/traveldb", "root", "root");
			Statement mystmt= myconn.createStatement();
        	ResultSet myrs = mystmt.executeQuery(QUERY);
        	while(myrs.next()) {
        		if(myrs!=null) {
        			System.out.println("Success, welcome back " + myrs.getString("username"));
        			return myrs.getString("username");
        		}
        		else {
        			System.out.println("Nope, wrong person");
        		}
        	}
        }   catch (Exception e){
            e.printStackTrace();
    }
	return "bruh";
	}
	
	
	
	//CREATE NEW USER
	@SuppressWarnings({ "null", "unused" })
	public static void createUser(String username, String password) {
		String QUERY = "INSERT INTO `users`(username,password,exp) VALUES ('"+ username + "','"+ password + "'," + 0 +")";
		try {
			Connection myconn= DriverManager.getConnection("jdbc:mysql://localhost:3306/traveldb", "root", "pwd");
			Statement mystmt= myconn.createStatement();
			mystmt.executeUpdate(QUERY);
        	System.out.println("Success! User created.");
        }catch (Exception e){
         e.printStackTrace();
         }
	}

}

