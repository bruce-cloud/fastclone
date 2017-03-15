package com.brucecloud.fastclone.cloner;

import com.brucecloud.fastclone.FastClone;

/**
 * StringBuilder克隆器.
 * created at 2017/3/15 10:12.
 *
 * @author yaoxh.
 */
public class StringBuilderCloner extends Cloner<StringBuilder> {
    /**
     * 复制对象
     *
     * @param fastClone fastClone
     * @param original  原始对象
     * @return 目标对象
     */
    @Override
    public StringBuilder copy(FastClone fastClone, StringBuilder original) throws Exception {
        return new StringBuilder(original);
    }
}

