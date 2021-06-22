

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

    <head>
        <title>All Sales Orders</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>

    <body>

        <header>
            <nav class="navbar navbar-expand-md navbar-dark" style="background-color:#05386b">
            </nav>
        </header>
        <br>

        <div class="row">
            <div class="container">
                <h3 class="text-center">All Sales Orders</h3>
                <hr>
                <div class="container text-left">

                    <a href="<%=request.getContextPath()%>/index.html" class="btn btn-success">Add
                        New Sales Order</a>
                </div>
                <br>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Sales Order No</th>
                            <th>Sales Order Date</th>
                            <th>Customer Name</th>
                            <th>Invoice Status</th>
                            <th>Payment Status</th>
                            <th>Change Status</th>
                            <th> Shipment </th>
                            <th>View</th>
                            <th>Delivered</th>
                            <th>Invoice</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="user" items="${listOrders}">

                            <tr>
                                <td>
                                    <c:out value="${user.getSalesOrderNo()}" />
                                </td>
                                <td>
                                    <c:out value="${user.getSalesOrderDate()}" />
                                </td>
                                <td>
                                    <c:out value="${user.getCustomerName()}" />
                                </td>

                                <td>
                                    <c:out value="${user.getInvoiceStatus()}" />
                                </td>
                                <td>
                                    <c:out value="${user.getPaymentStatus()}" />
                                </td>
                                <td>
                                <a href="CreatePackage?salesOrderNo=<c:out value='${user.getSalesOrderNo()}' />">Create package</a>
                                </td>
                                <td>
                                <a href="PackageList?salesOrderNo=<c:out value='${user.getSalesOrderNo()}' />">Create Shipment</a>
                                </td><td>
                                    <a href="View1Servlet?salesOrderNo=<c:out value='${user.getSalesOrderNo()}' />">View Order</a>
                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                </td>
                                <td>
                                <a href="ShippingList?salesOrderNo=<c:out value='${user.getSalesOrderNo()}' />">Mark as delivered</a>
                                </td>
                                <td>
                                    <a href="InvoiceServlet?salesOrderNo=<c:out value='${user.getSalesOrderNo()}' />">Create Invoice</a>
                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                </td>
                            </tr>
                        </c:forEach>

                    </tbody>

                </table>
            </div>
        </div>
    </body>

</html>


