package com.cerradoSic.model.valueObjects;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.apache.commons.collections4.CollectionUtils;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.cerradoSic.model.enumerators.Genero;
import com.cerradoSic.model.enumerators.GeneroConverter;
import com.cerradoSic.util.ListComparator;


@Entity
@Table(name = "aluno")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
public class Aluno {

  @Id
  @GeneratedValue
  @Column(name = "idt_aluno")
  private int id;

  @Column(name = "cod_cpf")
  private String cpf;

  @Column(name = "nme_aluno")
  private String nome;

  @Column(name = "ind_genero")
  @Convert(converter = GeneroConverter.class)
  private Genero genero;

  @Column(name = "dsc_aluno")
  private String observacao;

  @OneToMany(mappedBy = "aluno", fetch = FetchType.EAGER)
  private List<Matricula> matriculas;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getObservacao() {
    return observacao;
  }

  public void setObservacao(String observacao) {
    this.observacao = observacao;
  }

  public Genero getGenero() {
    return genero;
  }

  public void setGenero(Genero genero) {
    this.genero = genero;
  }

  public List<Matricula> getMatriculas() {
    return matriculas;
  }

  public void setMatriculas(List<Matricula> matriculas) {
    this.matriculas = matriculas;
  }

  public void addMatricula(Matricula matricula) {
    if (CollectionUtils.isEmpty(matriculas)) {
      matriculas = new ArrayList<Matricula>();
    }
    if (matricula != null) {
      matriculas.add(matricula);
    }
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((cpf == null)? 0: cpf.hashCode());
    result = prime * result + ((genero == null)? 0: genero.hashCode());
    result = prime * result + id;
    result =
      prime * result +
        ((CollectionUtils.isEmpty(matriculas))? 0: matriculas.hashCode());
    result = prime * result + ((nome == null)? 0: nome.hashCode());
    result =
      prime * result + ((observacao == null)? 0: observacao.hashCode());
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
    Aluno other = (Aluno) obj;
    if (cpf == null) {
      if (other.cpf != null)
        return false;
    }
    else if (!cpf.equals(other.cpf))
      return false;
    if (genero != other.genero)
      return false;
    if (id != other.id)
      return false;
    if (CollectionUtils.isEmpty(matriculas)) {
      if (CollectionUtils.isNotEmpty(other.matriculas))
        return false;
    }
    else if (!ListComparator.equalsIgnoreOrder(matriculas,other.matriculas))
      return false;
    if (nome == null) {
      if (other.nome != null)
        return false;
    }
    else if (!nome.equals(other.nome))
      return false;
    if (observacao == null) {
      if (other.observacao != null)
        return false;
    }
    else if (!observacao.equals(other.observacao))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Aluno [id=" + id + ", cpf=" + cpf + ", nome=" + nome +
      ", genero=" + genero + ", observacao=" + observacao +
      ", matriculas=" + matriculas + "]";
  }
}
