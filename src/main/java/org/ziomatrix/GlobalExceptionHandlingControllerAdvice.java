package org.ziomatrix;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandlingControllerAdvice {
	
    @ExceptionHandler(Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception ex) throws Exception {
        if (AnnotationUtils.findAnnotation(ex.getClass(), ResponseStatus.class) != null) {
            throw ex;
        }
        ModelAndView mav = new ModelAndView();
        mav.setViewName("error/500");
        mav.addObject("exception", ex);
        mav.addObject("stacktrace","");
        mav.addObject("url", req.getRequestURL());
        mav.addObject("timestamp", LocalDateTime.now().toString());
        return mav;
    }
}