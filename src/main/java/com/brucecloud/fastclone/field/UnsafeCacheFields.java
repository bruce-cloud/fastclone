package com.brucecloud.fastclone.field;

import com.brucecloud.fastclone.cloner.FieldCloner;

import java.lang.reflect.Field;

import static com.brucecloud.fastclone.util.UnsafeUtil.unsafe;

/**
 * Unsafe缓存域.
 * created at 2017/3/14 10:56.
 *
 * @author yaoxh.
 */
class UnsafeCacheFields {

    /**
     * Unsafe缓存域抽象类
     */
    abstract static class UnsafeCachedField extends CachedField {
        UnsafeCachedField(long offset) {// Field偏移量
            this.offset = offset;
        }
    }

    /**
     * Unsafe int缓存域
     */
    final static class UnsafeIntField extends UnsafeCachedField {
        public UnsafeIntField(Field f) {
            // f的偏移量
            super(unsafe().objectFieldOffset(f));
        }

        /**
         * 对象复制
         *
         * @param original 原始对象
         * @param copy     新对象
         */
        public void copy(Object original, Object copy) {
            unsafe().putInt(copy, offset, unsafe().getInt(original, offset));
        }
    }

    /**
     * Unsafe float缓存域
     */
    final static class UnsafeFloatField extends UnsafeCachedField {
        public UnsafeFloatField(Field f) {
            // f的偏移量
            super(unsafe().objectFieldOffset(f));
        }

        /**
         * 对象复制
         *
         * @param original 原始对象
         * @param copy     新对象
         */
        public void copy(Object original, Object copy) {
            unsafe().putFloat(copy, offset, unsafe().getFloat(original, offset));
        }
    }

    /**
     * Unsafe short缓存域
     */
    final static class UnsafeShortField extends UnsafeCachedField {
        public UnsafeShortField(Field f) {
            // f的偏移量
            super(unsafe().objectFieldOffset(f));
        }

        /**
         * 对象复制
         *
         * @param original 原始对象
         * @param copy     新对象
         */
        public void copy(Object original, Object copy) {
            unsafe().putShort(copy, offset, unsafe().getShort(original, offset));
        }
    }

    /**
     * Unsafe byte缓存域
     */
    final static class UnsafeByteField extends UnsafeCachedField {
        public UnsafeByteField(Field f) {
            // f的偏移量
            super(unsafe().objectFieldOffset(f));
        }

        /**
         * 对象复制
         *
         * @param original 原始对象
         * @param copy     新对象
         */
        public void copy(Object original, Object copy) {
            unsafe().putByte(copy, offset, unsafe().getByte(original, offset));
        }
    }

    /**
     * Unsafe boolean缓存域
     */
    final static class UnsafeBooleanField extends UnsafeCachedField {
        public UnsafeBooleanField(Field f) {
            // f的偏移量
            super(unsafe().objectFieldOffset(f));
        }

        /**
         * 对象复制
         *
         * @param original 原始对象
         * @param copy     新对象
         */
        public void copy(Object original, Object copy) {
            unsafe().putBoolean(copy, offset, unsafe().getBoolean(original, offset));
        }
    }

    /**
     * Unsafe char缓存域
     */
    final static class UnsafeCharField extends UnsafeCachedField {
        public UnsafeCharField(Field f) {
            // f的偏移量
            super(unsafe().objectFieldOffset(f));
        }

        /**
         * 对象复制
         *
         * @param original 原始对象
         * @param copy     新对象
         */
        public void copy(Object original, Object copy) {
            unsafe().putChar(copy, offset, unsafe().getChar(original, offset));
        }
    }

    /**
     * Unsafe long缓存域
     */
    final static class UnsafeLongField extends UnsafeCachedField {
        public UnsafeLongField(Field f) {
            // f的偏移量
            super(unsafe().objectFieldOffset(f));
        }

        /**
         * 对象复制
         *
         * @param original 原始对象
         * @param copy     新对象
         */
        public void copy(Object original, Object copy) {
            unsafe().putLong(copy, offset, unsafe().getLong(original, offset));
        }
    }

    /**
     * Unsafe double缓存域
     */
    final static class UnsafeDoubleField extends UnsafeCachedField {
        public UnsafeDoubleField(Field f) {
            // f的偏移量
            super(unsafe().objectFieldOffset(f));
        }

        /**
         * 对象复制
         *
         * @param original 原始对象
         * @param copy     新对象
         */
        public void copy(Object original, Object copy) {
            unsafe().putDouble(copy, offset, unsafe().getDouble(original, offset));
        }
    }

    /**
     * Unsafe String缓存域
     */
    final static class UnsafeStringField extends UnsafeCachedField {
        public UnsafeStringField(Field f) {
            // f的偏移量
            super(unsafe().objectFieldOffset(f));
        }

        /**
         * 对象复制
         *
         * @param original 原始对象
         * @param copy     新对象
         */
        public void copy(Object original, Object copy) {
            unsafe().putObject(copy, offset, unsafe().getObject(original, offset));
        }
    }

    /**
     * Unsafe 范围缓存域
     */
    final static class UnsafeRegionField extends UnsafeCachedField {
        // 长度
        final long len;
        // 容量读取
        static final boolean bulkReadsSupported = false;

        public UnsafeRegionField(long offset, long len) {
            // f的偏移量
            super(offset);
            this.len = len;
        }

        /**
         * 区域内存复制
         *
         * @param original 原始对象
         * @param copy     新对象
         */
        public void copy(Object original, Object copy) {
            unsafe().copyMemory(original, offset, copy, offset, len);
        }
    }

    /**
     * Unsafe Object缓存域
     */
    final static class UnsafeObjectField extends ObjectField {
        public UnsafeObjectField(FieldCloner fieldCloner) {
            super(fieldCloner);
        }

        public Object getField(Object object) throws IllegalArgumentException, IllegalAccessException {
            if (offset >= 0) {
                return unsafe().getObject(object, offset);
            } else
                throw new RuntimeException("Unknown offset");
        }

        public void setField(Object object, Object value) throws IllegalArgumentException, IllegalAccessException {
            if (offset != -1)
                unsafe().putObject(object, offset, value);
            else
                throw new RuntimeException("Unknown offset");
        }

        /**
         * 对象复制
         *
         * @param original 原始对象
         * @param copy     新对象
         */
        public void copy(Object original, Object copy) throws Exception {
            if (offset != -1) {
                unsafe().putObject(copy, offset, fastClone.copy(unsafe().getObject(original, offset)));
            } else
                throw new RuntimeException("Unknown offset");
        }
    }
}
