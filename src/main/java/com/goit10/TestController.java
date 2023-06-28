package com.goit10;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
    @GetMapping("/test")
    public ModelAndView testMethod() {
        ModelAndView res = new ModelAndView("test");
        System.out.println("in test");
        return res;
    }
}
