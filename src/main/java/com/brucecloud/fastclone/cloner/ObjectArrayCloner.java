package com.brucecloud.fastclone.cloner;

import com.brucecloud.fastclone.FastClone;

import java.lang.reflect.Array;

/**
 * Object[]克隆器.
 * created at 2017/3/14 19:53.
 *
 * @author yaoxh.
 */
public class ObjectArrayCloner extends Cloner<Object[]> {
    /**
     * 复制对象
     *
     * @param fastClone fastClone
     * @param original  原始对象
     * @return 目标对象
     */
    @Override
    public Object[] copy(FastClone fastClone, Object[] original) throws Exception {
        Object[] copy = (Object[]) Array.newInstance(original.getClass().getComponentType(), original.length);
        for (int i = 0, n = original.length; i < n; i++)
            copy[i] = fastClone.clone(original[i]);
        return copy;
    }
}

