package com.mall.admin.dto;

import com.mall.core.dto.BaseRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminLogin extends BaseRequest {

    @NotBlank(message = "请输入用户名")
    @Length(min = 3, max = 13, message = "用户名{min}-{max}个字符!")
    String username;

    @NotNull(message = "请输入密码")
    @Length(min = 3, message = "密码至少{min}个字符")
    @Length(max = 16, message = "密码不能超过{max}个字符")
    String pwd;
}
