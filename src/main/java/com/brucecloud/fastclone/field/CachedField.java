package com.brucecloud.fastclone.field;

import com.brucecloud.fastclone.cloner.Cloner;

import java.lang.reflect.Field;

/**
 * 缓存域.
 * created at 2017/3/13 20:00.
 *
 * @author yaoxh.
 */
public abstract class CachedField<T> {
    public Field field;
    public Class valueClass;
    private Cloner cloner;
    public boolean canBeNull;
    public int accessIndex = -1;
    public long offset = -1;
    public boolean varIntsEnabled = true;

    public void setCloner(Cloner cloner) {
        this.cloner = cloner;
    }

    public Cloner getCloner() {
        return this.cloner;
    }

    public void setCanBeNull(boolean canBeNull) {
        this.canBeNull = canBeNull;
    }

    public Field getField() {
        return field;
    }

    public String toString() {
        return field.getName();
    }

    /**
     * 对象复制
     *
     * @param original 原始对象
     * @param copy     新对象
     */
    abstract public void copy(Object original, Object copy) throws Exception;
}

