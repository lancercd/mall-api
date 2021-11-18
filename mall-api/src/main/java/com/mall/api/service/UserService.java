package com.mall.api.service;


import com.mall.db.domain.MallAd;
import com.mall.db.service.MallAdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private MallAdService mallAdService;

    public MallAd get() {
        return mallAdService.findById(7);
    }
}
