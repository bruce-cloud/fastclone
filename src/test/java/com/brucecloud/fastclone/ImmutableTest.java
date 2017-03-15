package com.brucecloud.fastclone;

import com.brucecloud.fastclone.bean.EnumBean;
import com.brucecloud.fastclone.bean.ImmutableBean;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.*;

/**
 * .
 * created at 2017/3/15 11:07.
 *
 * @author yaoxh.
 */
public class ImmutableTest {
    @Test
    public void immutable() throws Exception {
        ImmutableBean immutableBean = getBean();
        FastClone fastClone = new FastClone();

        int total = 1000000;
        System.out.println(total + "数据");

        int i = 0;
        long start = System.currentTimeMillis();
        while (i < total) {
            ImmutableBean clone = fastClone.clone(immutableBean);
            i++;
        }
        long end = System.currentTimeMillis();
        System.out.println("clone 耗时: " + (end - start));

        i = 0;
        start = System.currentTimeMillis();
        while (i < total) {
            ImmutableBean clone = fastClone.cloneShallow(immutableBean);
            i++;
        }
        end = System.currentTimeMillis();
        System.out.println("cloneShallow 耗时: " + (end - start));
        System.out.println();
    }

    private ImmutableBean getBean() throws MalformedURLException {
        ImmutableBean immutableBean = new ImmutableBean();
        immutableBean.setInteger(1);
        immutableBean.setBigDecimal(new BigDecimal(100.123));
        immutableBean.setBigInteger(new BigInteger("100"));
        immutableBean.setAnEnum(EnumBean.AA);
        immutableBean.setTimeZone(new TimeZone() {
            @Override
            public int getOffset(int era, int year, int month, int day, int dayOfWeek, int milliseconds) {
                return 0;
            }

            @Override
            public void setRawOffset(int offsetMillis) {

            }

            @Override
            public int getRawOffset() {
                return 0;
            }

            @Override
            public boolean useDaylightTime() {
                return false;
            }

            @Override
            public boolean inDaylightTime(Date date) {
                return false;
            }
        });
        immutableBean.setLocale(Locale.CHINA);
        immutableBean.setCharset(Charset.defaultCharset());
        immutableBean.setUrl(new URL("http://www.chuchujie.com"));
        immutableBean.setaClass(String.class);
        immutableBean.setCurrency(Currency.getInstance(Locale.CHINA));
        immutableBean.setEmptyList(Collections.EMPTY_LIST);
        immutableBean.setEmptyMap(Collections.EMPTY_MAP);
        immutableBean.setEmptySet(Collections.EMPTY_SET);
        immutableBean.setSingletonList(Collections.singletonList(null));
        immutableBean.setSingletonMap(Collections.singletonMap(null, null));
        immutableBean.setSingletonSet(Collections.singleton(null));
        return immutableBean;
    }
}

