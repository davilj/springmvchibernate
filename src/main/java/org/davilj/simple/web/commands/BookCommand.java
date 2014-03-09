package org.davilj.simple.web.commands;

import org.davilj.simple.model.Book;

public class BookCommand extends Book {

  private static final long serialVersionUID = 8663954084124184075L;

  private Boolean selected = false;

  public BookCommand() {
  }

  public BookCommand(Book book) {
    setId(book.getId());
    setName(book.getName());

  }

  public Book toBook() {
    Book book = new Book();
    book.setId(getId());
    book.setName(getName());

    return book;
  }

  public Boolean getSelected() {
    return selected;
  }

  public void setSelected(Boolean changed) {
    this.selected = changed;
  }

  @Override
  public String toString() {
    return "BookCommand [selected=" + selected + ", getId()=" + getId() + ", getName()=" + getName() + ", getOwner()="
        + getOwner() + "]";
  }

}
