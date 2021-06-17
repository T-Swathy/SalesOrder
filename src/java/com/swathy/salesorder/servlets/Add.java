package com.swathy.salesorder.servlets;


// models
import com.swathy.salesorder.models.Order;
import com.swathy.salesorder.models.Item;
import com.swathy.salesorder.models.Package;
import com.swathy.salesorder.models.Shipping;
import com.swathy.salesorder.repository.ItemDao;

import com.swathy.salesorder.repository.OrderDao;
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
@WebServlet(urlPatterns = {"/Add"})
public class Add extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
              
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String customername=request.getParameter("customername");  
        String salesorderno=request.getParameter("salesorderno");  
        String salesorderdate=request.getParameter("salesorderdate");  
        String expectedshipmentdate=request.getParameter("expectedshipmentdate");  
        String paymentterms=request.getParameter("paymentterms");  
        String shipmentcharge=request.getParameter("shipmentcharge");  
        String totalamount=request.getParameter("totalamount");  
        String[] items=request.getParameterValues("itemname[]");
        String[] quantity=request.getParameterValues("quantity[]");
        String[] rate=request.getParameterValues("rate[]");
        String[] discount=request.getParameterValues("discount[]");
        String[] amount=request.getParameterValues("amount[]");
       
        Order e=new Order();  
        e.setCustomerName(customername);  
        e.setSalesOrderNo(salesorderno);  
        e.setSalesOrderDate(salesorderdate);  
        e.setExpectedShipmentDate( expectedshipmentdate);  
        e.setPaymentTerms(paymentterms); 
        e.setShipmentCharge(shipmentcharge);  
        e.setTotalAmount(totalamount);
        
        Item item = new Item();
        item.setProducts(items);
        item.setQuantity(quantity);
        item.setRate(rate);
        item.setDiscount(discount);
        item.setAmount(amount);
        int status=OrderDao.save(e) & ItemDao.saveItems(item,salesorderno);  
      
        if(status>0){  
          out.println("<script type=\"text/javascript\">");
          out.println("alert('Sales Order Created Successfully ');");
          out.println("</script>");
          request.getRequestDispatcher("index.html").include(request, response);  
        }else{  
             out.println("<script type=\"text/javascript\">");
             out.println("alert('Sorry!The sales order is not created');");
             out.println("</script>");
        }  
          
        out.close();  
    }  
  
        
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
