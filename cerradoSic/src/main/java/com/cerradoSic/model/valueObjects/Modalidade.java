package com.cerradoSic.model.valueObjects;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="especialidade")
public class Modalidade {
	
	@Id @GeneratedValue
	@Column(name="idt_modalidade")
	private int id;
	@Column(name="nme_modalidade")
	private String nome;
	@Column(name="dsc_modalidade")
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
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
