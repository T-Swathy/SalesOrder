package com.swathy.salesorder.servlets;

import com.swathy.salesorder.models.Shipping;
import com.swathy.salesorder.repository.OrderDao;
import com.swathy.salesorder.repository.ShippingDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vanit
 */
@WebServlet(urlPatterns = {"/AddShipment"})
public class AddShipment extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String packageId = request.getParameter("packageid");
        String salesorderno = request.getParameter("salesorderno");
        String shippingId = request.getParameter("shipmentid");
        String shippingDate = request.getParameter("shipmentdate");
        String carrier = request.getParameter("carrier");
        String trackingId = request.getParameter("trackingid");

        Shipping shipment = new Shipping();
        shipment.setShipmentId(shippingId);
        shipment.setShipmentDate(shippingDate);
        shipment.setCarrier(carrier);
        shipment.setTrackingId(trackingId);

        int status = ShippingDao.saveShipment(shipment, packageId, salesorderno) & OrderDao.updateShipment(salesorderno);
        if (status > 0) {

            out.println("<script type=\"text/javascript\">");
            out.println("alert('Shipment created successfully!');");
            out.println("</script>");
            RequestDispatcher dispatcher = request.getRequestDispatcher("ViewServlet");
            dispatcher.forward(request, response);

        } else {

            out.println("<script type=\"text/javascript\">");
            out.println("alert('Sorry! unable to add Shipment');");
            out.println("</script>");
             RequestDispatcher dispatcher = request.getRequestDispatcher("ViewServlet");
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
    }// </editor-fold>

}
