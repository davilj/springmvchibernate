package org.davilj.simple.service;

/**
 * Service for managing books
 */
import org.davilj.simple.model.Book;
import org.davilj.simple.web.commands.BookCommand;
import org.davilj.simple.web.vo.Books;

public interface BookService {
  Book get(Long id);

  void save(BookCommand userCommand);

  Books findAll();

  void saveAll(Books userGrid);

  void updateWithAll(Books books);

}
