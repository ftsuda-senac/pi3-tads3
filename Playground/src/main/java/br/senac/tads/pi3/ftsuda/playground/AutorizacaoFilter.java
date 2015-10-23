/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.ftsuda.playground;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * http://www.journaldev.com/1933/java-servlet-filter-example-tutorial
 *
 * @author fernando.tsuda
 */
@WebFilter(filterName = "AutorizacaoFilter", servletNames = {"ListaServlet", "IncluirPessoaServlet"})
public class AutorizacaoFilter implements Filter {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response,
          FilterChain chain)
          throws IOException, ServletException {

    // 1) OBTEM AS INFORMACOES DO USUARIO DA SESSAO
    
    // 2) NA LÓGICA IMPLEMENTADA, SE EXISTIR OBJETO DO USUÁRIO SIGNIFICA
    //    QUE USUÁRIO ESTÁ LOGADO
    //    CASO CONTRÁRIO, REDIRECIONA PARA TELA DE LOGIN
    
    // 3) VERIFICAR SE USUARIO PODE ACESSAR PAGINA. SE PUDER, CONTINUA PROCESSAMENTO.
    //    SE NÃO PUDER, REDIRECIONA PARA TELA DE ERRO.
    
  }

  /**
   * Método que verifica se o usuário possui o(s) papel(is) necessário(s) para
   * acessar a funcionalidade
   * 
   * @param usuario
   * @param req
   * @param resp
   * @return 
   */
  private static boolean verificarAcesso(UsuarioSistema usuario, HttpServletRequest req, HttpServletResponse resp) {
    String pagina = req.getRequestURI();
    if (pagina.endsWith("HelloWorldServlet") && usuario.autorizado("BASICO")) {
      return true;
    } else if (pagina.endsWith("IncluirPessoaServlet") && usuario.autorizado("ADMIN")) {
      return true;
    }
    return false;
  }

  /**
   * ROTINA PARA DESTRUIÇÃO DO FILTRO
   */
  @Override
  public void destroy() {
  }

  /**
   * ROTINA DE INICIALIZAÇÃO DO FILTRO
   */
  @Override
  public void init(FilterConfig filterConfig) {

  }
}
