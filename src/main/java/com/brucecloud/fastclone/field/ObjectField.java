package com.brucecloud.fastclone.field;

import com.brucecloud.fastclone.FastClone;
import com.brucecloud.fastclone.cloner.FieldCloner;

/**
 * 对象缓存域.
 * created at 2017/3/14 11:00.
 *
 * @author yaoxh.
 */
public class ObjectField extends CachedField {
    // 域克隆器
    private final FieldCloner fieldCloner;
    // 域class
    private final Class type;
    // fastClone
    final FastClone fastClone;

    ObjectField(FieldCloner fieldCloner) {
        this.fieldCloner = fieldCloner;
        this.fastClone = fieldCloner.fastClone;
        this.type = fieldCloner.type;
    }

    /**
     * 获取域的值
     *
     * @param object 域所在对象
     * @return 域的值
     */
    public Object getField(Object object) throws IllegalArgumentException, IllegalAccessException {
        return field.get(object);
    }

    /**
     * 设置域的值
     *
     * @param object 域所在对象
     * @param value  域的值
     */
    public void setField(Object object, Object value) throws IllegalArgumentException, IllegalAccessException {
        field.set(object, value);
    }

    /**
     * 对象复制
     *
     * @param original 原始对象
     * @param copy     新对象
     */
    @Override
    public void copy(Object original, Object copy) throws Exception {
        setField(copy, fastClone.copy(getField(original)));
    }

    /**
     * Integer缓存域
     */
    final static class ObjectIntField extends ObjectField {
        public ObjectIntField(FieldCloner fieldCloner) {
            super(fieldCloner);
        }

        public Object getField(Object object) throws IllegalArgumentException, IllegalAccessException {
            return field.getInt(object);
        }

        /**
         * 复制
         *
         * @param original 原始对象
         * @param copy     新对象
         */
        public void copy(Object original, Object copy) {
            try {
                field.setInt(copy, field.getInt(original));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Float缓存域
     */
    final static class ObjectFloatField extends ObjectField {
        public ObjectFloatField(FieldCloner fieldCloner) {
            super(fieldCloner);
        }

        public Object getField(Object object) throws IllegalArgumentException, IllegalAccessException {
            return field.getFloat(object);
        }

        /**
         * 复制
         *
         * @param original 原始对象
         * @param copy     新对象
         */
        public void copy(Object original, Object copy) {
            try {
                field.setFloat(copy, field.getFloat(original));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Short缓存域
     */
    final static class ObjectShortField extends ObjectField {
        public ObjectShortField(FieldCloner fieldCloner) {
            super(fieldCloner);
        }

        public Object getField(Object object) throws IllegalArgumentException, IllegalAccessException {
            return field.getShort(object);
        }

        /**
         * 复制
         *
         * @param original 原始对象
         * @param copy     新对象
         */
        public void copy(Object original, Object copy) {
            try {
                field.setShort(copy, field.getShort(original));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Byte缓存域
     */
    final static class ObjectByteField extends ObjectField {
        public ObjectByteField(FieldCloner fieldCloner) {
            super(fieldCloner);
        }

        public Object getField(Object object) throws IllegalArgumentException, IllegalAccessException {
            return field.getByte(object);
        }

        /**
         * 复制
         *
         * @param original 原始对象
         * @param copy     新对象
         */
        public void copy(Object original, Object copy) {
            try {
                field.setByte(copy, field.getByte(original));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Boolean缓存域
     */
    final static class ObjectBooleanField extends ObjectField {
        public ObjectBooleanField(FieldCloner fieldCloner) {
            super(fieldCloner);
        }

        public Object getField(Object object) throws IllegalArgumentException, IllegalAccessException {
            return field.getBoolean(object);
        }

        /**
         * 复制
         *
         * @param original 原始对象
         * @param copy     新对象
         */
        public void copy(Object original, Object copy) {
            try {
                field.setBoolean(copy, field.getBoolean(original));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Character缓存域
     */
    final static class ObjectCharField extends ObjectField {
        public ObjectCharField(FieldCloner fieldCloner) {
            super(fieldCloner);
        }

        public Object getField(Object object) throws IllegalArgumentException, IllegalAccessException {
            return field.getChar(object);
        }

        /**
         * 复制
         *
         * @param original 原始对象
         * @param copy     新对象
         */
        public void copy(Object original, Object copy) {
            try {
                field.setChar(copy, field.getChar(original));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Long缓存域
     */
    final static class ObjectLongField extends ObjectField {
        public ObjectLongField(FieldCloner fieldCloner) {
            super(fieldCloner);
        }

        public Object getField(Object object) throws IllegalArgumentException, IllegalAccessException {
            return field.getLong(object);
        }

        /**
         * 复制
         *
         * @param original 原始对象
         * @param copy     新对象
         */
        public void copy(Object original, Object copy) {
            try {
                field.setLong(copy, field.getLong(original));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * Double缓存域
     */
    final static class ObjectDoubleField extends ObjectField {
        public ObjectDoubleField(FieldCloner fieldCloner) {
            super(fieldCloner);
        }

        public Object getField(Object object) throws IllegalArgumentException, IllegalAccessException {
            return field.getDouble(object);
        }

        /**
         * 复制
         *
         * @param original 原始对象
         * @param copy     新对象
         */
        public void copy(Object original, Object copy) {
            try {
                field.setDouble(copy, field.getDouble(original));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
