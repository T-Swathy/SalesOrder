/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swathy.salesorder.repository;

import com.swathy.salesorder.config.DbOperations;
import com.swathy.salesorder.models.Item;
import com.swathy.salesorder.models.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vanit
 */
public class ItemDao {
     public static List<Item> getItemByNo(String salesorderno){  
        List<Item> list=new ArrayList<Item>();  
       try{  
            Connection con=DbOperations.getConnection();  
            PreparedStatement ps=con.prepareStatement("select ItemName,Quantity,Rate,Discount,Amount from items where SalesOrder=? ");  
            ps.setString(1, salesorderno);
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                Item e=new Item();  
                e.setProductName(rs.getString(1));  
                e.setProductQuantity(rs.getString(2));  
                e.setProductRate(rs.getString(3));
                e.setProductDiscount(rs.getString(4));
                e.setProductAmount(rs.getString(5));
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
      public static int saveItems(Item e, String salesOrderNo){  
        int status=0;  
        try{  
            Connection con=DbOperations.getConnection(); 
            PreparedStatement ps=con.prepareStatement(  
                         "insert into items(SalesOrder,ItemName,Quantity,Rate,Discount,Amount) values (?,?,?,?,?,?)");  
            String[] products=e.getProducts();
            String[] quantities=e.getQuantity();
            String[] rates=e.getRate();
            String[] discounts=e.getDiscount();
            String[] amounts=e.getAmount();
            for(int i=0;i<products.length;i++)
            {
            
            ps.setString(1,salesOrderNo);  
            ps.setString(2,products[i]);
            ps.setString(3,quantities[i]);
            ps.setString(4,rates[i]);
            ps.setString(5,discounts[i]);
            ps.setString(6,amounts[i]);
              
            status=ps.executeUpdate();  
            }
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    
}
