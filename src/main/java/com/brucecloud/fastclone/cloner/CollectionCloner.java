package com.brucecloud.fastclone.cloner;

import com.brucecloud.fastclone.FastClone;

import java.util.Collection;

/**
 * Collection克隆器.
 * created at 2017/3/14 11:51.
 *
 * @author yaoxh.
 */
public class CollectionCloner extends Cloner<Collection> {

    /**
     * 集合复制
     *
     * @param fastClone fastClone
     * @param original  原始集合
     * @return 复制后的集合
     */
    @SuppressWarnings("unchecked")
    public Collection copy(FastClone fastClone, Collection original) throws Exception {
        Collection copy = original.getClass().newInstance();
        for (Object element : original)
            copy.add(fastClone.clone(element));
        return copy;
    }
}

