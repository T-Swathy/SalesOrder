package com.swathy.salesorder.servlets;


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
        PrintWriter out = response.getWriter();

        String packageId = request.getParameter("packageid");
        String salesorderno = request.getParameter("salesorderno");
        String packageDate = request.getParameter("packagedate");
        String[] quantity = request.getParameterValues("quantity[]");
        String[] productName = request.getParameterValues("productName[]");
        String[] productQuantity = request.getParameterValues("productQuantity[]");

        Package p = new Package();

        p.setPackageId(packageId);
        p.setPackageDate(packageDate);
        p.setQuantity(quantity);
        p.setItemName(productName);

        int status = PackageDao.savePackage(p, salesorderno) & PackageDao.savePackageItems(p);
        if (status > 0) {

            out.println("<script type=\"text/javascript\">");
            out.println("alert('Package created successfully!');");
            out.println("</script>");
            request.getRequestDispatcher("ViewServlet").include(request, response);
        } else {

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
