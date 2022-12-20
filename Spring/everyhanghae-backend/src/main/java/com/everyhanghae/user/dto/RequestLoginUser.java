package com.everyhanghae.user.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class RequestLoginUser {

    @NotBlank(message = "이메일은 필수 입력입니다.")
    @Email(message = "email 형식을 지켜주세요")
    private String email;

    @NotBlank(message = "비밀번호는 필수 입력입니다.")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!#%*?&])[A-Za-z\\d@$!#%*?&]{8,15}$",
            message = "비밀번호는 8~15자리의 대소문자,숫자,특수문자로 이루어져야 합니다.")
    private String password;
}