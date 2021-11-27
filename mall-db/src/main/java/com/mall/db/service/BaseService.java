package com.mall.db.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;


public abstract class BaseService {

    private ModelMapper modelMapper;

    public BaseService() {}

    @Autowired
    private void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public <D> D map(Object dto, Class<D> destinationType) {
        return modelMapper.map(dto, destinationType);
    }
}
