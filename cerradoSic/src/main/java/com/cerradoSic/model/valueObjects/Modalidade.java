package com.cerradoSic.model.valueObjects;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.apache.commons.collections4.CollectionUtils;

@Entity
@Table(name="modalidade")
public class Modalidade {
	@Id @GeneratedValue
	@Column(name="idt_modalidade")
	private int id;
	@Column(name="nme_modalidade")
	private String nome;
	@Column(name="dsc_modalidade")
	private String descricao;
	@ManyToMany(mappedBy="modalidades")
//	@JoinTable(name = "leciona",
//  joinColumns = @JoinColumn(name = "idt_modalidade"),
//  inverseJoinColumns = @JoinColumn(name = "idt_professor"))
  List<Professor> professores = new ArrayList<Professor>();
	
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
  public List<Professor> getProfessores() {
    return professores;
  }
  public void setProfessores(List<Professor> professores) {
    this.professores = professores;
  }
  public void addProfessor(Professor professor){
    if (CollectionUtils.isEmpty(professores)) {
      professores = new ArrayList<Professor>();
    }
    if (professores != null) {
      professores.add(professor);
    }
  }
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result =
      prime * result + ((descricao == null)? 0: descricao.hashCode());
    result = prime * result + id;
    result = prime * result + ((nome == null)? 0: nome.hashCode());
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
    Modalidade other = (Modalidade) obj;
    if (descricao == null) {
      if (other.descricao != null)
        return false;
    }
    else if (!descricao.equals(other.descricao))
      return false;
    if (id != other.id)
      return false;
    if (nome == null) {
      if (other.nome != null)
        return false;
    }
    else if (!nome.equals(other.nome))
      return false;
    return true;
  }
}
