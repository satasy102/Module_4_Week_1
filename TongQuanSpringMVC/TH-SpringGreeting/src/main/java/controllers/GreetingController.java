package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GreetingController {
    @GetMapping("/")
    public ModelAndView greeting(){
        ModelAndView modelAndView = new ModelAndView("hello");
        modelAndView.addObject("message","Ke Cai Dao Vo Co Thang Anh");
        return modelAndView;
    }
}