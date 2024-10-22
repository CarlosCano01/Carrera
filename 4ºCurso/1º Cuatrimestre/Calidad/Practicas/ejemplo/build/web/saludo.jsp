<%-- 
    Document   : saludo
    Created on : 26 sept 2023, 18:42:10
    Author     : carlo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello <%= request.getParameter("nombre") %> </h1>
        <p><a href="index.html">Volver...</a></p>
    </body>
</html>
