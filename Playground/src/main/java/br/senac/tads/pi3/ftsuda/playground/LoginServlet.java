/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.ftsuda.playground;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Fernando
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/Login"})
public class LoginServlet extends HttpServlet {

  // OBS: Usuarios mantidos em um mapa somente como exemplo.
  // A validação deve ser feita com os dados armazenados no BD.
  private static final Map<String, UsuarioSistema> USUARIOS_CADASTRADOS;

  static {
    USUARIOS_CADASTRADOS = new HashMap<String, UsuarioSistema>();
    USUARIOS_CADASTRADOS.put("fulano", new UsuarioSistema("fulano", "abcd1234", new String[]{"ADMIN", "BASICO"}));
    USUARIOS_CADASTRADOS.put("ciclano", new UsuarioSistema("ciclano", "abcd1234", new String[]{"BASICO"}));
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

  }

  // Implementar aqui a validação do usuário com os dados
  // armazenados no banco de dados.
  private static UsuarioSistema validar(String nome, String senha) {
    UsuarioSistema usuario = USUARIOS_CADASTRADOS.get(nome);
    if (usuario != null && usuario.autenticar(nome, senha)) {
      return usuario;
    }
    return null;
  }

}
