package org.davilj.simple.web.vo;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.davilj.simple.model.Book;
import org.davilj.simple.web.commands.BookCommand;

public class Books {
  @Valid
  private Map<Long, BookCommand> bookMap;

  public Books() {
  }

  public Books(List<Book> books) {
    bookMap = new LinkedHashMap<Long, BookCommand>();
    for (Book book : books)
      bookMap.put(book.getId(), new BookCommand(book));
  }

  public List<Book> getBooks() {
    List<Book> books = new ArrayList<Book>();
    for (BookCommand bookCommand : bookMap.values()) {
      books.add(bookCommand.toBook());
    }
    return books;
  }

  public Map<Long, BookCommand> getBookMap() {
    return bookMap;
  }

  public void setBookMap(Map<Long, BookCommand> books) {
    this.bookMap = books;
  }

  public boolean haveBooks() {
    if (bookMap == null)
      return false;
    return bookMap.size() > 0;
  }
}
