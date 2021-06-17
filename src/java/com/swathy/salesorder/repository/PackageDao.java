
package com.swathy.salesorder.repository;

import com.swathy.salesorder.config.DbOperations;
import com.swathy.salesorder.models.Order;
import com.swathy.salesorder.models.Package;
import com.swathy.salesorder.models.util.ShowData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class PackageDao {
     public static List<ShowData> getAllPackages(){  
        List<ShowData> list=new ArrayList<ShowData>();  
          
        try{  
            Connection con=DbOperations.getConnection();  
            PreparedStatement ps=con.prepareStatement("select SalesOrder,SalesOrderDate,PackageId,PackageDate from orderdetails inner join  packages using(SalesOrder) where orderStatus='Yet to be shipped'");  
            ResultSet rs=ps.executeQuery();  
            while(rs.next()){  
                ShowData e=new ShowData();  
                e.setSalesOrderNo(rs.getString(1));  
                e.setSalesOrderDate(rs.getString(2)); 
                
              
                e.setPackageId(rs.getString(3));  
                e.setPackageDate(rs.getString(4));
                
                list.add(e);  
            }  
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return list;  
    }  
      public static int deleteFromPackage(String salesorderno){  
        int status=0;  
        try{  
            Connection con=DbOperations.getConnection();  
            PreparedStatement ps=con.prepareStatement("delete from packages where SalesOrder=?");  
            ps.setString(1,salesorderno);  
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception e){e.printStackTrace();}  
          
        return status;  
    }  
      public static Package getPackageNumber(String salesorderno){  
        Package e=new Package();  
      
          
        try{  
            Connection con=DbOperations.getConnection();  
            PreparedStatement ps=con.prepareStatement("select PackageId from packages where SalesOrder=?");  
            ps.setString(1,salesorderno);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setPackageId(rs.getString(1));  
                
            }  
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }  
     public static int savePackage(Package e, String salesOrderNo){  
        int status=0;  
        try{  
            Connection con=DbOperations.getConnection(); 
            PreparedStatement ps=con.prepareStatement(  
                         "insert into packages(PackageId,SalesOrder,PackageDate) values (?,?,?)");  
            ps.setString(1,e.getPackageId());  
            
            ps.setString(2,salesOrderNo);  
            ps.setString(3,e.getPackageDate());  
           
              
            status=ps.executeUpdate();  
              
            con.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
}
