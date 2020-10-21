package com.chanhtin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichCondimentsController {
    @GetMapping("/condiment")
    public String getTimeByTimezone() {
        return "index";
    }

    @RequestMapping(value = "/condiment", method = {RequestMethod.POST, RequestMethod.PUT})
    public String save(ModelMap model, @RequestParam(required=false,name="condiment") String[] condiments) {
        model.addAttribute("condiments", condiments);
        return "index";
    }
}
