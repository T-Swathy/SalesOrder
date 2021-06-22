
package com.swathy.salesorder.config;


import java.sql.Connection;
import java.sql.DriverManager;


/**
 *
 * @author swathy
 */
public class DbOperations {
    public static Connection getConnection(){  
        Connection con = null;  
        try{  
            Class.forName("com.mysql.cj.jdbc.Driver");  
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/salesorder","root",null);  
        }catch(Exception e){System.out.println(e);}  
        return con;  
    } 
   
}
