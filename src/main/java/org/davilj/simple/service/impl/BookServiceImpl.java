package org.davilj.simple.service.impl;

import org.davilj.simple.dao.BookDao;
import org.davilj.simple.model.Book;
import org.davilj.simple.service.BookService;
import org.davilj.simple.web.UserController;
import org.davilj.simple.web.commands.BookCommand;
import org.davilj.simple.web.vo.Books;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {
  final static Logger log = LoggerFactory.getLogger(UserController.class);

  @Autowired
  BookDao bookDao;

  @Transactional(readOnly = true)
  public Book get(Long id) {
    return bookDao.get(id);
  }

  @Transactional(readOnly = true)
  public Books findAll() {
    return new Books(bookDao.findAll());
  }

  @Transactional
  public void save(BookCommand bookCommand) {
    log.debug("Book: " + bookCommand.toBook());
    bookDao.save(bookCommand.toBook());
  }

  @Transactional
  public void saveAll(Books books) {
    for (Book book : books.getBooks())
      bookDao.save(book);
  }

  @Transactional(readOnly = true)
  public void updateWithAll(Books books) {
    Books allbooks = findAll();
    allbooks.getBookMap().putAll(books.getBookMap());
    allbooks.setBookMap(books.getBookMap());

  }
}
