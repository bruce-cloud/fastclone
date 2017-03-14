package com.brucecloud.fastclone.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.Cleaner;
import sun.misc.Unsafe;
import sun.nio.ch.DirectBuffer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Unsafe工具类.
 * created at 2017/3/14 10:00.
 *
 * @author yaoxh.
 */
public class UnsafeUtil {
    private static Logger logger = LoggerFactory.getLogger(UnsafeUtil.class);
    private final static Unsafe _unsafe;
    private final static long byteArrayBaseOffset;
    private final static long floatArrayBaseOffset;
    private final static long doubleArrayBaseOffset;
    private final static long intArrayBaseOffset;
    private final static long longArrayBaseOffset;
    private final static long shortArrayBaseOffset;
    private final static long charArrayBaseOffset;

    // 用于创建使用预先分配的ByteBuffer的构造函数
    private static Constructor<? extends ByteBuffer> directByteBufferConstr;


    static {
        Unsafe tmpUnsafe = null;
        long tmpByteArrayBaseOffset = 0;
        long tmpFloatArrayBaseOffset = 0;
        long tmpDoubleArrayBaseOffset = 0;
        long tmpIntArrayBaseOffset = 0;
        long tmpLongArrayBaseOffset = 0;
        long tmpShortArrayBaseOffset = 0;
        long tmpCharArrayBaseOffset = 0;

        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            tmpUnsafe = (Unsafe) field.get(null);
            tmpByteArrayBaseOffset = tmpUnsafe.arrayBaseOffset(byte[].class);
            tmpCharArrayBaseOffset = tmpUnsafe.arrayBaseOffset(char[].class);
            tmpShortArrayBaseOffset = tmpUnsafe.arrayBaseOffset(short[].class);
            tmpIntArrayBaseOffset = tmpUnsafe.arrayBaseOffset(int[].class);
            tmpFloatArrayBaseOffset = tmpUnsafe.arrayBaseOffset(float[].class);
            tmpLongArrayBaseOffset = tmpUnsafe.arrayBaseOffset(long[].class);
            tmpDoubleArrayBaseOffset = tmpUnsafe.arrayBaseOffset(double[].class);
        } catch (Exception e) {
            logger.error("sun.misc.Unsafe is not accessible or not available. Use of sun.misc.Unsafe should be disabled", e);
        }

        // 获取unsafe失败时取默认值
        byteArrayBaseOffset = tmpByteArrayBaseOffset;
        charArrayBaseOffset = tmpCharArrayBaseOffset;
        shortArrayBaseOffset = tmpShortArrayBaseOffset;
        intArrayBaseOffset = tmpIntArrayBaseOffset;
        floatArrayBaseOffset = tmpFloatArrayBaseOffset;
        longArrayBaseOffset = tmpLongArrayBaseOffset;
        doubleArrayBaseOffset = tmpDoubleArrayBaseOffset;
        _unsafe = tmpUnsafe;
    }

    static {
        // DirectByteBuffer
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1);
        try {
            directByteBufferConstr = byteBuffer.getClass().getDeclaredConstructor(long.class, int.class, Object.class);
            directByteBufferConstr.setAccessible(true);
        } catch (Exception e) {
            directByteBufferConstr = null;
        }
    }


    /**
     * 获取unsafe实例
     *
     * @return unsafe实例
     */
    public static Unsafe unsafe() {
        return _unsafe;
    }

    /**
     * 根据Field的offset从其开始位置进行排序
     *
     * @param allFields 带排序Field
     * @return 排序后的Field
     */
    public static Field[] sortFieldsByOffset(List<Field> allFields) {
        Field[] allFieldsArray = allFields.toArray(new Field[]{});
        // offset排序器
        Comparator<Field> fieldOffsetComparator = (f1, f2) -> {
            long offset1 = unsafe().objectFieldOffset(f1);
            long offset2 = unsafe().objectFieldOffset(f2);
            if (offset1 < offset2) return -1;
            if (offset1 == offset2) return 0;
            return 1;
        };

        Arrays.sort(allFieldsArray, fieldOffsetComparator);
        return allFieldsArray;
    }

    /**
     * 使用指定的内存区域创建一个ByteBuffer
     *
     * @param address 指定内存地址
     * @param size    内存大小
     * @return ByteBuffer
     */
    public static ByteBuffer getDirectBufferAt(long address, int size) {
        if (directByteBufferConstr == null)
            return null;
        try {
            return directByteBufferConstr.newInstance(address, size, null);
        } catch (Exception e) {
            throw new RuntimeException("Cannot allocate ByteBuffer at a given address: " + address, e);
        }
    }

    /**
     * 释放Buffer
     * 如果因为SecurityManager机制导致Cleaner无法获取, clean方法将无法执行
     *
     * @param byteBuffer buffer
     */
    static public void releaseBuffer(ByteBuffer byteBuffer) {
        // 是否是directBuffer
        if (byteBuffer != null && byteBuffer.isDirect()) {
            Object cleaner = ((DirectBuffer) byteBuffer).cleaner();
            if (cleaner != null)
                ((Cleaner) cleaner).clean();
        }
    }
}
