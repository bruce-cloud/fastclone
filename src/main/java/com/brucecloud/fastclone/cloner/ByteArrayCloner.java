package com.brucecloud.fastclone.cloner;

import com.brucecloud.fastclone.FastClone;

/**
 * 字节数组克隆器.
 * created at 2017/3/14 19:36.
 *
 * @author yaoxh.
 */
public class ByteArrayCloner extends Cloner<byte[]>{
    /**
     * 复制对象
     *
     * @param fastClone fastClone
     * @param original  原始对象
     * @return 目标对象
     */
    @Override
    public byte[] copy(FastClone fastClone, byte[] original) throws Exception {
        byte[] copy = new byte[original.length];
        System.arraycopy(original, 0, copy, 0, copy.length);
        return copy;
    }
}

