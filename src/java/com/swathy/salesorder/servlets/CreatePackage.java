package com.swathy.salesorder.servlets;

import com.swathy.salesorder.models.Item;
import com.swathy.salesorder.models.util.ShowData;
import com.swathy.salesorder.repository.ItemDao;
import com.swathy.salesorder.repository.PackageDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(urlPatterns = {"/CreatePackage"})
public class CreatePackage extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String sno = request.getParameter("salesOrderNo");
        List<Item> list = ItemDao.getItemByNo(sno);

        List<Item> list1 = ItemDao.getQuantitiesPacked(sno, list);

        // list of item obj 
        request.setAttribute("OrderNo", list1);

        request.setAttribute("salesorderno", sno);

        ServletContext sc = this.getServletContext();
        RequestDispatcher dispatcher = request.getRequestDispatcher("PackagesForm.jsp");
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
    }// </editor-fold>

}
