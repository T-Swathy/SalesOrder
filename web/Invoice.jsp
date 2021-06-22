

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
    <head>
        <link href="//netdna.bootstrapcdn.com/bootstrap/3.1.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//netdna.bootstrapcdn.com/bootstrap/3.1.0/js/bootstrap.min.js"></script>
        <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
        <style>
            .invoice-title h2, .invoice-title h3 {
                display: inline-block;
            }

            .table > tbody > tr > .no-line {
                border-top: none;
            }

            .table > thead > tr > .no-line {
                border-bottom: none;
            }

            .table > tbody > tr > .thick-line {
                border-top: 2px solid;
            }
        </style>
    </head>
    <body>
        <div class="container">
            <div class="row">
                 <div class="col-xs-12">
                    <div class="invoice-title">
                        <h2>Invoice</h2><h3 class="pull-right">Order # "<%= request.getAttribute("SalesOrderNo")%>"</h3>
                    </div>
                    <hr>
                    <div class="row">
                        <div class="col-xs-6">
                            <address>
                                <strong>Billed To:</strong><br>
                                <%= request.getAttribute("CustomerName")%>	  <br>

                            </address>
                        </div>
                        <div class="col-xs-6 text-right">
                            <address>
                                <strong>Shipped To:</strong><br>
                                <%= request.getAttribute("CustomerName")%><br>
                                1234 ,Main<br>
                                Chennai<br>

                            </address>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-6">
                            <address>
                                <strong>Payment Terms:</strong><br>
                                <%= request.getAttribute("PaymentTerms")%><br>

                            </address>
                        </div>
                        <div class="col-xs-6 text-right">
                            <address>
                                <strong>Order Date:</strong><br>
                                <%= request.getAttribute("SalesOrderDate")%><br><br>
                            </address>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title"><strong>Order summary</strong></h3>
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-condensed">
                                    <thead>
                                        <tr>
                                            <td><strong>Item</strong></td>
                                            <td class="text-center"><strong>Price</strong></td>

                                            <td class="text-center"><strong>Quantity</strong></td>
                                            <td class="text-center"><strong>Discount</strong></td>
                                            <td class="text-right"><strong>Totals</strong></td>
                                        </tr>
                                    </thead>
                                    <tbody>
                                       
                                        <c:forEach var="user" items="${OrderNo}">

                                            <tr>
                                                <td>
                                                    <c:out value="${user.getProductName()}" />
                                                </td >
                                                <td class="text-center">
                                                    <c:out value="${user.getProductQuantity()}" />
                                                </td>
                                                <td class="text-center">
                                                    <c:out value="${user.getProductRate()}" />
                                                </td>
                                                <td class="text-center"> 
                                                    <c:out value="${user.getProductDiscount()}" />
                                                </td>
                                                <td class="text-right" >
                                                    <c:out value="${user.getProductAmount()}" />
                                                </td>
                                            </tr> </c:forEach>
                                            <tr>
                                                <td class="no-line"></td>
                                                <td class="no-line"></td>
                                                <td class="no-line"></td>
                                                <td class="no-line text-center"><strong>Shipping</strong></td>
                                                <td class="no-line text-right"><%=request.getAttribute("ShipmentCharge")%></td>
                                        </tr>
                                        <tr>
                                            <td class="no-line"></td>
                                            <td class="no-line"></td>
                                            <td class="no-line"></td>
                                            <td class="no-line text-center"><strong>Total</strong></td>
                                            <td class="no-line text-right"><%= request.getAttribute("TotalAmount")%></td>
                                        </tr>

                                    </tbody>
                                </table>

                            </div>
                        </div>
                    </div>
                </div>
            </div>




            <div>

                <a href="UpdatePayment?salesOrderNo=<%= request.getAttribute("SalesOrderNo")%>" class="btn btn-primary mb-1">Mark as Paid</a>
                </label>
            </div> 

        </div>
        <div class="container text-left">

            <a href="UpdateInvoice?salesOrderNo=<%= request.getAttribute("SalesOrderNo")%>" type="submit" class="btn btn-primary mb-2">Save and Add</a>
        </div>
    </body>
</html>