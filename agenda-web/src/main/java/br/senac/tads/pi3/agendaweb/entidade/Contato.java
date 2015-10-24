/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.agendaweb.entidade;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author fernando.tsuda
 */
public class Contato implements Serializable {

  private Long id;

  private String nome;

  private Date dtNascimento;

  private String telefone;

  private String email;

  private Date dtCadastro;

  public Contato() {

  }

  public Contato(String nome, Date dtNascimento, String telefone, String email, Date dtCadastro) {
    this.nome = nome;
    this.dtNascimento = dtNascimento;
    this.telefone = telefone;
    this.email = email;
    this.dtCadastro = dtCadastro;
  }
  
  public Contato(Long id, String nome, Date dtNascimento, String telefone, String email, Date dtCadastro) {
    this(nome, dtNascimento, telefone, email, dtCadastro);
    this.id = id;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public Date getDtNascimento() {
    return dtNascimento;
  }

  public void setDtNascimento(Date dtNascimento) {
    this.dtNascimento = dtNascimento;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Date getDtCadastro() {
    return dtCadastro;
  }

  public void setDtCadastro(Date dtCadastro) {
    this.dtCadastro = dtCadastro;
  }
}
