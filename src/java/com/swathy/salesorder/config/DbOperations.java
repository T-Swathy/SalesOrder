/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swathy.salesorder.config;

import com.sun.rmi.rmid.ExecOptionPermission;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 *
 * @author vanit
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
