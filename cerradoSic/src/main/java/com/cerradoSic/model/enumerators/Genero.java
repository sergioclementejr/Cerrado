package com.cerradoSic.model.enumerators;

public enum Genero {

  MASCULINO(1,'M',"Masculino"),
  FEMININO(2,'F',"Feminino");
  
  private int id;
  private char acronimo;
  private String descricao;
  
  private Genero(int id, char acronimo, String descricao) {
    this.id = id;
    this.acronimo = acronimo;
    this.descricao = descricao;
  }
  
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getDescricao() {
    return descricao;
  }
  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }
  public char getAcronimo() {
    return acronimo;
  }
  public void setAcronimo(char acronimo) {
    this.acronimo = acronimo;
  }
  
}
