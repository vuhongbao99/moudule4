package com.example.thuc_hanh_validation.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class UserDto {
   @NotBlank(message = "Khoong duoc de trong")
   @Pattern(regexp = "^[A-Za-zÀ-ỹà-ỹ\\s]{3,10}$", message = "Chi nhap chu va khoang trang, do dai ki tu 5-45")
   private String lastName;

    @NotBlank(message = "Khoong duoc de trong")
    @Pattern(regexp = "^[A-Za-zÀ-ỹà-ỹ\\s]{3,10}$", message = "Chi nhap chu va khoang trang, do dai ki tu 3-10")
    private String firstName;

    @NotBlank(message = "sdt không được để trống")
    @Pattern(regexp = "^(0|\\+84)[0-9]{9}$", message = "Số điện thoại phải bắt đầu bằng 0 hoặc +84 và có đúng 9 chữ số sau đó")
    private String phone;

    @Past(message = "tuổi phải ở quá khứ")
    @NotNull(message = "không được để trống")
    private LocalDate birthDay;

    @NotNull(message = "email không được để trống")
    @Pattern(regexp ="^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,}$", message = "Nhập đúng định dạng email.vd:baobao280799@gmail.com.com")
    private String email;


}
