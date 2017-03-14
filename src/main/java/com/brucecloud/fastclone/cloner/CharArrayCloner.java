package com.brucecloud.fastclone.cloner;

import com.brucecloud.fastclone.FastClone;

/**
 * 字符数组克隆器.
 * created at 2017/3/14 14:39.
 *
 * @author yaoxh.
 */
public class CharArrayCloner extends Cloner<char[]> {
    /**
     * char[]复制
     *
     * @param fastClone fastClone
     * @param original  原始对象
     * @return char[]
     */
    public char[] copy(FastClone fastClone, char[] original) {
        char[] copy = new char[original.length];
        System.arraycopy(original, 0, copy, 0, copy.length);
        return copy;
    }
}

