
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
                <h3 class="text-center">All Shippings</h3>
                <hr>
                <div class="container text-left">


                </div>
                <br>
                <table class="table table-bordered">
                    <thead>
                        <tr>

                            <th>Package Id</th>
                            <th>Shipping Id</th>
                            <th>Shipping Date</th>
                            <th>View Package</th>
                            <th>Delivery</th>
                        </tr>
                    </thead>
                    <tbody>

                        <c:forEach var="user" items="${listOrders}">

                            <tr>

                                <td>
                                    <c:out value="${user.getPackageId()}" />
                                </td>
                                <td>
                                    <c:out value="${user.getShipmentId()}" />
                                </td>
                                <td>
                                    <c:out value="${user.getShipmentDate()}" />
                                </td>
                                <td>
                                    <a href="PackageItemsServlet?packageId=<c:out value='${user.getPackageId()}' />">View Package</a>




                                    &nbsp;&nbsp;&nbsp;&nbsp;
                                </td>
                                <td>
                                    <a href="AddDelivery?packageId=<c:out value='${user.getPackageId()}' />">Mark as delivered</a>




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