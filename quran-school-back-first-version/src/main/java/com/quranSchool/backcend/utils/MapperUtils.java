package com.quranSchool.backcend.utils;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MapperUtils extends ModelMapper {

    @Override
    public <D> D map(Object source, Class<D> destinationType) {
        return super.map(source, destinationType);
    }
}
