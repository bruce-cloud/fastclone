package com.brucecloud.fastclone.cloner;

import com.brucecloud.fastclone.FastClone;

/**
 * long[]克隆器.
 * created at 2017/3/14 19:43.
 *
 * @author yaoxh.
 */
public class LongArrayCloner extends Cloner<long[]> {
    /**
     * 复制对象
     *
     * @param fastClone fastClone
     * @param original  原始对象
     * @return 目标对象
     */
    @Override
    public long[] copy(FastClone fastClone, long[] original) throws Exception {
        long[] copy = new long[original.length];
        System.arraycopy(original, 0, copy, 0, copy.length);
        return copy;
    }
}

