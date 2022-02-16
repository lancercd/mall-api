package com.mall.api.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.Default;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserLoginAndRegister extends BaseRequest {

    @NotBlank(message = "请输入用户名")
    @Length(min = 3, max = 13, message = "用户名{min}-{max}个字符!")
    String username;

    @NotNull(message = "请输入密码")
    @Length(min = 3, message = "密码至少{min}个字符")
    @Length(max = 16, message = "密码不能超过{max}个字符")
    String pwd;

    @NotNull(message = "请输入密码", groups = {Register.class})
    @Length(min = 3, message = "密码至少{min}个字符", groups = {Register.class})
    @Length(max = 16, message = "密码不能超过{max}个字符", groups = {Register.class})
    String rePwd;

    @NotNull(message = "请选择学校", groups = {Register.class})
    @Min(value = 1, message = "id错误", groups = {Register.class})
    Integer schoolId;

    public interface Login {}

    public interface Register {}
}
