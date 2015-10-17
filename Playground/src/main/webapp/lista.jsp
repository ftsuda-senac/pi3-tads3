<%-- 
    Document   : helloWorld
    Created on : 25/09/2015, 21:21:02
    Author     : fernando.tsuda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
       <table>
           <tr>
               <th>#</th>
               <th>Nome</th>
               <th>E-mail</th>
           </tr>
           <c:forEach items="${pessoas}" var="pes" varStatus="stat">
           <tr>
               <td>${stat.count}</td>
               <td>${pes.nome}</td>
               <td><fmt:formatDate value="${pes.dtNascimento}" pattern="dd/MM/yyyy" /></td>
               <td>${pes.telefone}</td>
               <td>${pes.email}</td>
           </tr>
           </c:forEach> 
       </table>
       <a href="index.html">Voltar</a>
    </body>
</html>
