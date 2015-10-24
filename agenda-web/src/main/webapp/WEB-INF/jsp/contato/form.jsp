<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Agenda  de contatos - PI3</title>
    <meta charset="UTF-8">
    <c:url var="pathResources" value="/resources" /> <%-- CORRIGE URL DO SISTEMA PARA ACESSAR O DIRETÓRIO RESOURCES --%>
    <link href="${pathResources}/css/reset.css" rel="stylesheet" type="text/css" />
    <link href="${pathResources}/css/estilos.css" rel="stylesheet" type="text/css" />
  </head>
  <body>
    <h1>Agenda Web</h1>
    <form action="IncluirContatoServlet" method="post" accept-charset="UTF-8"
          enctype="application/x-www-form-urlencoded">
      <fieldset>
        <legend>Incluir Contato</legend>
        <p>
          <label for="txtNome">Nome:</label>
          <input type="text" id="txtNome" name="nome" />
        </p>
        <p><label for="txtDtNasc">Data de Nascimento:</label>
          <input type="date" id="txtDtNasc" name="dtnascimento" /></p>
        <p>
          <label for="txtTelefone">Telefone:</label>
          <input type="text" id="txtTelefone" name="telefone" /> </p>
        <p><label for="txtEmail">E-mail:</label> <input type="text" id="txtEmail" name="email" />
        </p>
        <p id="botao"><input type="submit" value="Salvar" /> </p>
      </fieldset>
    </form>
    <hr/>
    <p><a href="Logout">Sair</a> (Logado como ${sessionScope.usuario.nome})</p>
  </body>
</html>
