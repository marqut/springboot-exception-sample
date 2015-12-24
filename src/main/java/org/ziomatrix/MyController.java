package org.ziomatrix;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
  @RequestMapping("/")
  public String root(Model model) {
    return "index";
  }

  @RequestMapping("/search")
  public String search(Model model) {
    // この例外はGlobalExceptionHandlingControllerAdviceでキャッチされる!!
    throw new UnsupportedOperationException("not implemented");
  }

  @RequestMapping("/thymeleafError")
  public String err(Model model) {
	  return "wrong";
  }

}