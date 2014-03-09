package org.davilj.simple.dao;

import java.util.Collection;
import java.util.List;

import org.davilj.simple.model.Book;

public interface BookDao {

  Book get(Long id);

  void save(Book user);

  List<Book> findAll();

  Book findByName(String name);

  void saveBooks(Collection<Book> books);

}
