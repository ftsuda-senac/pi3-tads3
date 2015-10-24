/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.agendaweb.dao;

import br.senac.tads.pi3.agendaweb.entidade.UsuarioSistema;
import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author Fernando
 */
public class UsuarioSistemaDAO extends CommonDAO {
  
  public boolean autenticar(UsuarioSistema usuario) {
    Statement stmt = null;
    Connection conn = null;

    String sql = "SELECT IID_USUARIO, NM_USUARIO FROM TB_PESSOA";
    
    return false;
  }
  
}
