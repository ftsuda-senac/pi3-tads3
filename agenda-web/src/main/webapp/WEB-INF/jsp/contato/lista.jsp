<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Agenda Web - PI3</title>
    <meta charset="UTF-8">
    <c:url var="pathResources" value="/resources" /> <%-- CORRIGE URL DO SISTEMA PARA ACESSAR O DIRETÓRIO RESOURCES --%>
    <link href="${pathResources}/css/reset.css" rel="stylesheet" type="text/css" />
    <link href="${pathResources}/css/estilos.css" rel="stylesheet" type="text/css" />
  </head>

  <body>
    <h1>Agenda Web</h1>
    <table>
      <tr>
        <th>#</th>
        <th>ID</th>
        <th>Nome</th>
        <th>Data Nascimento</th>
        <th>Telefone</th>
        <th>E-mail</th>
      </tr>
      <c:forEach items="${contatos}" var="contato" varStatus="stat">
        <tr>
          <td><c:out value="${stat.count}" /></td>
        <td><c:out value="${contato.id}" /></td>
        <td><c:out value="${contato.nome}" /></td>
        <td><fmt:formatDate value="${contato.dtNascimento}" pattern="dd/MM/yyyy" /></td>
        <td><c:out value="${contato.telefone}" /></td>
        <td><c:out value="${contato.email}" /></td>
        </tr>
      </c:forEach>
    </table>
    <hr/>
    <%-- VERIFICA SE USUÁRIO TEM O PAPEL DE ADMIN --%>
    <c:set var="usuarioAdmin" value="false" />
    <c:forEach var="papel" items="${sessionScope.usuario.papeis}">
      <c:if test="${papel eq 'ADMIN'}">
        <c:set var="usuarioAdmin" value="true" />
      </c:if>
    </c:forEach>
    <c:choose>
      <c:when test="${usuarioAdmin}">
        <p><a href="IncluirContatoServlet">Incluir novo contato</a></p>
      </c:when>
      <c:otherwise>
        <p>Usuário não tem permissão para incluir novo contato</p>
      </c:otherwise>
    </c:choose>
    <p><a href="Logout">Sair</a> (Logado como ${sessionScope.usuario.nome})</p>
  </body>

</html>
