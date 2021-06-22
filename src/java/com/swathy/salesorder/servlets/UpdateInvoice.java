package com.swathy.salesorder.servlets;

import com.swathy.salesorder.models.Order;

import com.swathy.salesorder.repository.OrderDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/UpdateInvoice"})
public class UpdateInvoice extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        Order e = new Order();
        String salesorderno = request.getParameter("salesOrderNo");

        int status = OrderDao.updateInvoice(salesorderno);
        if (status > 0) {

            out.println("<script type=\"text/javascript\">");
            out.println("alert('Invoice sent successfully!');");
            out.println("</script>");

        }

        request.getRequestDispatcher("ViewServlet").include(request, response);
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
    }// </editor-fold>

}
