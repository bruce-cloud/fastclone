package com.brucecloud.fastclone.cloner;

import com.brucecloud.fastclone.FastClone;

/**
 * 克隆器抽象类.
 * created at 2017/3/13 18:15.
 *
 * @author yaoxh.
 */
public abstract class Cloner<T> {
    /**
     * 复制对象
     *
     * @param fastClone fastClone
     * @param original  原始对象
     * @return 目标对象
     */
    public T copy(FastClone fastClone, T original) throws Exception {
        // 直接返回原始对象
        return original;
    }
}
