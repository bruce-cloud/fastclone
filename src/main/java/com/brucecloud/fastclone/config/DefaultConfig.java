package com.brucecloud.fastclone.config;

import com.brucecloud.fastclone.cloner.CharArrayCloner;
import com.brucecloud.fastclone.cloner.CollectionCloner;
import com.brucecloud.fastclone.cloner.ImmutableCloner;

import java.math.BigDecimal;
import java.util.Collection;

/**
 * 默认配置.
 * created at 2017/3/14 13:30.
 *
 * @author yaoxh.
 */
public class DefaultConfig extends Config{

    public DefaultConfig() {
        init();
    }

    private void init() {
        registerDefaultCloner();
        registerDefaultReferenceResolver();
    }

    /**
     * 注册默认克隆器
     */
    @Override
    protected void registerDefaultCloner() {
        registerCloner(BigDecimal.class, new ImmutableCloner<BigDecimal>());
        registerCloner(Enum.class, new ImmutableCloner<Enum>());
        registerCloner(Integer.class, new ImmutableCloner<Integer>());
        registerCloner(Collection.class, new CollectionCloner());
        registerCloner(char[].class, new CharArrayCloner());
    }

    /**
     * 注册默认引用处理器
     */
    @Override
    protected void registerDefaultReferenceResolver() {
        registerReferenceResolver(String.class);
    }
}

