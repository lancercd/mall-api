package com.mall.api.dto.request;

import com.mall.core.dto.BaseRequest;
import com.mall.db.domain.Goods;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsDto extends BaseRequest {

    @NotNull(message = "请选择种类")
    private Integer categoryId;

    @NotBlank(message = "请输入商品名!")
    @Length(min = 3, max = 40, message = "商品名{min}-{max}个字符!")
    private String name;

    @NotNull(message = "请输入价格")
    @DecimalMax(value = "200000", message = "价格不能大于200000元")
    @DecimalMin(value = "0.5", message = "价格不能小于0.5元")
    @Digits(integer = 6, fraction = 2, message = "小数最多两位")
    private BigDecimal price;

    @DecimalMax(value = "200000", message = "价格不能大于200000元")
    @DecimalMin(value = "0.5", message = "原价不能小于0.5元")
    @Digits(integer = 6, fraction = 2, message = "小数最多两位")
    private BigDecimal normalPrice;

    @NotNull(message = "请选择新旧等级!")
    private Byte degreeId;

    @NotNull(message = "请上传一张商品封面图片!")
    private String banner;

    @NotNull(message = "请上传实物图片哦!")
    @Size(min = 1, max = 6, message = "图片数量不能少于{min}张并且不能多于{max}张")
    private List<String> images;

    private String props;

    @NotNull(message = "请输入数量!")
    @Max(value = 999999, message = "数量不能超过999999")
    @Min(value = 1, message = "数量不能小于1")
    private Integer quantity;

    @NotBlank(message = "请定位发货地址")
    private String description;

    public static Goods convert(GoodsDto dto) {
        Goods goods = new Goods();
        goods.setCategoryId(dto.getCategoryId());
        goods.setName(dto.getName());
        goods.setPrice(dto.getPrice());
        goods.setNormalPrice(dto.getNormalPrice());
        goods.setDegreeId(dto.getDegreeId());
        goods.setBanner(dto.getBanner());
        goods.setImages(dto.getImages().toArray(new String[0]));
        goods.setProps(dto.getProps());
        goods.setQuantity(dto.getQuantity());
        goods.setDescription(dto.getDescription());
        return goods;
    }
}
