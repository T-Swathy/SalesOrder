

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>
    <body>

        <header>
            <nav class="navbar navbar-expand-md navbar-dark" style="background-color:#05386b">
                <div>
                    <a href="ViewServlet" class="navbar-brand"> All Sales Orders </a>
                </div>


            </nav>

        </header>
        <div class="container col-md-10">
            <div class="card"  style="width: 46rem;">
                <div class="card-body">
                    <form class="well form-horizontal"  method="post"  >
                        <fieldset>




                            <div class="center">
                                <div class="form-group">
                                    <label class="col-md-8 control-label">Customer Name</label>  
                                    <div class="col-md-17 inputGroupContainer">
                                        <div class="input-group">
                                            <input placeholder="Customer Name" class="form-control"  type="text" name="customername" value="<%= request.getAttribute("CustomerName")%>">
                                        </div>
                                    </div>
                                </div>



                                <div class="form-group">
                                    <label class="col-md-8 control-label" >Sales Order Number</label> 
                                    <div class="col-md-15 inputGroupContainer">
                                        <div class="input-group">
                                            <input class="form-control"  type="text" name="salesorderno" value="<%= request.getAttribute("SalesOrderNo")%>">

                                        </div>

                                    </div>

                                </div>

                                <div class="form-group"> 

                                    <label  class="col-md-8 control-label" >Sales Order Date</label>
                                    <div class="col-md-15 inputGroupContainer">
                                        <div class="input-group">
                                            <input class="form-control"  type="date" name="salesorderdate" value="<%= request.getAttribute("SalesOrderDate")%>">
                                        </div>
                                    </div>
                                </div>



                                <div class="form-group"> 

                                    <label  class="col-md-8 control-label" >Expected Shipment Date</label>
                                    <div class="col-md-15 inputGroupContainer">
                                        <div class="input-group">
                                            <input class="form-control"  type="date" name="expectedshipmentdate" value="<%= request.getAttribute("ExpectedShipmentDate")%>">
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group"> 
                                    <label  class="col-md-8 control-label" >Payment Terms</label>
                                    <div class="col-md-15 inputGroupContainer">
                                        <div class="input-group">
                                            <input class="form-control"  type="text" name="paymentterms" value="<%= request.getAttribute("PaymentTerms")%>">
                                        </div>
                                    </div>
                                </div>

                                <table  class="table table-bordered">
                                    <tr>
                                        <th>Item Name</th>
                                        <th>Quantity</th>
                                        <th>Rate</th>
                                        <th></th>
                                        <th>Discount</th>
                                        <th>Amount</th></tr>

                                    <c:forEach var="user" items="${OrderNo}">
                                        <tr id="row1">
                                            <td>
                                                <c:out value="${user.getProductName()}" />
                                            </td>
                                            <td>
                                                <c:out value="${user.getProductQuantity()}" />
                                            </td>

                                            <td>
                                                <c:out value="${user.getProductRate()}" />
                                            </td>
                                            <td>
                                                <c:out value="${user.getQuantityPacked()}" /> packed<br>
                                                <c:out value="${user.getQuantityShipped()}" /> Shipped<br>
                                                <c:out value="${user.getQuantityDelivered()}" /> Delivered
                                            </td>
                                            <td>
                                                <c:out value="${user.getProductDiscount()}" />
                                            </td>
                                            <td>
                                                <c:out value="${user.getProductAmount()}" />
                                            </td>
                                        </tr> </c:forEach>
                                    </table><br>
                                    &nbsp;&nbsp; 

                                    <div class="form-group"> 
                                        <label  class="col-md-8 control-label" >Shipment Charge</label>
                                        <div class="col-md-15 inputGroupContainer">
                                            <div class="input-group">
                                                <input class="form-control"  type="text" id="shipmentcharge" " name="shipmentcharge" value="<%= request.getAttribute("ShipmentCharge")%>">
                                        </div>
                                    </div>
                                </div>

                                <div class="form-group"> 
                                    <label  class="col-md-8 control-label" >Total Amount</label>
                                    <div class="col-md-15 inputGroupContainer">
                                        <div class="input-group">
                                            <input class="form-control"  type="text" id="totalamount" name="totalamount" value="<%= request.getAttribute("TotalAmount")%>">
                                        </div>
                                    </div>
                                </div>


                                &nbsp;&nbsp;            


                        </fieldset>
                    </form></div>
                </body>
                </html>
