package com.mall.core.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.mall.core.utils.JsonSerializer.StringArrayJsonSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsDTO {

    @NotNull(message = "id不能为空", groups = Add.class)
    private Integer id;

    @NotBlank(message = "商品名称不能为空!")
    @Length(min = 2, message = "商品名称不能少于{min}个字符")
    @Length(max = 8, message = "商品名称不能对于{max}个字符")
    private String name;

    @NotBlank(message="商品描述不能为空!")
    private String description;

    private BigDecimal price;

    private Integer categoryId;

    @Size(min = 1, message = "至少上传{min}张图片!")
    @Size(max = 2, message = "至多可上传{max}张图片!")
    @JsonDeserialize(using = StringArrayJsonSerializer.class)
    private String[] images;

    private Boolean status;

    @NotBlank(message="商品详情不能为空!")
    private String detail;

    public static interface Add {}

    public static interface Update {}
}
