<%-- 
    Document   : user-list
    Created on : 16 Jun, 2021, 9:47:13 PM
    Author     : vanit
--%>

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
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

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
                                <th>Order Status</th>
                                <th>Invoice Status</th>
                                <th>Payment Status</th>
                                <th>Change Status</th>
                                <th>View</th>
                                <th>Invoice</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--   for (Todo todo: todos) {  -->
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
                                        <c:out value="${user.getOrderStatus()}" />
                                    </td>
                                     <td>
                                        <c:out value="${user.getInvoiceStatus()}" />
                                    </td>
                                     <td>
                                        <c:out value="${user.getPaymentStatus()}" />
                                    </td>
                                    <td>
                                       
                                        <c:set var="str"  value="${user.getOrderStatus()}" />
                                        <jsp:useBean id="str" type="java.lang.String" />
                                        <c:if test='<%=str.equalsIgnoreCase("not yet packed")%>'> 
                                        <a href="CreatePackage?salesOrderNo=<c:out value='${user.getSalesOrderNo()}' />">Mark as packed</a>
                                        </c:if>
                                         <c:set var="str1"  value="${user.getOrderStatus()}" />
                                         <jsp:useBean id="str1" type="java.lang.String" />
                                         <c:if test='<%=str1.equalsIgnoreCase("yet to be shipped")%>'> 
                                        <a href="CreateShipment?salesOrderNo=<c:out value='${user.getSalesOrderNo()}' />">Mark as shipped</a>
                                        </c:if>
                                         <c:set var="str2"  value="${user.getOrderStatus()}" />
                                         <jsp:useBean id="str2" type="java.lang.String" />
                                         <c:if test='<%=str1.equalsIgnoreCase("yet to be delivered")%>'> 
                                        <a href="AddDelivery?salesOrderNo=<c:out value='${user.getSalesOrderNo()}' />">Mark as delivered</a>
                                         </c:if></td><td>
                                        <a href="View1Servlet?salesOrderNo=<c:out value='${user.getSalesOrderNo()}' />">View Order</a>
                                       

                                        
      
                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                    </td>
                                    <td>   <a href="UpdatePayment?salesOrderNo=<c:out value='${user.getSalesOrderNo()}' />">Mark as Paid</a>
                                    <td>
                                        <a href="InvoiceServlet?salesOrderNo=<c:out value='${user.getSalesOrderNo()}' />">Create Invoice</a>
                                       

                                        
      
                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                    </td>
                                   
                                    
                                </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                </div>
            </div>
        </body>

        </html>


