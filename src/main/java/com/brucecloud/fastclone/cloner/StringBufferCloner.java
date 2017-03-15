package com.brucecloud.fastclone.cloner;

import com.brucecloud.fastclone.FastClone;

/**
 * StringBuffer克隆器.
 * created at 2017/3/15 10:10.
 *
 * @author yaoxh.
 */
public class StringBufferCloner extends Cloner<StringBuffer> {
    /**
     * 复制对象
     *
     * @param fastClone fastClone
     * @param original  原始对象
     * @return 目标对象
     */
    @Override
    public StringBuffer copy(FastClone fastClone, StringBuffer original) throws Exception {
        return new StringBuffer(original);
    }
}

