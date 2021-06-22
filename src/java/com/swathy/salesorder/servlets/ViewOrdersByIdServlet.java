package com.swathy.salesorder.servlets;

import com.swathy.salesorder.models.Item;
import com.swathy.salesorder.models.Order;
import com.swathy.salesorder.repository.ItemDao;
import com.swathy.salesorder.repository.OrderDao;
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

@WebServlet(urlPatterns = {"/View1Servlet"})
public class ViewOrdersByIdServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        String sno = request.getParameter("salesOrderNo");
        Order o = OrderDao.getOrderById(sno);
        List<Item> list = ItemDao.getItemByNo(sno);
        List<Item> list1 = ItemDao.getQuantitiesPacked(sno, list);
        List<Item> list2 = ItemDao.getQuantitiesShipped(sno, list1);
        List<Item> list3 = ItemDao.getQuantitiesDelivered(sno, list2);

        request.setAttribute("CustomerName", o.getCustomerName());
        request.setAttribute("SalesOrderDate", o.getSalesOrderDate());
        request.setAttribute("ExpectedShipmentDate", o.getExpectedShipmentDate());
        request.setAttribute("PaymentTerms", o.getPaymentTerms());
        request.setAttribute("ShipmentCharge", o.getShipmentCharge());
        request.setAttribute("TotalAmount", o.getTotalAmount());
        request.setAttribute("SalesOrderNo", sno);

        request.setAttribute("OrderNo", list3);
        ServletContext sc = this.getServletContext();
        RequestDispatcher dispatcher = request.getRequestDispatcher("OrderById.jsp");
        dispatcher.forward(request, response);

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
