<%-- 
    Document   : alta
    Created on : 8 ene 2024, 19:13:31
    Author     : carlo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/estilos.css" />
        <title>Alta</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/menu.jspf" %>
        <h1>Alta Usuario</h1>
        <form method="POST" action="guardar" onsubmit="return chekcForm()">
            <table>
                <tr>
                    <td align="right">NICK:</td><td><input id="user" type="text" name="user"></td>
                </tr>
                <tr>
                    <td align="right">CLAVE: </td><td><input id="pwd1" type="password" name="pw1"></td>
                </tr>
                <tr>
                    <td align="right">REPETIR: </td><td><input id="pwd2" type="password" name="pw2"></td>
                </tr>               
                <tr>
                    <td></td><td><input type="submit" value="Alta"></td>
                </tr>
            </table>
        </form>
        <%@include file="WEB-INF/jspf/pie.jspf" %>
        <script type="text/javascript" src="js/funciones.js"></script>
    </body>
</html>
