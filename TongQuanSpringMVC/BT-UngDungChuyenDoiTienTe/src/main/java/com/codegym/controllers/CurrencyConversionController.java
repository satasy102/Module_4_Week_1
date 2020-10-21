package com.codegym.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import javax.servlet.http.HttpServletRequest;

@Controller
public class CurrencyConversionController {
    @GetMapping("/convert")
    public String convert(HttpServletRequest request) {
        try {
            double vnd = Double.parseDouble(request.getParameter("vnd"));
            double result2 = vnd / 22000;
            request.setAttribute("result2", result2);
            return "index";
        } catch (Exception e) {
            try {
                double usd = Double.parseDouble(request.getParameter("usd"));
                double result1 = usd * 22000;
                request.setAttribute("result1", result1);
                return "index";
            } catch (Exception e2){
                return "index";
            }
        }
    }
}
