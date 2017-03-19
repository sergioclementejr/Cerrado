package com.cerradoSic.model.valueObjects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mensalidade")
public class Mensalidade {
	@Id
	@GeneratedValue
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
	public String toString() {
		return "Mensalidade [id=" + id + ", nome=" + nome + ", valor=" + valor + "]";
	}

}
