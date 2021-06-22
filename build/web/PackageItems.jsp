

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
                    <a href="ViewServlet" class="navbar-brand"> Package Details </a>
                </div>
            </nav>
        </header>
        <div class="container col-md-10"><center>
                <h3 class="text-center">Package Details</h3>
                <div class="card"  style="width: 46rem;">
                    <div class="card-body">
                        <form class="well form-horizontal"  method="post"  >
                            <fieldset>
                                <div class="form-group">
                                    <label class="col-md-8 control-label" >Package Id</label> 
                                    <div class="col-md-15 inputGroupContainer">
                                        <div class="input-group">
                                            <input class="form-control"  type="text" name="packageId" value="<%= request.getAttribute("packageId")%>">

                                        </div>
                                    </div>

                                </div>
                                <table  class="table table-bordered">
                                    <tr>
                                        <th>Item Name</th>
                                        <th>Quantity </th>
                                        <c:forEach var="user" items="${OrderNo}">
                                        <tr id="row1">
                                            <td>
                                                <c:out value="${user.getProductName()}" />
                                            </td>
                                            <td>
                                                <c:out value="${user.getQuantityPacked()}" />
                                            </td>
                                        </tr> </c:forEach>
                                </table><br>
                                &nbsp;&nbsp; 
                        </fieldset>
                        </form></div>
       </body>
   </html>
