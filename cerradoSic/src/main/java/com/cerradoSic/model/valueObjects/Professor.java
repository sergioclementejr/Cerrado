package com.cerradoSic.model.valueObjects;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.apache.commons.collections4.CollectionUtils;

import com.cerradoSic.model.enumerators.Genero;
import com.cerradoSic.model.enumerators.GeneroConverter;
import com.cerradoSic.util.ListComparator;


@Entity
@Table(name = "professor")
public class Professor {
  @Id
  @GeneratedValue
  @Column(name = "idt_professor")
  private int id;
  @Column(name = "nme_professor")
  private String nome;
  @Column(name = "cod_cref_professor")
  private String cref;
  @Column(name = "ind_genero")
  @Convert(converter = GeneroConverter.class)
  private Genero genero;
  @Column(name = "dsc_professor")
  private String descricao;
  @ManyToMany(fetch=FetchType.LAZY)
  @JoinTable(name = "curriculo",
             joinColumns = @JoinColumn(name = "idt_professor"),
             inverseJoinColumns = @JoinColumn(name = "idt_especialidade"))
  private List<Especialidade> especialidades = new ArrayList<Especialidade>();
  @ManyToMany(fetch=FetchType.LAZY)
  @JoinTable(name = "leciona",
             joinColumns = @JoinColumn(name = "idt_professor"),
             inverseJoinColumns = @JoinColumn(name = "idt_modalidade"))
  private List<Modalidade> modalidades= new ArrayList<Modalidade>();

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

  public List<Especialidade> getEspecialidades() {
    return especialidades;
  }

  public void setEspecialidades(List<Especialidade> especialidades) {
    this.especialidades = especialidades;
  }

  public List<Modalidade> getModalidades() {
    return modalidades;
  }

  public void setModalidades(List<Modalidade> modalidades) {
    this.modalidades = modalidades;
  }

  public void addEspecialidade(Especialidade especialidade) {
    if (CollectionUtils.isEmpty(especialidades)) {
      especialidades = new ArrayList<Especialidade>();
    }
    if (especialidade != null) {
      especialidades.add(especialidade);
    }
  }

  public void addModalidade(Modalidade modalidade) {
    if (CollectionUtils.isEmpty(modalidades)) {
      modalidades = new ArrayList<Modalidade>();
    }
    if (modalidade != null) {
      modalidades.add(modalidade);
    }
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((cref == null)? 0: cref.hashCode());
    result =
      prime * result + ((descricao == null)? 0: descricao.hashCode());
    result = prime * result +
      ((CollectionUtils.isEmpty(especialidades))? 0
        : especialidades.hashCode());
    result = prime * result + ((genero == null)? 0: genero.hashCode());
    result = prime * result + id;
    result =
      prime * result +
        ((CollectionUtils.isEmpty(modalidades))? 0: modalidades.hashCode());
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
    Professor other = (Professor) obj;
    if (cref == null) {
      if (other.cref != null)
        return false;
    }
    else if (!cref.equals(other.cref))
      return false;
    if (descricao == null) {
      if (other.descricao != null)
        return false;
    }
    else if (!descricao.equals(other.descricao))
      return false;
    if (CollectionUtils.isEmpty(especialidades)) {
      if (CollectionUtils.isNotEmpty(other.especialidades))
        return false;
    }
    else if (!ListComparator.equalsIgnoreOrder(especialidades,other.especialidades))
      return false;
    if (genero != other.genero)
      return false;
    if (id != other.id)
      return false;
    if (CollectionUtils.isEmpty(modalidades)) {
      if (CollectionUtils.isNotEmpty(other.modalidades))
        return false;
    }
    else if (!ListComparator.equalsIgnoreOrder(modalidades,other.modalidades))
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
