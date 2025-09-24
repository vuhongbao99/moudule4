package com.example.bai_tap_song.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SongDto {
    @NotBlank(message = " không được để trống")
    @Size(max = 800)
    @Pattern(regexp = "^[A-Za-zÀ-ỹà-ỹ0-9\\s]+$", message = "Chỉ nhập chữ, số và khoảng trắng,không quá 800 kí tự")
    private String title;
    @NotBlank(message = " không được để trống")
    @Size(max = 300)
    @Pattern(regexp = "^[A-Za-zÀ-ỹà-ỹ0-9\\s]+$", message = "Chỉ nhập chữ, số và khoảng trắng,không quá 300 kí tự")
    private String singer;
    @NotBlank(message = "không được để trống")
    @Size(max = 1000)
    @Pattern(regexp = "^[a-zA-Z0-9À-ỹà-ỹ,\\s]+$", message = "Không được chứa ký tự đặc biệt ,ngoại trừ dấu phẩy,không quá 1000 kí tự")
    private String genre;
}
