package com.example.bai_tap3.controller;

import com.example.bai_tap3.exception.NoCondimentSelectedException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SandwichController {

    @RequestMapping("/")
    public String index() {
        // index.jsp ở ngoài
        return "forward:/index.jsp";
    }

    @RequestMapping("/save")
    public String save(@RequestParam(value = "condiment", required = false) String[] condiment,
                       Model model) {
        if (condiment == null || condiment.length == 0) {
            throw new NoCondimentSelectedException("Bạn chưa chọn gia vị nào!");
        }
        model.addAttribute("condiments", condiment);
        return "result";
    }
}
