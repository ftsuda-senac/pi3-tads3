/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.ftsuda.playground;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author fernando.tsuda
 */
@WebServlet(name = "HelloWorldServlet", 
        urlPatterns = {"/HelloWorldServlet"})
public class HelloWorldServlet extends HttpServlet {


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        ContatosDAO dao = new ContatosDAO();
        List<Pessoa> listaPessoas = dao.listarPessoas();
        
        request.setAttribute("pessoas", listaPessoas);
        
        RequestDispatcher disp =
                request.getRequestDispatcher("lista.jsp");
        disp.forward(request, response);
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
        String nome = request.getParameter("nome");
        String dtNascimento = request.getParameter("dtnascimento");
        String telefone = request.getParameter("telefone");
        String email = request.getParameter("email");

        DateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");
        Date dataNasc = null;
        try {
            dataNasc = formatadorData.parse(dtNascimento);
        } catch (ParseException ex) {
            dataNasc = new Date();
        }

        Pessoa p = new Pessoa();
        p.setNome(nome);
        p.setDtNascimento(dataNasc);
        p.setEmail(email);
        p.setTelefone(telefone);
        p.setDtCadastro(new Date());
        
        ContatosDAO dao = new ContatosDAO();
        dao.incluirPessoa(p);
        
        request.setAttribute("pessoa", p);
        
        RequestDispatcher disp =
                request.getRequestDispatcher("helloWorld.jsp");
        disp.forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
