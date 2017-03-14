package com.brucecloud.fastclone.cloner;

import com.brucecloud.fastclone.FastClone;

/**
 * double[]克隆器.
 * created at 2017/3/14 19:46.
 *
 * @author yaoxh.
 */
public class DoubleArrayCloner extends Cloner<double[]> {
    /**
     * 复制对象
     *
     * @param fastClone fastClone
     * @param original  原始对象
     * @return 目标对象
     */
    @Override
    public double[] copy(FastClone fastClone, double[] original) throws Exception {
        double[] copy = new double[original.length];
        System.arraycopy(original, 0, copy, 0, copy.length);
        return copy;
    }
}

