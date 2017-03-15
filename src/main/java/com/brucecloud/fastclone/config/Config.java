package com.brucecloud.fastclone.config;

import com.brucecloud.fastclone.FastClone;
import com.brucecloud.fastclone.cloner.Cloner;
import com.brucecloud.fastclone.cloner.FieldCloner;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 配置.
 * created at 2017/3/14 14:44.
 *
 * @author yaoxh.
 */
public abstract class Config {
    /**
     * 默认克隆器
     */
    private Map<Class<?>, Cloner<?>> defaultCloner = new ConcurrentHashMap<>();

    /**
     * 引用处理器
     */
    private Map<Class, Boolean> referenceResolver = new ConcurrentHashMap<>();

    /**
     * 获取指定类型的默认克隆器
     *
     * @param type 指定类型
     * @return 指定类型的默认克隆器
     */
    public Cloner getDefaultCloner(FastClone fastClone, Class type) {
        Cloner cloner = defaultCloner.get(type);
        if(cloner == null){
            for(Map.Entry<Class<?>, Cloner<?>> entry: defaultCloner.entrySet()){
                Class key = entry.getKey();
                if(key.isAssignableFrom(type)){
                    defaultCloner.putIfAbsent(type, entry.getValue());
                    cloner = entry.getValue();
                    break;
                }
            }
        }
//        if(cloner == null && type.getSuperclass() != null){
//            while (!type.getSuperclass().equals(Object.class)) {
//                type = type.getSuperclass();
//            }
//            cloner = defaultCloner.get(type);
//        }
        if (cloner == null) {
            cloner = new FieldCloner(fastClone, type);
            defaultCloner.putIfAbsent(type, cloner);
        }
        return cloner;
    }

    /**
     * 获取指定Class类型是否开启强制创建引用类型
     *
     * @param type 类型
     * @return 是/否
     */
    public boolean useReference(Class type) {
        return referenceResolver.get(type) == null ? false : referenceResolver.get(type);
    }

    /**
     * 注册克隆器
     *
     * @param type   类型
     * @param cloner 克隆器
     */
    protected void registerCloner(Class type, Cloner cloner) {
        if (type == null || cloner == null) return;
        defaultCloner.put(type, cloner);
    }

    /**
     * 注册引用处理器
     *
     * @param type 类型
     */
    protected void registerReferenceResolver(Class type) {
        if (type == null) return;
        referenceResolver.put(type, true);
    }

    /**
     * 注册默认克隆器
     */
    protected abstract void registerDefaultCloner();

    /**
     * 注册默认引用处理器
     */
    protected abstract void registerDefaultReferenceResolver();
}

