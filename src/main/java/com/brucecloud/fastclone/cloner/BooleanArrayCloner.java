package com.brucecloud.fastclone.cloner;

import com.brucecloud.fastclone.FastClone;

/**
 * boolean克隆器.
 * created at 2017/3/14 19:48.
 *
 * @author yaoxh.
 */
public class BooleanArrayCloner extends Cloner<boolean[]> {
    /**
     * 复制对象
     *
     * @param fastClone fastClone
     * @param original  原始对象
     * @return 目标对象
     */
    @Override
    public boolean[] copy(FastClone fastClone, boolean[] original) throws Exception {
        boolean[] copy = new boolean[original.length];
        System.arraycopy(original, 0, copy, 0, copy.length);
        return copy;
    }
}

