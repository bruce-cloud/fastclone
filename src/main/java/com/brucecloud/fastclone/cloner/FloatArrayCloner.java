package com.brucecloud.fastclone.cloner;

import com.brucecloud.fastclone.FastClone;

/**
 * float[]克隆器.
 * created at 2017/3/14 19:45.
 *
 * @author yaoxh.
 */
public class FloatArrayCloner extends Cloner<float[]> {
    /**
     * 复制对象
     *
     * @param fastClone fastClone
     * @param original  原始对象
     * @return 目标对象
     */
    @Override
    public float[] copy(FastClone fastClone, float[] original) throws Exception {
        float[] copy = new float[original.length];
        System.arraycopy(original, 0, copy, 0, copy.length);
        return copy;
    }
}

