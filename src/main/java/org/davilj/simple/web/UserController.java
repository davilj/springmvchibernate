package org.davilj.simple.web;

import javax.validation.Valid;

import org.davilj.simple.service.UserService;
import org.davilj.simple.web.commands.UserCommand;
import org.davilj.simple.web.vo.UserGrid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(UserController.URL)
public class UserController {
  static final Logger log = LoggerFactory.getLogger(UserController.class);
  static final String URL = "/user";

  @Autowired
  UserService userService;

  PasswordEncoder passwordEncoder = new StandardPasswordEncoder();

  @RequestMapping(method = RequestMethod.GET)
  public void get(Model model, @ModelAttribute UserCommand userCommand) {
    model.addAttribute("userGrid", userService.findAll());
  }

  @RequestMapping(method = RequestMethod.POST)
  public String post(Model model, @Valid UserCommand userCommand, BindingResult result) {
    log.debug("Ready to persist: " + userCommand);
    if (result.hasErrors()) {
      // errors in binding result, will be reported, lets load user agains
      log.debug("error: user post" + result.getAllErrors());
      model.addAttribute("userGrid", userService.findAll());
      return URL;
    }

    // since password is encode we have to check
    if (isValidPassword(userCommand.getPassword())) {
      ObjectError objectError = new ObjectError("password", "Password must be between 4 and 10");
      result.addError(objectError);
    }

    userCommand.setPassword(passwordEncoder.encode(userCommand.getPassword()));
    userService.save(userCommand);

    return "redirect:" + URL;
  }

  @RequestMapping(method = RequestMethod.POST, params = "_method=put")
  public String put(Model model, @Valid UserGrid userGrid, BindingResult result) {
    if (userGrid != null && userGrid.haveUsers()) {
      if (result.hasErrors()) {
        userService.updateWithAll(userGrid);
        return URL;
      }
      userService.saveAll(userGrid);
    }
    return "redirect:" + URL;
  }

  private boolean isValidPassword(String password) {
    return true;
  }

}
