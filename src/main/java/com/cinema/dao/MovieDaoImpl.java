package com.cinema.dao;

import com.cinema.model.Movie;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class MovieDaoImpl implements MovieDao {

  private SessionFactory sessionFactory;

  @Autowired
  public MovieDaoImpl(SessionFactory sessionFactory) {
    this.sessionFactory = sessionFactory;
  }

  @Override
  public void add(Movie movie) {
    sessionFactory.getCurrentSession().save(movie);
  }

  @Override
  public void update(Movie movie, Integer id) {
    remove(id);
    add(movie);
  }

  @Override
  public void remove(Integer id) {
    Movie movie = get(id);
    sessionFactory.getCurrentSession().delete(movie);
  }

  @Override
  public Movie get(Integer id) {
    return sessionFactory.getCurrentSession().get(Movie.class, id);
  }

  @Override
  public List<Movie> all() {
    CriteriaBuilder criteriaBuilder = sessionFactory.getCriteriaBuilder();
    CriteriaQuery<Movie> query = criteriaBuilder.createQuery(Movie.class);
    Root<Movie> from = query.from(Movie.class);
    query.select(from);
    Session session = sessionFactory.getCurrentSession();
    Query<Movie> q = session.createQuery(query);
    return q.getResultList();
  }
}
