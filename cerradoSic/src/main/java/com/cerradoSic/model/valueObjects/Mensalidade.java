package com.cerradoSic.model.valueObjects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mensalidade")
public class Mensalidade {
	@Id	@GeneratedValue
	@Column(name = "idt_mensalidade")
	private int id;

	@Column(name = "nom_mensalidade")
	private String nome;

	@Column(name = "vlr_mensalidade")
	private float valor;

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

	public float getValor() {
		return valor;
	}

	public void setValor(float valor) {
		this.valor = valor;
	}

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + id;
    result = prime * result + ((nome == null)? 0: nome.hashCode());
    result = prime * result + Float.floatToIntBits(valor);
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Mensalidade other = (Mensalidade) obj;
    if (id != other.id)
      return false;
    if (nome == null) {
      if (other.nome != null)
        return false;
    }
    else if (!nome.equals(other.nome))
      return false;
    if (Float.floatToIntBits(valor) != Float.floatToIntBits(other.valor))
      return false;
    return true;
  }
}
