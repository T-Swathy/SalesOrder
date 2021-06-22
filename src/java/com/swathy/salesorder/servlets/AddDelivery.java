package com.swathy.salesorder.servlets;

import com.swathy.salesorder.models.Item;
import com.swathy.salesorder.models.Order;
import com.swathy.salesorder.repository.ItemDao;
import com.swathy.salesorder.repository.OrderDao;
import com.swathy.salesorder.repository.PackageDao;
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
 
 * @author swathy
 */
@WebServlet(urlPatterns = {"/AddDelivery"})
public class AddDelivery extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String packageId = request.getParameter("packageId");

        int status = PackageDao.updateDeliveryStatus(packageId);
        if (status > 0) {

            ServletContext sc = this.getServletContext();
            RequestDispatcher dispatcher = request.getRequestDispatcher("ShippingList");
            dispatcher.forward(request, response);
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
