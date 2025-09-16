package com.example.bai_tap3.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NoCondimentSelectedException.class)
    public String handleNoCondimentSelected(NoCondimentSelectedException ex, Model model) {
        model.addAttribute("errorMessage", ex.getMessage());
        return "error"; // trả về trang error.jsp
    }
}
