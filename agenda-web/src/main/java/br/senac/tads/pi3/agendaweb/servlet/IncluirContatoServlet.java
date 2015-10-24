/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.agendaweb.servlet;

import br.senac.tads.pi3.agendaweb.dao.ContatoDAO;
import br.senac.tads.pi3.agendaweb.entidade.Contato;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "IncluirContatoServlet", urlPatterns = {"/IncluirContatoServlet"})
public class IncluirContatoServlet extends HttpServlet {

  /**
   * Para inclusão, é usado para apresentar formulario de cadastro para o
   * usuário
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/contato/form.jsp");
    rd.forward(request, response);
  }

  /**
   * Salva os dados digitados e faz redirect para a lista (POST-REDIRECT-GET)
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    String nome = request.getParameter("nome");
    String dtNascimentoStr = request.getParameter("dtnascimento");
    String telefone = request.getParameter("telefone");
    String email = request.getParameter("email");
    
    DateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");
    Date dtNascimento = null;
    try {
      dtNascimento = formatadorData.parse(dtNascimentoStr);
    } catch (ParseException ex) {
      dtNascimento = new Date();
    }
    
    Contato c = new Contato(nome, dtNascimento, telefone, email, new Date());
    
    try {
      ContatoDAO dao = new ContatoDAO();
      dao.incluir(c);
      response.sendRedirect("ListarContatosServlet");
    } catch (Exception e) {
      response.sendRedirect("IncluirContatoServlet");
    }
  }
  
}
