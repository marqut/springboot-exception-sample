package org.ziomatrix;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GeneralExceptionController implements ErrorController {

    private static final String PATH = "/error";

	@RequestMapping(PATH)
	ModelAndView home(HttpServletRequest request
					  , Exception e) {
		ModelAndView mav = new ModelAndView("error/general");
		return mav;
	}

	@Override
	public String getErrorPath() {
		return PATH;
	}

}
