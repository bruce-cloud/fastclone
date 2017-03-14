package com.brucecloud.fastclone;

import com.brucecloud.fastclone.cloner.Cloner;
import com.brucecloud.fastclone.config.Config;
import com.brucecloud.fastclone.config.DefaultConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;

/**
 * 克隆类.
 * created at 2017/3/13 13:00.
 *
 * @author yaoxh.
 */
public class FastClone {

    private static Logger logger = LoggerFactory.getLogger(FastClone.class);


    private Config config;

    /**
     * 是否开启引用
     */
    private boolean references = true;

    /**
     * 是否复制引用
     */
    private boolean copyReferences = true;

    /**
     * 是否浅克隆
     */
    private boolean copyShallow;

    public Config getConfig() {
        return config;
    }

    public boolean getReferences() {
        return references;
    }

    public void setReferences(boolean references) {
        this.references = references;
    }

    public boolean isCopyReferences() {
        return copyReferences;
    }

    public void setCopyReferences(boolean copyReferences) {
        this.copyReferences = copyReferences;
    }


    public FastClone() {
        init();
    }

    private void init() {
        config = new DefaultConfig();
    }

    public <T> T copy(T t) throws Exception {
        if (t == null) return null;
        if (copyShallow) return t;
        Cloner<T> cloner = getDefaultCloner(t);
        if (cloner != null) {
            return cloner.copy(this, t);
        }
        return null;
    }

    public <T> T copyShallow(T t) throws Exception {
        if (t == null) return null;
        copyShallow = true;
        try {
            Cloner<T> cloner = getDefaultCloner(t);
            if (cloner != null) {
                return cloner.copy(this, t);
            }
            return null;
        } finally {
            copyShallow = false;
        }
    }

    private <T> Cloner<T> getDefaultCloner(T t) {
        if (t instanceof Enum) {
            return config.getDefaultCloner(this, Enum.class);
        }
        if (t instanceof Collection) {
            return config.getDefaultCloner(this, Collection.class);
        }
        return config.getDefaultCloner(this, t.getClass());
    }
}

