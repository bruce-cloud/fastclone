package com.brucecloud.fastclone.cloner;

import com.brucecloud.fastclone.FastClone;
import com.brucecloud.fastclone.field.CachedField;
import com.brucecloud.fastclone.field.CachedFieldFactory;
import com.brucecloud.fastclone.util.ClassUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.brucecloud.fastclone.util.UnsafeUtil.unsafe;

/**
 * Field序列化.
 * created at 2017/3/13 18:05.
 *
 * @author yaoxh.
 */
public class FieldCloner<T> extends Cloner<T> {
    public final FastClone fastClone;
    public final Class type;
    private CachedField[] fields = new CachedField[0];
    private static CachedFieldFactory unsafeFieldFactory;
    /**
     * type-Field缓存
     */
    private final static ConcurrentHashMap<Class<?>, List<Field>> fieldsCache = new ConcurrentHashMap<>();

    /**
     * type-cachedField缓存
     */
    private static Map<Class, CachedField[]> fieldMap = new ConcurrentHashMap<>();

    public FieldCloner(FastClone fastClone, Class type) {
        this.fastClone = fastClone;
        this.type = type;
        initCacheFields(type);
    }

    /**
     * 复制对象
     *
     * @param fastClone fastClone
     * @param original  原始对象
     * @return 目标对象
     */
    @Override
    @SuppressWarnings("unchecked")
    public T copy(FastClone fastClone, T original) throws Exception {
        T copy = (T) original.getClass().newInstance();
        for (CachedField field : fields) {
            field.copy(original, copy);
        }
        return copy;
    }

    public void initCacheFields(Class type) {
        fields = fieldMap.get(type);
        if (fields != null) {
            return;
        }
        List<Field> fieldList = getAllFields(type);
        List<CachedField> cachedFields = new ArrayList<>(fieldList.size());
        for (Field field : fieldList) {
            int accessIndex = -1;
            cachedFields.add(newCachedField(field, accessIndex));
        }
        fields = cachedFields.toArray(new CachedField[cachedFields.size()]);
        fieldMap.putIfAbsent(type, fields);
    }

    private List<Field> getAllFields(final Class<?> type) {
        List<Field> allFields = fieldsCache.get(type);
        if (allFields == null) {
            allFields = new ArrayList<>();
            Class nextClass = type;
            while (nextClass != Object.class) {
                Field[] declaredFields = nextClass.getDeclaredFields();
                if (declaredFields != null) {
                    for (Field f : declaredFields) {
                        if (Modifier.isStatic(f.getModifiers())) continue;
                        allFields.add(f);
                    }
                }
                nextClass = nextClass.getSuperclass();
            }
            fieldsCache.putIfAbsent(type, allFields);
        }
        return allFields;
    }

    private CachedField newCachedField(Field field, int accessIndex) {
        Class[] fieldClass = new Class[]{field.getType()};
        CachedField cachedField;

        cachedField = newMatchingCachedField(field, fieldClass[0]);
        cachedField.field = field;
        cachedField.offset = unsafe().objectFieldOffset(field);
        cachedField.accessIndex = accessIndex;
        cachedField.canBeNull = !fieldClass[0].isPrimitive();

        // 如果field是final类型的, 则保存这个field的值, 供所有克隆对象使用
        if (ClassUtil.isFinal(fieldClass[0])) cachedField.valueClass = fieldClass[0];
        return cachedField;
    }

    private CachedField newMatchingCachedField(Field field, Class fieldClass) {
        return getUnsafeFieldFactory().createCachedField(fieldClass, field, this);
    }

    private CachedFieldFactory getUnsafeFieldFactory() {
        if (unsafeFieldFactory == null) {
            try {
                unsafeFieldFactory = (CachedFieldFactory) this.getClass().getClassLoader()
                        .loadClass("com.brucecloud.fastclone.field.UnsafeCachedFieldFactory").newInstance();
            } catch (Exception e) {
                throw new RuntimeException("Cannot create UnsafeFieldFactory", e);
            }
        }
        return unsafeFieldFactory;
    }
}

