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
public class BuyNowDto extends BaseRequest {

    @NotNull(message = "商品id不能为空!")
    private Integer goodsId;

    @NotNull(message = "商品数量不能为空!")
    private Integer num;

}
