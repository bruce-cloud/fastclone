package com.brucecloud.fastclone.cloner;

import com.brucecloud.fastclone.FastClone;

/**
 * int[]克隆器.
 * created at 2017/3/14 19:41.
 *
 * @author yaoxh.
 */
public class IntArrayCloner extends Cloner<int[]> {
    /**
     * 复制对象
     *
     * @param fastClone fastClone
     * @param original  原始对象
     * @return 目标对象
     */
    @Override
    public int[] copy(FastClone fastClone, int[] original) throws Exception {
        int[] copy = new int[original.length];
        System.arraycopy(original, 0, copy, 0, copy.length);
        return copy;
    }
}

