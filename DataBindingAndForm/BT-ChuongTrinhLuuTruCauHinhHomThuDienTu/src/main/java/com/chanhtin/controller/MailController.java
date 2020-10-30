package com.chanhtin.controller;

import com.chanhtin.model.MailSetting;
import com.chanhtin.service.MailSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("mailSettings")
public class MailController {
    @Autowired
    private MailSettingService mailSettingService;

    @GetMapping("/showlist")
    public ModelAndView showList() {
        ModelAndView modelAndView = new ModelAndView("/list");
        List<MailSetting> mailSettings = mailSettingService.findAll();
        modelAndView.addObject("mailSettings", mailSettings);
        return modelAndView;
    }

    @GetMapping
    public String getHome(Model model){
        model.addAttribute("mailSetting", new MailSetting());
        return "add";
    }

    @PostMapping
    public String updateMailSetting(@ModelAttribute("mailSetting") MailSetting mailSetting) {
        mailSettingService.save(mailSetting);
        return "redirect:mailSettings/showlist";
    }
}
