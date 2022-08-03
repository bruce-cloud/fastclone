package com.brucecloud.fastclone;

import com.brucecloud.fastclone.bean.User;
import org.junit.Test;

public class InnerBeanTest {
    @Test
    public void innerBeanTest() throws Exception {
        User user = new User();
        user.setName("用户1");
        user.setAge(23);
        user.setNum(200);

        FastClone fastClone = new FastClone();

        int total = 1000000;
        System.out.println(total + "数据");

        int i = 0;
        long start = System.currentTimeMillis();
        while (i < total) {
            User clone = fastClone.clone(user);
            i++;
        }
        long end = System.currentTimeMillis();
        System.out.println("clone 耗时: " + (end - start));

        i = 0;
        start = System.currentTimeMillis();
        while (i < total) {
            User clone = fastClone.cloneShallow(user);
            i++;
        }
        end = System.currentTimeMillis();
        System.out.println("cloneShallow 耗时: " + (end - start));
        System.out.println();
    }
}

class InnerBean{
    private String name;
    private int age;
    private Integer num;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
