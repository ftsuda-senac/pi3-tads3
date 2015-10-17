/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.ftsuda.playground;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fernando.tsuda
 */
public class ContatosDAO {

    /**
     * @param args the command line arguments
     */

    private Connection obterConexao() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        // Passo 1: Registrar driver JDBC.
        Class.forName("org.apache.derby.jdbc.ClientDataSource");

        // Passo 2: Abrir a conexão
        conn = DriverManager.getConnection("jdbc:derby://localhost:1527/agendabd;SecurityMechanism=3",
                "app", // usuario
                "app"); // senha
        return conn;
    }

    public List<Pessoa> listarPessoas() {
        Statement stmt = null;
        Connection conn = null;

        String sql = "SELECT ID_PESSOA, NM_PESSOA, DT_NASCIMENTO, VL_TELEFONE, VL_EMAIL FROM TB_PESSOA";
        try {
            conn = obterConexao();
            stmt = conn.createStatement();
            ResultSet resultados = stmt.executeQuery(sql);

            DateFormat formatadorData = new SimpleDateFormat("dd/MM/yyyy");

            List<Pessoa> listaPessoas = new ArrayList<Pessoa>();
            while (resultados.next()) {
                Pessoa p = new Pessoa();
                p.setId(resultados.getLong("ID_PESSOA"));
                p.setNome(resultados.getString("NM_PESSOA"));
                p.setDtNascimento(resultados.getDate("DT_NASCIMENTO"));
                p.setEmail(resultados.getString("VL_EMAIL"));
                p.setTelefone(resultados.getString("VL_TELEFONE"));
                listaPessoas.add(p);
            }
            return listaPessoas;

        } catch (SQLException ex) {
            Logger.getLogger(ContatosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ContatosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ContatosDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ContatosDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return null;
    }

    public void incluirPessoa(Pessoa p) {
        PreparedStatement stmt = null;
        Connection conn = null;

        String sql = "INSERT INTO TB_PESSOA (NM_PESSOA, DT_NASCIMENTO, " // ESPACO ANTES DO "
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
            System.out.println("Registro incluido com sucesso.");

        } catch (SQLException ex) {
            Logger.getLogger(ContatosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ContatosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ContatosDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ContatosDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

}
