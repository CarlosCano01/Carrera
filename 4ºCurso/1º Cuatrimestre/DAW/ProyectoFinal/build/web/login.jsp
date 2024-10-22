<%-- 
    Document   : login
    Created on : 8 ene 2024, 19:10:58
    Author     : carlo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/estilos.css" />
        <title>Identificarse</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/menu.jspf" %>
        <h1>Identificación</h1>º
        <form method="POST" action="validar">
            <table>
                <tr>
                    <td align="right">NICK:</td>
                    <td><input type="text" name="username"></td>
                </tr>
                <tr>
                    <td align="right">CLAVE: </td>
                    <td><input type="password" name="password"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Login"></td>
                </tr>
            </table>
        </form>
        <%@include file="WEB-INF/jspf/pie.jspf" %>
    </body>
</html>
