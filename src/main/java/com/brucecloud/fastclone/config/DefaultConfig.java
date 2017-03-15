package com.brucecloud.fastclone.config;

import com.brucecloud.fastclone.cloner.*;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.nio.charset.Charset;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.*;

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
        registerCloner(Currency.class, new ImmutableCloner<Currency>());
        registerCloner(StringBuffer.class, new StringBufferCloner());
        registerCloner(StringBuilder.class, new StringBuilderCloner());
        registerCloner(Collections.EMPTY_LIST.getClass(), new ImmutableCloner());
        registerCloner(Collections.EMPTY_MAP.getClass(), new ImmutableCloner());
        registerCloner(Collections.EMPTY_SET.getClass(), new ImmutableCloner());
        registerCloner(Collections.singletonList(null).getClass(), new ImmutableCloner<List>());
        registerCloner(Collections.singletonMap(null, null).getClass(), new ImmutableCloner<Map>());
        registerCloner(Collections.singleton(null).getClass(), new ImmutableCloner<Set>());
        registerCloner(TreeSet.class, new TreeSetCloner());
        registerCloner(Map.class, new MapCloner());
        registerCloner(TreeMap.class, new TreeMapCloner());
        registerCloner(TimeZone.class, new ImmutableCloner<TimeZone>());
        registerCloner(Calendar.class, new CalendarCloner());
        registerCloner(Locale.class, new ImmutableCloner<Locale>());
        registerCloner(Charset.class, new ImmutableCloner<Charset>());
        registerCloner(URL.class, new ImmutableCloner<URL>());
    }

    /**
     * 注册默认引用处理器
     */
    @Override
    protected void registerDefaultReferenceResolver() {
        registerReferenceResolver(String.class);
    }
}

