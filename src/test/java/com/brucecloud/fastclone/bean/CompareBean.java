package com.brucecloud.fastclone.bean;

/**
 * .
 * created at 2017/3/15 16:58.
 *
 * @author yaoxh.
 */
public class CompareBean implements Comparable<CompareBean> {

    public CompareBean(){

    }

    public CompareBean(String name, int score) {
        this.name = name;
        this.score = score;
    }

    private String name;
    private int score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public int compareTo(CompareBean o) {
        if (score < o.getScore()) return -1;
        if (score > o.getScore()) return 1;
        return 0;
    }
}

