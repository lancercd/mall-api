package com.mall.api.controller;

import com.mall.api.annotation.Login;
import com.mall.api.annotation.LoginUser;
import com.mall.api.dto.request.GoodsDto;
import com.mall.api.service.GoodsService;
import com.mall.api.service.UserService;
import com.mall.core.utils.ResponseUtil;
import com.mall.db.domain.Goods;
import com.mall.db.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public Object goodsList(
            @RequestParam(defaultValue = "1") Integer currentPageNum,
            @RequestParam(defaultValue = "100")Integer pageSize,
            @RequestParam(defaultValue = "")String key,
            @RequestParam(defaultValue = "")Integer categoryId,
            @RequestParam(defaultValue = "")Integer schoolId,
            @RequestParam(defaultValue = "")String filed,
            @RequestParam(defaultValue = "")String order
    ) {
        Map<String, Object> list = goodsService.list(
                currentPageNum,
                pageSize,
                key,
                categoryId,
                schoolId,
                filed,
                order);
        return ResponseUtil.ok(list);
    }

    @Login
    @GetMapping("/publish/list")
    public Object publishGoodsList(@LoginUser Integer uid) {
        return ResponseUtil.ok(goodsService.publishList(uid));
    }

    @Login
    @PostMapping("/add")
    public Object add(
            @LoginUser Integer uid,
            @RequestBody @Validated GoodsDto goodsDto
    ) {
        User user = userService.findById(uid);
        Goods goods = GoodsDto.convert(goodsDto);
        goods.setSchoolId(user.getSchoolId());
        goods.setUid(uid);
        if (!goodsService.add(goods)) {
            return ResponseUtil.fail("????????????!");
        }
        return ResponseUtil.ok();
    }

    @GetMapping("/detail/{id}")
    public Object detail(@PathVariable() Integer id) {
        if (null == id) {
            return ResponseUtil.fail("???????????????");
        }
        Goods goods = goodsService.detail(id);

        if (null == goods) {
            return ResponseUtil.fail("???????????????");
        }
        goodsService.view(goods);

        return ResponseUtil.ok(goods);
    }
}
