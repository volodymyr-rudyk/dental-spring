package com.dntistpro.bean.mapper;

/**
 * Created by vrudyk on 12/2/2016.
 */
public interface Mapper<I, O> {

    O convertFwd(I i);

    I convertBack(O i);

}
