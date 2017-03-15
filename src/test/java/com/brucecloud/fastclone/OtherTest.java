package com.brucecloud.fastclone;

import com.brucecloud.fastclone.bean.CompareBean;
import com.brucecloud.fastclone.bean.EnumBean;
import com.brucecloud.fastclone.bean.OtherBean;
import org.junit.jupiter.api.Test;

import java.net.MalformedURLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.*;

/**
 * .
 * created at 2017/3/15 16:43.
 *
 * @author yaoxh.
 */
public class OtherTest {
    @Test
    public void array() throws Exception {
        OtherBean otherBean = getBean();
        FastClone fastClone = new FastClone();

        int total = 1000000;
        System.out.println(total + "数据");

        int i = 0;
        long start = System.currentTimeMillis();
        while (i < total) {
            OtherBean clone = fastClone.clone(otherBean);
            i++;
        }
        long end = System.currentTimeMillis();
        System.out.println("clone 耗时: " + (end - start));

        i = 0;
        start = System.currentTimeMillis();
        while (i < total) {
            OtherBean clone = fastClone.cloneShallow(otherBean);
            i++;
        }
        end = System.currentTimeMillis();
        System.out.println("cloneShallow 耗时: " + (end - start));
        System.out.println();
    }

    private OtherBean getBean() throws MalformedURLException {
        OtherBean otherBean = new OtherBean();
        otherBean.setDate(new Date());
        otherBean.setTimestamp(new Timestamp(System.currentTimeMillis()));
        otherBean.setSqlDate(new java.sql.Date(System.currentTimeMillis()));
        otherBean.setTime(new Time(System.currentTimeMillis()));
        Collection<EnumBean> collection = new ArrayList<>();
        collection.add(EnumBean.AA);
        collection.add(EnumBean.BB);
        EnumSet enumSet = EnumSet.copyOf(collection);
        otherBean.setEnumSet(enumSet);
        otherBean.setStringBuffer(new StringBuffer("a"));
        otherBean.setStringBuilder(new StringBuilder("b"));
        TreeSet treeSet = new TreeSet();
        treeSet.add(new CompareBean("bean1", 30));
        treeSet.add(new CompareBean("bean2", 50));
        treeSet.add(new CompareBean("bean3", 10));
        otherBean.setTreeSet(treeSet);
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 10);
        map.put("b", 20);
        otherBean.setMap(map);
        TreeMap<CompareBean, Integer> treeMap = new TreeMap<>();
        treeMap.put(new CompareBean("bean1", 20), 20);
        treeMap.put(new CompareBean("bean2", 10), 10);
        otherBean.setTreeMap(treeMap);
        Calendar calendar = Calendar.getInstance();
        otherBean.setCalendar(calendar);
        return otherBean;
    }
}

