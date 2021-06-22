package com.swathy.salesorder.servlets;

import com.swathy.salesorder.models.Item;
import com.swathy.salesorder.repository.OrderDao;
import com.swathy.salesorder.repository.PackageDao;
import com.swathy.salesorder.models.Package;
import com.swathy.salesorder.models.util.ShowData;
import com.swathy.salesorder.repository.ItemDao;
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
        String sno = request.getParameter("salesOrderNo");
        List<ShowData> list = PackageDao.getAllPackages(sno);

        request.setAttribute("listOrders", list);
        ServletContext sc = this.getServletContext();
        RequestDispatcher dispatcher = request.getRequestDispatcher("PackagesView.jsp");
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
