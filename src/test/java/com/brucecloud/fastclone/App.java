package com.brucecloud.fastclone;


import com.brucecloud.fastclone.bean.BiddingWord;
import com.brucecloud.fastclone.bean.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) throws Exception {
        BiddingWord biddingWord = new BiddingWord();
        biddingWord.setWordType(BiddingWord.WordType.getWordType(1));
        biddingWord.setSortType(BiddingWord.SortType.getSortType(1));
        biddingWord.setName("测试");
        biddingWord.setScore(new BigDecimal(100));
        biddingWord.setAaaaa(10);
        User user = new User();
        user.setName("用户1");
        user.setAge(23);
        user.setNum(200);
        biddingWord.setUser(user);
        List<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(new User());
        biddingWord.setUserList(userList);

        int total = 100000;
        System.out.println(total + "条数据");
        FastClone fastClone = new FastClone();
        long startTime = System.currentTimeMillis();
        int i = 0;
        while (i < total) {
            fastClone.clone(biddingWord);
            i++;
        }
        long endTime = System.currentTimeMillis();
//        System.out.println("deepClone耗时: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        i = 0;
        while (i < total) {
            fastClone.clone(biddingWord);
            i++;
        }
        endTime = System.currentTimeMillis();
        System.out.println("deepClone耗时: " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        i = 0;
        while (i < total) {
            fastClone.cloneShallow(biddingWord);
            i++;
        }
        endTime = System.currentTimeMillis();
        System.out.println("shallowClone耗时: " + (endTime - startTime));

        BiddingWord biddingWord1 = fastClone.clone(biddingWord);
        System.out.println(biddingWord1);
    }
}
