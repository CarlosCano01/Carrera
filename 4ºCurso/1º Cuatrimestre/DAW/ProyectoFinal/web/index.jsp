<%-- 
    Document   : index
    Created on : 8 ene 2024, 19:09:37
    Author     : carlo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/estilos.css" />
        <title>Home</title>
    </head>
    <body>
        <%@include file="WEB-INF/jspf/menu.jspf" %>
        <c:if test="${requestScope.msg!=null}"><p>${requestScope.msg}</p></c:if>
        

        <c:if test="${sessionScope.user!=null}"> Hola ${sessionScope.user}</c:if>
        
        <h1>title</h1>
        <%@include file="WEB-INF/jspf/pie.jspf" %>
    </body>
</html>
