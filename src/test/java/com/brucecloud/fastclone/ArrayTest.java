package com.brucecloud.fastclone;

import com.brucecloud.fastclone.bean.ArrayBean;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;

/**
 * .
 * created at 2017/3/15 11:07.
 *
 * @author yaoxh.
 */
public class ArrayTest {
    @Test
    public void immutable() throws Exception {
        ArrayBean arrayBean = getBean();
        FastClone fastClone = new FastClone();

        int total = 100;
        System.out.println(total + "数据");

        int i = 0;
        long start = System.currentTimeMillis();
        while (i < total) {
            ArrayBean clone = fastClone.clone(arrayBean);
            i++;
        }
        long end = System.currentTimeMillis();
        System.out.println("clone 耗时: " + (end - start));

        i = 0;
        start = System.currentTimeMillis();
        while (i < total) {
            ArrayBean clone = fastClone.cloneShallow(arrayBean);
            i++;
        }
        end = System.currentTimeMillis();
        System.out.println("cloneShallow 耗时: " + (end - start));
        System.out.println();
    }

    private ArrayBean getBean() throws MalformedURLException {
        ArrayBean arrayBean = new ArrayBean();
        arrayBean.setChars(new char[]{'a', 'b'});
        arrayBean.setBytes(new byte[]{1, 2});
        arrayBean.setShorts(new short[]{3, 4});
        arrayBean.setInts(new int[]{5, 6});
        arrayBean.setLongs(new long[]{7, 8});
        arrayBean.setFloats(new float[]{1.0f, 2.0f});
        arrayBean.setDoubles(new double[]{3.0, 4.0});
        arrayBean.setBooleans(new boolean[]{true, false});
        arrayBean.setStrings(new String[]{"aaa", "bbb"});
        arrayBean.setObjects(new Object[]{"aaa", new Integer(10)});
//        arrayBean.setObjects(new Object[]{new User(), new Integer(10)});
        arrayBean.setLongArray(new Long[]{new Long(100), 200L});
        return arrayBean;
    }
}

