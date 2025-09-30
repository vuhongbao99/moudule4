package com.example.thuc_hanh_validation.validation;

import com.example.thuc_hanh_validation.dto.UserDto;
import com.example.thuc_hanh_validation.entity.User;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.time.LocalDate;
import java.time.Period;

public class UserValidation implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        Period period = Period.between(userDto.getBirthDay(), LocalDate.now());
        if (period.getYears() < 18){
            errors.rejectValue("birthDay","","Phải đủ  18 tuổi");
        }
    }
}
