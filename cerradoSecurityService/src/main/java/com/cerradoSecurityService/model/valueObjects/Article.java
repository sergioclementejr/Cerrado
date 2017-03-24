package com.cerradoSecurityService.model.valueObjects;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="articles")
public class Article implements Serializable { 
  private static final long serialVersionUID = 1L;
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @Column(name="id")
        private int id;  
  @Column(name="title")
        private String title;
  @Column(name="category")  
  private String category;
  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getCategory() {
    return category;
  }
  public void setCategory(String category) {
    this.category = category;
  }
  public static long getSerialversionuid() {
    return serialVersionUID;
  }
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((category == null)? 0: category.hashCode());
    result = prime * result + id;
    result = prime * result + ((title == null)? 0: title.hashCode());
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
    Article other = (Article) obj;
    if (category == null) {
      if (other.category != null)
        return false;
    }
    else if (!category.equals(other.category))
      return false;
    if (id != other.id)
      return false;
    if (title == null) {
      if (other.title != null)
        return false;
    }
    else if (!title.equals(other.title))
      return false;
    return true;
  }
  @Override
  public String toString() {
    return "Article [id=" + id + ", title=" + title + ", category=" +
      category + "]";
  }
} 