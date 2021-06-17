<%-- 
    Document   : Package
    Created on : 16 Jun, 2021, 10:27:34 PM
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
            <div class="container col-md-10">
                <div class="card mx-auto"  style="width: 46rem;">
                    <div class="card-body">

                        <div class="container">

                            <h3 class="text-center">Create New Package</h3>
                            <hr>
                        </div>


                        <div class="row">
                            <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                            <div class="container">


                                <br>
                                <table class="table table-bordered">
                                    <form action="AddPackage" method="post">
                                        <div class="form-group"> 
                                            <label  class="col-md-4 control-label" >Sales Order No</label>
                                            <div class="col-md-10 inputGroupContainer">
                                                <div class="input-group">
                                                    <input class="form-control"  type="text"  name="salesorderno" value="<%= request.getAttribute("salesorderno")%>" >
                                                </div>
                                            </div>
                                        </div>

                                        <div class="form-group"> 
                                            <label  class="col-md-4 control-label" >Package #</label>
                                            <div class="col-md-10 inputGroupContainer">
                                                <div class="input-group">
                                                    <input class="form-control"  type="text"  name="packageid">
                                                </div>
                                            </div>
                                        </div>

                                        <div class="form-group"> 
                                            <label  class="col-md-4 control-label" >Package Date</label>
                                            <div class="col-md-10 inputGroupContainer">
                                                <div class="input-group">
                                                    <input class="form-control"  type="text"  name="packagedate">
                                                </div>
                                            </div>
                                        </div>

                                </table>
                                <table class="table table-bordered">
                                    <thead>
                                        <tr>
                                            <th>Item</th>
                                            <th>Quantity</th>

                                        </tr>
                                    </thead>
                                    <tbody>
                                        <!--   for (Todo todo: todos) {  -->
                                        <c:forEach var="order" items="${OrderNo}">

                                            <tr>
                                                <td>
                                                    <c:out value="${order.getProductName()}" />
                                                </td>
                                                <td>
                                                    <c:out value="${order.getProductQuantity()}" />
                                                </td>

                                            </tr>
                                        </c:forEach>
                                        <!-- } -->
                                    </tbody>

                                </table>
                                <button type="submit" class="btn btn-primary mb-2">SUBMIT</button>
                                </form>
                            </div></div>
                    </div>
                    </body>

                    </html>