package com.brucecloud.fastclone.util;

import java.lang.reflect.Modifier;

/**
 * Class工具类.
 * created at 2017/3/14 15:40.
 *
 * @author yaoxh.
 */
public class ClassUtil {
    public static boolean isFinal(Class type) {
        if (type == null) throw new IllegalArgumentException("type cannot be null.");
        if (type.isArray()) return Modifier.isFinal(getElementClass(type).getModifiers());
        return Modifier.isFinal(type.getModifiers());
    }

    private static Class getElementClass(Class arrayClass) {
        Class elementClass = arrayClass;
        while (elementClass.getComponentType() != null)
            elementClass = elementClass.getComponentType();
        return elementClass;
    }
}

