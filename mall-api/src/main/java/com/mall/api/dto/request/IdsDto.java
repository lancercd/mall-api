package com.mall.api.dto.request;

import com.mall.core.dto.BaseRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IdsDto extends BaseRequest {
    private List<Integer> ids;
}
