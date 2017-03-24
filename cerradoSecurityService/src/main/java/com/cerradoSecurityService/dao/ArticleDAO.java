package com.cerradoSecurityService.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cerradoSecurityService.model.valueObjects.Article;
@Transactional
@Repository
public class ArticleDAO implements IArticleDAO {
  @PersistenceContext 
  private EntityManager entityManager;  
  @Override
  public Article getArticleById(int articleId) {
    return entityManager.find(Article.class, articleId);
  }
  @SuppressWarnings("unchecked")
  @Override
  public List<Article> getAllArticles() {
    String hql = "FROM Article as atcl ORDER BY atcl.id";
    return (List<Article>) entityManager.createQuery(hql).getResultList();
  } 
  @Override
  public void addArticle(Article article) {
    entityManager.persist(article);
  }
  @Override
  public void updateArticle(Article article) {
    Article artcl = getArticleById(article.getId());
    artcl.setTitle(article.getTitle());
    artcl.setCategory(article.getCategory());
    entityManager.flush();
  }
  @Override
  public void deleteArticle(int articleId) {
    entityManager.remove(getArticleById(articleId));
  }
  @Override
  public boolean articleExists(String title, String location) {
    String hql = "FROM Article as atcl WHERE atcl.title = ? and atcl.category = ?";
    int count = entityManager.createQuery(hql).setParameter(1, title)
                  .setParameter(2, location).getResultList().size();
    return count > 0 ? true : false;
  }
} 