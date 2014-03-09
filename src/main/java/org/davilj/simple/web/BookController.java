package org.davilj.simple.web;

import javax.validation.Valid;

import org.davilj.simple.service.BookService;
import org.davilj.simple.web.commands.BookCommand;
import org.davilj.simple.web.vo.Books;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(BookController.URL)
public class BookController {
  static final Logger log = LoggerFactory.getLogger(UserController.class);
  static final String URL = "/book";

  @Autowired
  BookService bookService;

  @RequestMapping(method = RequestMethod.GET)
  public void get(Model model, @ModelAttribute BookCommand BookCommand) {
    model.addAttribute("books", bookService.findAll());
  }

  @RequestMapping(method = RequestMethod.POST)
  public String post(Model model, @Valid BookCommand bookCommand, BindingResult result) {
    log.debug("Ready to persist: " + bookCommand);
    if (result.hasErrors()) {
      // errors in binding result, will be reported, lets load user agains
      log.debug("error: user post" + result.getAllErrors());
      model.addAttribute("userGrid", bookService.findAll());
      return URL;
    }

    bookService.save(bookCommand);

    return "redirect:" + URL;
  }

  @RequestMapping(method = RequestMethod.POST, params = "_method=put")
  public String put(Model model, @Valid Books books, BindingResult result) {
    if (books != null && books.haveBooks()) {
      if (result.hasErrors()) {
        bookService.updateWithAll(books);
        return URL;
      }
      bookService.saveAll(books);
    }
    return "redirect:" + URL;
  }

}
