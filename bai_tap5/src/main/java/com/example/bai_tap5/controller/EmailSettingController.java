package com.example.bai_tap5.controller;

import com.example.bai_tap5.entity.EmailSetting;
import com.example.bai_tap5.service.IEmailSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/settings")
public class EmailSettingController {
    @Autowired
    private IEmailSettingService emailSettingService;

    @GetMapping
    public String showForm(Model model) {
        EmailSetting setting = new EmailSetting();
        model.addAttribute("setting", setting);

        String[] languages = {"English", "Vietnamese", "Japanese", "Chinese"};
        int[] pageSizes = {5, 10, 15, 25, 50, 100};

        model.addAttribute("languages", languages);
        model.addAttribute("pageSizes", pageSizes);

        return "settings/form";  // mapping tới /WEB-INF/views/settings/form.jsp
    }

    // Submit form
    @PostMapping
    public String update(@ModelAttribute("setting") EmailSetting setting, Model model) {
        emailSettingService.update(setting);
        model.addAttribute("updated", setting);
        return "settings/result";
    }

}
