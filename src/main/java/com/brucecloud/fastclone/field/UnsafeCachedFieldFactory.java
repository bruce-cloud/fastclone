package com.brucecloud.fastclone.field;

import com.brucecloud.fastclone.cloner.FieldCloner;

import java.lang.reflect.Field;

/**
 * Unsafe缓存域工厂类.
 * created at 2017/3/14 10:56.
 *
 * @author yaoxh.
 */
public class UnsafeCachedFieldFactory implements CachedFieldFactory {
    /**
     * 创建缓存域
     *
     * @param fieldClass  域class
     * @param field       域
     * @param fieldCloner 域克隆器
     * @return 缓存域
     */
    public CachedField createCachedField(Class fieldClass, Field field, FieldCloner fieldCloner) {
        CachedField cachedField;
        // 如果是基本类型
        if (fieldClass.isPrimitive()) {
            if (fieldClass == boolean.class)// boolean
                cachedField = new UnsafeCacheFields.UnsafeBooleanField(field);
            else if (fieldClass == byte.class)// byte
                cachedField = new UnsafeCacheFields.UnsafeByteField(field);
            else if (fieldClass == char.class) // char
                cachedField = new UnsafeCacheFields.UnsafeCharField(field);
            else if (fieldClass == short.class)// short
                cachedField = new UnsafeCacheFields.UnsafeShortField(field);
            else if (fieldClass == int.class)// int
                cachedField = new UnsafeCacheFields.UnsafeIntField(field);
            else if (fieldClass == long.class)// long
                cachedField = new UnsafeCacheFields.UnsafeLongField(field);
            else if (fieldClass == float.class)// float
                cachedField = new UnsafeCacheFields.UnsafeFloatField(field);
            else if (fieldClass == double.class)// double
                cachedField = new UnsafeCacheFields.UnsafeDoubleField(field);
            else {// Object
                cachedField = new UnsafeCacheFields.UnsafeObjectField(fieldCloner);
            }
        } else if (fieldClass == String.class
                && (!fieldCloner.fastClone.getReferences() || fieldCloner.fastClone.getConfig().useReference(String.class))) {
            // 对String类型是否使用引用类型(new String)
            cachedField = new UnsafeCacheFields.UnsafeStringField(field);
        } else {// Object
            cachedField = new UnsafeCacheFields.UnsafeObjectField(fieldCloner);
        }
        return cachedField;
    }
}
