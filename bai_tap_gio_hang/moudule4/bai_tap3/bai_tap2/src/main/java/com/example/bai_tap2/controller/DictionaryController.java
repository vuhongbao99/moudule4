package com.example.bai_tap2.controller;

import com.example.bai_tap2.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller

public class DictionaryController {
    @Autowired
    private DictionaryService dictionaryService;

    @PostMapping("/search")
    public String searchWord(@RequestParam("word") String word, Model model) {

        // Tra cứu từ trong từ điển
        String meaning = dictionaryService.translate(word);

        // Thêm dữ liệu vào model
        model.addAttribute("searchWord", word);
        model.addAttribute("totalWords", dictionaryService.getTotalWords());

        if (meaning != null) {
            // Tìm thấy từ
            model.addAttribute("meaning", meaning);
            model.addAttribute("found", true);
        } else {
            // Không tìm thấy từ
            model.addAttribute("found", false);
        }

        return "result";
    }
}
