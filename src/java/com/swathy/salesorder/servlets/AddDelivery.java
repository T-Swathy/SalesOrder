package com.swathy.salesorder.servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author vanit
 */
@WebServlet(urlPatterns = {"/AddDelivery"})
public class AddDelivery extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String sno = request.getParameter("salesOrderNo");
        Order e = new Order();
        e.setSalesOrderNo(sno);
        Order o = OrderDao.getOrderById(sno);
        List<Item> list = ItemDao.getItemByNo(sno);

        request.setAttribute("CustomerName", o.getCustomerName());
        request.setAttribute("SalesOrderDate", o.getSalesOrderDate());
        request.setAttribute("ExpectedShipmentDate", o.getExpectedShipmentDate());
        request.setAttribute("PaymentTerms", o.getPaymentTerms());
        request.setAttribute("ShipmentCharge", o.getShipmentCharge());
        request.setAttribute("TotalAmount", o.getTotalAmount());
        request.setAttribute("SalesOrderNo", sno);

        request.setAttribute("OrderNo", list);
        ServletContext sc = this.getServletContext();
        RequestDispatcher dispatcher = request.getRequestDispatcher("OrderById.jsp");
        dispatcher.forward(request, response);

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
