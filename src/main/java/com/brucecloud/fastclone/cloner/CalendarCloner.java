package com.brucecloud.fastclone.cloner;

import com.brucecloud.fastclone.FastClone;

import java.util.Calendar;

/**
 * Calendar克隆器.
 * created at 2017/3/15 10:56.
 *
 * @author yaoxh.
 */
public class CalendarCloner extends Cloner<Calendar> {
    /**
     * 复制对象
     *
     * @param fastClone fastClone
     * @param original  原始对象
     * @return 目标对象
     */
    @Override
    public Calendar copy(FastClone fastClone, Calendar original) throws Exception {
        return (Calendar) original.clone();
    }
}

