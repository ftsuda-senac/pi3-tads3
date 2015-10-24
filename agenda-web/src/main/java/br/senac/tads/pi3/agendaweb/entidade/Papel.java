/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.pi3.agendaweb.entidade;

import java.io.Serializable;

/**
 *
 * @author Fernando
 */
public class Papel implements Serializable {
  
  private int id;
  
  private String papel;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getPapel() {
    return papel;
  }

  public void setPapel(String papel) {
    this.papel = papel;
  }
  
}
