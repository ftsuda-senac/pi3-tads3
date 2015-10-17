<%-- 
    Document   : helloWorld
    Created on : 25/09/2015, 21:21:02
    Author     : fernando.tsuda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="bootstrap.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <h1>Hello World!</h1>
        <p>Nome: ${pessoa.nome}</p>
        <p>E-mail: ${pessoa.email}</p>
    </body>
</html>
