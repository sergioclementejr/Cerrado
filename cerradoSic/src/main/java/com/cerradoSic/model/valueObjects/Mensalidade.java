package com.cerradoSic.model.valueObjects;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="mensalidade")
public class Mensalidade {
  @Id @GeneratedValue
  @Column(name="idt_mensalidade")
  private int id;
  
  @Column(name="dta_mes_mensalidade")
  @Type(type="date")
  private Date data;
  
  @Column(name="vlr_mensalidade")
  private float valor;
  
  
  public Mensalidade(){}
  
  public Mensalidade(int id, Date data, float valor) {
    this.id = id;
    this.data = data;
    this.valor = valor;
  }
  
  public Mensalidade(Date data, float valor) {
    this.id = id;
    this.data = data;
    this.valor = valor;
  }
  
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public Date getData() {
    return data;
  }
  public void setData(Date data) {
    this.data = data;
  }
  public float getValor() {
    return valor;
  }
  public void setValor(float valor) {
    this.valor = valor;
  }

  @Override
  public String toString() {
    return "Mensalidade [id=" + id + ", data=" + data + ", valor=" + valor +
      "]";
  }
}
