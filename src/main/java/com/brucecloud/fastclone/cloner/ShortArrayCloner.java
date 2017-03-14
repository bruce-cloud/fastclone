package com.brucecloud.fastclone.cloner;

import com.brucecloud.fastclone.FastClone;

/**
 * short[]克隆器.
 * created at 2017/3/14 19:39.
 *
 * @author yaoxh.
 */
public class ShortArrayCloner extends Cloner<short[]> {
    /**
     * 复制对象
     *
     * @param fastClone fastClone
     * @param original  原始对象
     * @return 目标对象
     */
    @Override
    public short[] copy(FastClone fastClone, short[] original) throws Exception {
        short[] copy = new short[original.length];
        System.arraycopy(original, 0, copy, 0, copy.length);
        return copy;
    }
}

