/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.agendaweb.servlet;

import br.senac.tads.pi3.agendaweb.dao.ContatoDAO;
import br.senac.tads.pi3.agendaweb.entidade.Contato;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fernando
 */
@WebServlet(name = "ListarContatosServlet", urlPatterns = {"/ListarContatosServlet"})
public class ListarContatosServlet extends HttpServlet {

  /**
   * Busca e apresenta na tela os contatos cadastrados no sistema
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

    ContatoDAO dao = new ContatoDAO();
    List<Contato> listaContatos = dao.listar();

    request.setAttribute("contatos", listaContatos);
    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/contato/lista.jsp");
    rd.forward(request, response);
  }

}
