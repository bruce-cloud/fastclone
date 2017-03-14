package com.brucecloud.fastclone.field;

import com.brucecloud.fastclone.cloner.FieldCloner;

import java.lang.reflect.Field;

/**
 * 缓存域工厂接口.
 * created at 2017/3/14 10:56.
 *
 * @author yaoxh.
 */
public interface CachedFieldFactory {
    /**
     * 创建缓存域
     *
     * @param fieldClass  域class
     * @param field       域
     * @param fieldCloner 域克隆器
     * @return 缓存域
     */
    CachedField createCachedField(Class fieldClass, Field field, FieldCloner fieldCloner);
}

