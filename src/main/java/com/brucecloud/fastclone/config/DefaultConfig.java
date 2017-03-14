package com.brucecloud.fastclone.config;

import com.brucecloud.fastclone.cloner.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.EnumSet;

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
        registerCloner(byte[].class, new ByteArrayCloner());
        registerCloner(short[].class, new ShortArrayCloner());
        registerCloner(int[].class, new IntArrayCloner());
        registerCloner(long[].class, new LongArrayCloner());
        registerCloner(float[].class, new FloatArrayCloner());
        registerCloner(double[].class, new DoubleArrayCloner());
        registerCloner(boolean[].class, new BooleanArrayCloner());
        registerCloner(String[].class, new StringArrayCloner());
        registerCloner(Object[].class, new ObjectArrayCloner());
        registerCloner(BigInteger.class, new ImmutableCloner<BigInteger>());
        registerCloner(Class.class, new ImmutableCloner<Class>());
        Cloner dateCloner = new DateCloner();
        registerCloner(Date.class, dateCloner);
        registerCloner(Timestamp.class, dateCloner);
        registerCloner(java.sql.Date.class, dateCloner);
        registerCloner(Time.class, dateCloner);
        registerCloner(EnumSet.class, new EnumSetCloner());
    }

    /**
     * 注册默认引用处理器
     */
    @Override
    protected void registerDefaultReferenceResolver() {
        registerReferenceResolver(String.class);
    }
}

