<%-- 
    Document   : login
    Created on : 23/10/2015, 18:42:47
    Author     : Fernando
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>JSP Page</title>
  </head>
  <body>
    <h1>Login</h1>
    <form action="LoginServlet" method="post">
      <p>
        <label for="txtNome">Nome:</label>
        <input type="text" name="nome" id="txtNome" />
      </p>
      <p>
        <label for="txtSenha">Senha</label>
        <input type="password" name="senha" id="txtSenha" />
      </p>
      <p>
        <input type="submit" value="Entrar" />
      </p>
    </form>
  </body>
</html>
