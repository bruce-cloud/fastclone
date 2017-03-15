package com.brucecloud.fastclone.cloner;

import com.brucecloud.fastclone.FastClone;

import java.util.Map;

/**
 * Map克隆器.
 * created at 2017/3/15 10:45.
 *
 * @author yaoxh.
 */
public class MapCloner extends Cloner<Map> {
    /**
     * 复制对象
     *
     * @param fastClone fastClone
     * @param original  原始对象
     * @return 目标对象
     */
    @Override
    public Map copy(FastClone fastClone, Map original) throws Exception {
        Map copy = createCopy(original);
        for (Object object : original.entrySet()) {
            Map.Entry entry = (Map.Entry) object;
            copy.put(fastClone.clone(entry.getKey()), fastClone.clone(entry.getValue()));
        }
        return copy;
    }

    /**
     * 创建copy集合
     *
     * @param original 原始集合
     * @return 复制后的集合
     */
    protected Map createCopy(Map original) throws Exception {
        return original.getClass().newInstance();
    }
}

