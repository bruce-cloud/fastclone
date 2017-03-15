package com.brucecloud.fastclone.cloner;

import java.lang.reflect.Constructor;
import java.util.Collection;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * TreeSet克隆器.
 * created at 2017/3/15 10:34.
 *
 * @author yaoxh.
 */
public class TreeSetCloner extends CollectionCloner {

    /**
     * 创建copy集合
     *
     * @param original 原始集合
     * @return 复制后的集合
     */
    protected TreeSet createCopy(Collection original) throws Exception {
        return createTreeSet(original.getClass(), ((TreeSet) original).comparator());
    }

    /**
     * 创建TreeSet
     *
     * @param type       集合类型
     * @param comparator 比较器
     * @return 新的TreeSet
     */
    private TreeSet createTreeSet(Class<? extends Collection> type, Comparator comparator) throws Exception {
        if (type != TreeSet.class && type != null) {
                Constructor constructor = type.getConstructor(Comparator.class);
                if (!constructor.isAccessible()) {
                    try {
                        constructor.setAccessible(true);
                    } catch (SecurityException se) {
                    }
                }
                return (TreeSet) constructor.newInstance(comparator);
        }
        return new TreeSet(comparator);
    }
}

