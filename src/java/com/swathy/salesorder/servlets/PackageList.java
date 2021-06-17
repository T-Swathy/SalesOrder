package com.swathy.salesorder.servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.swathy.salesorder.repository.OrderDao;
import com.swathy.salesorder.repository.PackageDao;
import com.swathy.salesorder.models.Package;
import com.swathy.salesorder.models.util.ShowData;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(urlPatterns = {"/PackageList"})
public class PackageList extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        List<ShowData> list=PackageDao.getAllPackages();  
        request.setAttribute("listOrders", list);
        ServletContext sc = this.getServletContext();
        RequestDispatcher dispatcher = request.getRequestDispatcher("PackagesView.jsp");
        dispatcher.forward(request, response);
          
        out.close();  }
   
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
