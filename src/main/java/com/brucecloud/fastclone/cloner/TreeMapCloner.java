package com.brucecloud.fastclone.cloner;

import java.lang.reflect.Constructor;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

/**
 * TreeMap克隆器.
 * created at 2017/3/15 10:52.
 *
 * @author yaoxh.
 */
public class TreeMapCloner extends MapCloner {

    /**
     * 创建copy集合
     *
     * @param original 原始集合
     * @return 复制后的集合
     */
    protected Map createCopy(Map original) throws Exception {
        return createTreeMap(original.getClass(), ((TreeMap) original).comparator());
    }

    /**
     * 创建TreeMap
     *
     * @param type       集合类型
     * @param comparator 比较器
     * @return 新的TreeMap
     */
    private TreeMap createTreeMap(Class<? extends Map> type, Comparator comparator) throws Exception {
        if (type != TreeMap.class && type != null) {
            Constructor constructor = type.getConstructor(Comparator.class);
            if (!constructor.isAccessible()) {
                try {
                    constructor.setAccessible(true);
                } catch (SecurityException se) {
                }
            }
            return (TreeMap) constructor.newInstance(comparator);
        }
        return new TreeMap(comparator);
    }
}

