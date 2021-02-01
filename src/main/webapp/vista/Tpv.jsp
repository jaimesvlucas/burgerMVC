<%-- 
    Document   : Tpv
    Created on : 29 ene. 2021, 21:18:54
    Author     : User
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Producto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <title>JSP Page</title>
    </head>
    <body>
        <%
            ArrayList<Producto> hamburguesas = (ArrayList<Producto>) request.getAttribute("hamburguesas");
            ArrayList<Producto> complementos = (ArrayList<Producto>) request.getAttribute("complementos");
            ArrayList<Producto> bebidas = (ArrayList<Producto>) request.getAttribute("bebidas");
        %>
        <div class='container'>
            <h1>Hamburgueseria Bosco!</h1>
            <form action="TpvServlet" method="post" >
                <ul class="nav nav-tabs" id="myTab" role="tablist">
                    <li class="nav-item">
                      <a class="nav-link active" id="hamburguesas-tab" data-toggle="tab" href="#hamburguesas" role="tab" aria-controls="hamburguesas" aria-selected="true">Hamburguesas</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" id="bebidas-tab" data-toggle="tab" href="#bebidas" role="tab" aria-controls="bebidas" aria-selected="false">Bebidas</a>
                    </li>
                    <li class="nav-item">
                      <a class="nav-link" id="complementos-tab" data-toggle="tab" href="#complementos" role="tab" aria-controls="complementos" aria-selected="false">Complementos</a>
                    </li>
                </ul>
                <div class="tab-content">
                    <div class="tab-pane active" id="hamburguesas" role="tabpanel" aria-labelledby="hamburguesas-tab">
                        <table>
                            <tr>
                                <th></th>
                                <th>Nombre</th>
                                <th>Precio</th>
                                <th>Unidades</th>
                            </tr>
                            <%for(Producto ham: hamburguesas){%>
                            <tr>
                                <td><img src="<%= ham.getImagen() %>"></td>
                                <td><%= ham.getNombre() %></td>
                                <td><%= ham.getPrecio() %></td>
                                <td><input type="number" value="0" name="<%= ham.getId() %>"></td>
                            </tr>
                            <%}%>
                        </table>
                    </div>
                    <div class="tab-pane" id="bebidas" role="tabpanel" aria-labelledby="bebidas-tab">
                        <table>
                            <tr>
                                <th></th>
                                <th>Nombre</th>
                                <th>Precio</th>
                                <th>Unidades</th>
                            </tr>
                            <%for(Producto b: bebidas){%>
                            <tr>
                                <td><img src="<%= b.getImagen() %>"></td>
                                <td><%= b.getNombre() %></td>
                                <td><%= b.getPrecio() %></td>
                                <td><input type="number" value="0" name="<%= b.getId() %>"></td>
                            </tr>
                            <%}%>
                        </table>
                    </div>
                    <div class="tab-pane" id="complementos" role="tabpanel" aria-labelledby="complementos-tab">
                        <table>
                            <tr>
                                <th></th>
                                <th>Nombre</th>
                                <th>Precio</th>
                                <th>Unidades</th>
                            </tr>
                            <%for(Producto com: complementos){%>
                            <tr>
                                <td><img src="<%= com.getImagen() %>"></td>
                                <td><%= com.getNombre() %></td>
                                <td><%= com.getPrecio() %></td>
                                <td><input type="number" value="0" name="<%= com.getId() %>"></td>
                            </tr>
                            <%}%>
                        </table>
                    </div>
                </div>

                <input class='btn btn-primary' type="submit" value="Realizar pedido">
            </form>
        </div>
    </body>
</html>
