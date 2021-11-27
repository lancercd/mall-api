package com.mall.core.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.mall.core.utils.JsonSerializer.StringArrayJsonSerializer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import javax.validation.groups.Default;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GoodsDTO {

    @NotNull(message = "id不能为空", groups = Update.class)
    private Integer id;

    @NotBlank(message = "商品名称不能为空!")
    @Length(min = 2, message = "商品名称不能少于{min}个字符!")
    @Length(max = 8, message = "商品名称不能对于{max}个字符!")
    private String name;

    @NotBlank(message="商品描述不能为空!")
    private String description;

    @NotNull(message = "请输入商品价格!")
    @DecimalMax(value = "200000", message = "原价不能大于200000元!")
    @DecimalMin(value = "1", message = "原价不能小于1元!")
    @Digits(integer = 6, fraction = 2, message = "小数最多两位!")
    private BigDecimal price;

    @NotNull(message = "请选择商品分类!")
    private Integer categoryId;

    @Size(min = 1, message = "至少上传{min}张图片!")
    @Size(max = 2, message = "至多可上传{max}张图片!")
    // @JsonDeserialize(using = StringArrayJsonSerializer.class)
    private String[] images;

    private Boolean status;

    @NotBlank(message="商品详情不能为空!")
    private String detail;

    public static interface Add {}

    public static interface Update {}
}
