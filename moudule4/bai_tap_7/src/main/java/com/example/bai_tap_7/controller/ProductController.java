package com.example.bai_tap_7.controller;

import com.example.bai_tap_7.entity.Product;
import com.example.bai_tap_7.service.IProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String getAllProduct(Model model){
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "product/list";
    }

    @GetMapping("/create")
    public String createStudent(ModelMap model) {
        model.addAttribute("product", new Product());
        return "product/create";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute("product")Product product, BindingResult bindingResult, RedirectAttributes redirect) {
        if(bindingResult.hasErrors()) {
            return "product/create";
        }
        productService.save(product);
        redirect.addFlashAttribute("message", "Thêm mới thành công");
        return "redirect:/products";
    }

    @GetMapping("/{id}")
    public String getStudentById(@PathVariable Integer id, ModelMap model) {
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "product/info";

}
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Product product = productService.findById(id);
        if (product == null) {
            return "redirect:/products"; // nếu không tìm thấy thì quay lại list
        }
        model.addAttribute("product", product);
        return "product/edit"; // file: /view/product/edit.html
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute("product") Product product) {
        productService.update(product);
        return "redirect:/products";
    }

    // ================== DELETE ==================

    // Xóa sản phẩm
    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        productService.delete(id);
        return "redirect:/products";
    }
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public String handleNumberFormatException(NumberFormatException ex) {
        return "redirect:/error";
    }
}
