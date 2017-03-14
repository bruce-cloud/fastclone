package com.brucecloud.fastclone.cloner;

import com.brucecloud.fastclone.FastClone;

/**
 * String[]克隆器.
 * created at 2017/3/14 19:52.
 *
 * @author yaoxh.
 */
public class StringArrayCloner extends Cloner<String[]> {
    /**
     * 复制对象
     *
     * @param fastClone fastClone
     * @param original  原始对象
     * @return 目标对象
     */
    @Override
    public String[] copy(FastClone fastClone, String[] original) throws Exception {
        String[] copy = new String[original.length];
        System.arraycopy(original, 0, copy, 0, copy.length);
        return copy;
    }
}

