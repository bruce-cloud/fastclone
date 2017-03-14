package com.brucecloud.fastclone.bean;


import java.math.BigDecimal;
import java.util.List;

import static com.brucecloud.fastclone.bean.BiddingWord.WordType.NORMAL;


/**
 * 竞价词.
 * created at 2016/10/21 17:22.
 *
 * @author yaoxh.
 */
public class BiddingWord {
    public WordType getWordType() {
        return wordType;
    }

    public void setWordType(WordType wordType) {
        this.wordType = wordType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public int getAaaaa() {
        return aaaaa;
    }

    public void setAaaaa(int aaaaa) {
        this.aaaaa = aaaaa;
    }

    public enum WordType {
        CATEGORY(1, "类目词", 1),
        CATEGORY_PROP(2, "类目属性词", 2),
        CONTAINS_CATEGORY(3, "包含类目词", 3),
        NORMAL(0, "普通词", 99);

        private int order;
        private int type;
        private String name;

        WordType(int type, String name, int order) {
            this.name = name;
            this.type = type;
            this.order = order;
        }

        public String getName() {
            return name;
        }

        public int getType() {
            return type;
        }

        public int getOrder() {
            return order;
        }

        public static WordType getWordType(Integer type) {
            if (type == null) {
                return NORMAL;
            }
            switch (type) {
                case 1:
                    return CATEGORY;
                case 2:
                    return CATEGORY_PROP;
                case 3:
                    return CONTAINS_CATEGORY;
                default:
                    return NORMAL;
            }
        }
    }

    public SortType getSortType() {
        return sortType;
    }

    public void setSortType(SortType sortType) {
        this.sortType = sortType;
    }

    public enum SortType {
        HOT_EXCELLENT(3, "热优词", 1),
        HOT(2, "热词", 2),
        EXCELLENT(1, "优词", 3),
        NORMAL(0, "普通词", 99);

        private int order;
        private int type;
        private String name;

        SortType(int type, String name, int order) {
            this.name = name;
            this.type = type;
            this.order = order;
        }

        public String getName() {
            return name;
        }

        public int getType() {
            return type;
        }

        public int getOrder() {
            return order;
        }

        public static SortType getSortType(Integer type) {
            if (type == null) {
                return NORMAL;
            }
            switch (type) {
                case 3:
                    return HOT_EXCELLENT;
                case 2:
                    return HOT;
                case 1:
                    return EXCELLENT;
                default:
                    return NORMAL;
            }
        }
    }

    /**
     * 竞价词名称
     */
    private String name;

    /**
     * 相关性得分
     */
    private BigDecimal score;

    /**
     * 竞价词类型
     */
    private WordType wordType = NORMAL;

    private User user;

    private List<User> userList;

    private int aaaaa;

    private SortType sortType = SortType.NORMAL;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getScore() {
        return score;
    }

    public void setScore(BigDecimal score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BiddingWord that = (BiddingWord) o;

        return name.equals(that.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
