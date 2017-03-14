package com.brucecloud.fastclone.cloner;

import com.brucecloud.fastclone.FastClone;

import java.util.EnumSet;

/**
 * EnumSet克隆器.
 * created at 2017/3/14 20:07.
 *
 * @author yaoxh.
 */
public class EnumSetCloner extends Cloner<EnumSet> {
    /**
     * 复制对象
     *
     * @param fastClone fastClone
     * @param original  原始对象
     * @return 目标对象
     */
    @Override
    public EnumSet copy(FastClone fastClone, EnumSet original) throws Exception {
        return EnumSet.copyOf(original);
    }
}

