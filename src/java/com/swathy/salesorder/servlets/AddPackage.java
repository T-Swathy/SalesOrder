package com.swathy.salesorder.servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.swathy.salesorder.models.Order;
import com.swathy.salesorder.models.Package;
import com.swathy.salesorder.repository.OrderDao;
import com.swathy.salesorder.repository.PackageDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vanit
 */
@WebServlet(urlPatterns = {"/AddPackage"})
public class AddPackage extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String packageId=request.getParameter("packageid");  
        String salesorderno=request.getParameter("salesorderno");  
        String packageDate=request.getParameter("packagedate");  
       
       
        Order e=new Order();  
        Package p=new Package();
        e.setSalesOrderNo(salesorderno);  
        p.setPackageId(packageId);
        p.setPackageDate(packageDate);
        
        int status=PackageDao.savePackage(p,salesorderno) & OrderDao.updatePackage(salesorderno);  
        if(status>0){  
          
          out.println("<script type=\"text/javascript\">");
          out.println("alert('Package created successfully!');");
          out.println("</script>");
            request.getRequestDispatcher("index.html").include(request, response);  
        }else{  
          
          out.println("<script type=\"text/javascript\">");
          out.println("alert('Sorry! unable to create package');");
          out.println("</script>");
        }  
          
        out.close();  
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
