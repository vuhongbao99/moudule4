package com.example.bai_tap_song.controller;

import com.example.bai_tap_song.dto.SongDto;
import com.example.bai_tap_song.entity.Song;
import com.example.bai_tap_song.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/songs")
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("songs", songService.findAll());
        return "index";
    }

    @GetMapping("/create")
    public String create(@ModelAttribute SongDto songDto, Model model) {
        model.addAttribute("songDto", new SongDto());
        return "create";
    }

    @PostMapping("/create")
    public String add(@Validated @ModelAttribute SongDto songDto, BindingResult bindingResult, RedirectAttributes attributes) {
        if (bindingResult.hasErrors()) {
            return "create";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        songService.save(song);
        attributes.addFlashAttribute("mess", "Thêm mới thành công");
        return "redirect:/songs";

    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable Integer id, @ModelAttribute SongDto songDto, RedirectAttributes attributes, Model model) {
        Song song = songService.findById(id);
        if (song == null) {
            attributes.addFlashAttribute("mess", "không tìm thấy id cần thay đổi");
            return "redirect:/songs";
        }
        BeanUtils.copyProperties(song, songDto);
        model.addAttribute("songDto", songDto);
        model.addAttribute("id", id);
        return "update";
    }

    @PostMapping("/{id}/update")
    public String edit(@Validated @ModelAttribute SongDto songDto, BindingResult bindingResult,
                       RedirectAttributes attributes, Model model, @PathVariable Integer id) {
        if (bindingResult.hasErrors()) {
            return "update";
        }

        if (songService.findById(id) == null) {
            model.addAttribute("mess", "không tìm thấy bài hát cần thay đổi");
            return "update";
        }
        Song song = new Song();
        BeanUtils.copyProperties(songDto, song);
        songService.save(song);
        model.addAttribute("song", song);
        attributes.addFlashAttribute("mess","cập nhật thành công");
        return "redirect:/songs";


    }
}
