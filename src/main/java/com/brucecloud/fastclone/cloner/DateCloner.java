package com.brucecloud.fastclone.cloner;

import com.brucecloud.fastclone.FastClone;

import java.lang.reflect.Constructor;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Date克隆器.
 * created at 2017/3/14 19:59.
 *
 * @author yaoxh.
 */
public class DateCloner extends Cloner<Date> {
    /**
     * 复制对象
     *
     * @param fastClone fastClone
     * @param original  原始对象
     * @return 目标对象
     */
    @Override
    public Date copy(FastClone fastClone, Date original) throws Exception {
        return create(original.getClass(), original.getTime());
    }

    private Date create(Class<? extends Date> type, long time) throws Exception {
        if (type == Date.class || type == null) {
            return new Date(time);
        }
        if (type == Timestamp.class) {
            return new Timestamp(time);
        }
        if (type == java.sql.Date.class) {
            return new java.sql.Date(time);
        }
        if (type == Time.class) {
            return new Time(time);
        }
        try {
            Constructor<? extends Date> constructor = type.getConstructor(long.class);
            if (!constructor.isAccessible()) {
                try {
                    constructor.setAccessible(true);
                } catch (SecurityException se) {
                }
            }
            return constructor.newInstance(time);
        } catch (Exception ex) {
            return new Date(time);
        }
    }
}

