package com.chanhtin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class CalculatorController {
    @GetMapping("/calculator")
    public String calculator(ModelMap model, @RequestParam(required = false, name="number1") String strnumber1,
                             @RequestParam(required = false, name="number2") String strnumber2) {
        double number1=0;
        double number2=0;
        model.addAttribute("number1",number1);
        model.addAttribute("number2",number2);
        return "index";
    }

    @PostMapping("/result")
    public String save(ModelMap model, @RequestParam(name="number1") double number1,
                       @RequestParam(name="number2") double number2,
                       @RequestParam(name="calculation") String calculation) {
        try{
            switch (calculation){
                case "+":
                    double result=number1+number2;
                    model.addAttribute("result",result);
                    break;
                case "-":
                    result=number1-number2;
                    model.addAttribute("result",result);
                    break;
                case "*":
                    result=number1*number2;
                    model.addAttribute("result",result);
                    break;
                case "/":
                    if(number2==0){
                        String message="Khong the chia cho 0";
                        model.addAttribute("message",message);
                    } else {
                        result = number1 / number2;
                        model.addAttribute("result",result);
                    }
                    break;
            }

        } catch (Exception ex){
            ex.printStackTrace();
        } finally {
            model.addAttribute("number1",number1);
            model.addAttribute("number2",number2);
            return "index";
        }

    }
}
