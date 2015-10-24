/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.agendaweb.dao;

import br.senac.tads.pi3.agendaweb.entidade.Contato;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fernando.tsuda
 */
public class ContatoDAO extends CommonDAO {

  public List<Contato> listar() {
    Statement stmt = null;
    Connection conn = null;

    String sql = "SELECT ID_CONTATO, NM_CONTATO, DT_NASCIMENTO, VL_TELEFONE, VL_EMAIL, DT_CADASTRO FROM TB_CONTATO";
    try {
      conn = obterConexao();
      stmt = conn.createStatement();
      ResultSet resultados = stmt.executeQuery(sql);

      List<Contato> listaPessoas = new ArrayList<Contato>();
      while (resultados.next()) {
        Contato p = new Contato(resultados.getLong("ID_CONTATO"), resultados.getString("NM_CONTATO"),
                resultados.getDate("DT_NASCIMENTO"), resultados.getString("VL_TELEFONE"),
                resultados.getString("VL_EMAIL"), resultados.getDate("DT_CADASTRO"));
        listaPessoas.add(p);
      }
      return listaPessoas;

    } catch (SQLException ex) {
      Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      if (stmt != null) {
        try {
          stmt.close();
        } catch (SQLException ex) {
          Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException ex) {
          Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    }
    return null;
  }

  public void incluir(Contato p) {
    PreparedStatement stmt = null;
    Connection conn = null;

    String sql = "INSERT INTO TB_CONTATO (NM_CONTATO, DT_NASCIMENTO, " // ESPACO ANTES DO "
            + "VL_TELEFONE, VL_EMAIL, DT_CADASTRO) VALUES (?, ?, ?, ?, ?)";
    try {
      conn = obterConexao();
      stmt = conn.prepareStatement(sql);
      stmt.setString(1, p.getNome());
      stmt.setDate(2, new java.sql.Date(p.getDtNascimento().getTime()));
      stmt.setString(3, p.getTelefone());
      stmt.setString(4, p.getEmail());
      stmt.setDate(5, new java.sql.Date(p.getDtCadastro().getTime()));
      stmt.executeUpdate();

    } catch (SQLException ex) {
      Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
      if (stmt != null) {
        try {
          stmt.close();
        } catch (SQLException ex) {
          Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      if (conn != null) {
        try {
          conn.close();
        } catch (SQLException ex) {
          Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    }
  }

}
