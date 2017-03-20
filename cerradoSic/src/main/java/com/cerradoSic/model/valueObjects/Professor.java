package com.cerradoSic.model.valueObjects;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cerradoSic.model.enumerators.Genero;
import com.cerradoSic.model.enumerators.GeneroConverter;

@Entity
@Table(name="professor")
public class Professor {
  @Id @GeneratedValue
  @Column(name="idt_professor")
  private int id;
  @Column(name="nme_professor")
  private String nome;
  @Column(name="cod_cref_professor")
  private String cref;
  @Column(name="ind_genero")
  @Convert(converter=GeneroConverter.class)
  private Genero genero;
  @Column(name="dsc_professor")
  private String descricao;
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public String getCref() {
    return cref;
  }
  public void setCref(String cref) {
    this.cref = cref;
  }
  public Genero getGenero() {
    return genero;
  }
  public void setGenero(Genero genero) {
    this.genero = genero;
  }
  public String getDescricao() {
    return descricao;
  }
  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }
  
}
