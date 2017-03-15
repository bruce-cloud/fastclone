package com.brucecloud.fastclone.bean;

import java.sql.*;
import java.util.*;
import java.util.Date;

/**
 * .
 * created at 2017/3/15 16:39.
 *
 * @author yaoxh.
 */
public class OtherBean {
    private Date date;
    private Timestamp timestamp;
    private java.sql.Date sqlDate;
    private Time time;
    private EnumSet enumSet;
    private StringBuffer stringBuffer;
    private StringBuilder StringBuilder;
    private TreeSet treeSet;
    private Map map;
    private TreeMap treeMap;
    private Calendar calendar;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public java.sql.Date getSqlDate() {
        return sqlDate;
    }

    public void setSqlDate(java.sql.Date sqlDate) {
        this.sqlDate = sqlDate;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public EnumSet getEnumSet() {
        return enumSet;
    }

    public void setEnumSet(EnumSet enumSet) {
        this.enumSet = enumSet;
    }

    public StringBuffer getStringBuffer() {
        return stringBuffer;
    }

    public void setStringBuffer(StringBuffer stringBuffer) {
        this.stringBuffer = stringBuffer;
    }

    public java.lang.StringBuilder getStringBuilder() {
        return StringBuilder;
    }

    public void setStringBuilder(java.lang.StringBuilder stringBuilder) {
        StringBuilder = stringBuilder;
    }

    public TreeSet getTreeSet() {
        return treeSet;
    }

    public void setTreeSet(TreeSet treeSet) {
        this.treeSet = treeSet;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public TreeMap getTreeMap() {
        return treeMap;
    }

    public void setTreeMap(TreeMap treeMap) {
        this.treeMap = treeMap;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }
}

