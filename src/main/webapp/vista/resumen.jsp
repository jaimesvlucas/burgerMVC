<%-- 
    Document   : resumen
    Created on : 1 feb. 2021, 20:04:45
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
            Float total = (Float) request.getAttribute("total");
            ArrayList<Producto> carrito = (ArrayList<Producto>) request.getAttribute("carrito");
        %>
        <table class="table">
            <tr>
                <th></th>
                <th>Nombre</th>
                <th>Precio</th>
                <th>Unidades</th>
                <th>Total</th>
            </tr>
            <%for(Producto ham: carrito){%>
            <tr>
                <td><img src="<%= ham.getImagen() %>"></td>
                <td><%= ham.getNombre() %></td>
                <td><%= ham.getPrecio() %></td>
                <td><%= ham.getUnidadesPedidas() %></td>
                <td><%= ham.getPrecio()*ham.getUnidadesPedidas()%></td>
            </tr>
            <%}%>
            <tr>
                <td colspan="4"></td>
                <td class="alert alert-danger"> <%=total%> €</td>
            </tr>
        </table>
            <a class='btn btn-primary' href="TpvServlet">Volver</a> 
    </body>
</html>
