package com.brucecloud.fastclone.bean;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.*;

/**
 * .
 * created at 2017/3/15 11:09.
 *
 * @author yaoxh.
 */
public class ImmutableBean {
    private Integer integer;
    private BigDecimal bigDecimal;
    private BigInteger bigInteger;
    private Enum anEnum;
    private TimeZone timeZone;
    private Locale locale;
    private Charset charset;
    private URL url;
    private Class aClass;
    private Currency currency;
    private List emptyList;
    private Map emptyMap;
    private Set emptySet;
    private List singletonList;
    private Map singletonMap;
    private Set singletonSet;

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    public BigDecimal getBigDecimal() {
        return bigDecimal;
    }

    public void setBigDecimal(BigDecimal bigDecimal) {
        this.bigDecimal = bigDecimal;
    }

    public BigInteger getBigInteger() {
        return bigInteger;
    }

    public void setBigInteger(BigInteger bigInteger) {
        this.bigInteger = bigInteger;
    }

    public Enum getAnEnum() {
        return anEnum;
    }

    public void setAnEnum(Enum anEnum) {
        this.anEnum = anEnum;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public Charset getCharset() {
        return charset;
    }

    public void setCharset(Charset charset) {
        this.charset = charset;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

    public Class getaClass() {
        return aClass;
    }

    public void setaClass(Class aClass) {
        this.aClass = aClass;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public List getEmptyList() {
        return emptyList;
    }

    public void setEmptyList(List emptyList) {
        this.emptyList = emptyList;
    }

    public Map getEmptyMap() {
        return emptyMap;
    }

    public void setEmptyMap(Map emptyMap) {
        this.emptyMap = emptyMap;
    }

    public Set getEmptySet() {
        return emptySet;
    }

    public void setEmptySet(Set emptySet) {
        this.emptySet = emptySet;
    }

    public List getSingletonList() {
        return singletonList;
    }

    public void setSingletonList(List singletonList) {
        this.singletonList = singletonList;
    }

    public Map getSingletonMap() {
        return singletonMap;
    }

    public void setSingletonMap(Map singletonMap) {
        this.singletonMap = singletonMap;
    }

    public Set getSingletonSet() {
        return singletonSet;
    }

    public void setSingletonSet(Set singletonSet) {
        this.singletonSet = singletonSet;
    }
}

