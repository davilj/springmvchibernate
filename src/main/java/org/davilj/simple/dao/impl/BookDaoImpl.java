package org.davilj.simple.dao.impl;

import java.util.Collection;
import java.util.List;

import org.davilj.simple.dao.BookDao;
import org.davilj.simple.model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Data access object for managing books in data source
 */
@Repository
public class BookDaoImpl implements BookDao {

  @Autowired
  private SessionFactory sessionFactory;

  public Book get(Long id) {
    return (Book) sessionFactory.getCurrentSession().get(Book.class, id);
  }

  @SuppressWarnings("unchecked")
  public List<Book> findAll() {
    return sessionFactory.getCurrentSession().createQuery("FROM Book ORDER BY id").list();
  }

  public void save(Book book) {
    sessionFactory.getCurrentSession().merge(book);

  }

  @Override
  public Book findByName(String name) {
    return (Book) sessionFactory.getCurrentSession().createQuery("FROM Nook u WHERE u.book = :name ")
        .setString("name", name).uniqueResult();
  }

  @Override
  public void saveBooks(Collection<Book> books) {
    Session session = sessionFactory.getCurrentSession();
    for (Book book : books) {
      session.merge(book);
    }
  }

}
