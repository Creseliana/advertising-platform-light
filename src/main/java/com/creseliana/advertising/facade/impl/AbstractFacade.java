package com.creseliana.advertising.facade.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;

/**
 * @author Valeria Sterzhanova
 */
public abstract class AbstractFacade {

    protected <A, B> List<B> mapEntityList(ModelMapper modelMapper, List<A> entityList,
        Class<B> destinationClass) {
        return entityList.stream()
            .map(entity -> modelMapper.map(entity, destinationClass))
            .collect(Collectors.toList());
    }
}
