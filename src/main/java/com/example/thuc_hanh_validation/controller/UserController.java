package com.example.thuc_hanh_validation.controller;

import com.example.thuc_hanh_validation.dto.UserDto;
import com.example.thuc_hanh_validation.entity.User;
import com.example.thuc_hanh_validation.service.IUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService userService;
    @GetMapping("")
    public String create(Model model){
        model.addAttribute("userDto",new UserDto());
        return "index";
    }
    @PostMapping("/save")
    public String save(@Validated @ModelAttribute UserDto userDto, BindingResult bindingResult, RedirectAttributes attribute ){
        if(bindingResult.hasErrors()){
            return "index";
        }
        User user= new User();
        BeanUtils.copyProperties(userDto,user);
        userService.create(user);
        attribute.addFlashAttribute("mess","đăng kí thành công");
        attribute.addFlashAttribute("user",user);
        return "redirect:/users/result";

    }
    @GetMapping("/result")
    public String result(){

        return "result";
    }
}
