package com.brucecloud.fastclone.example;

import com.brucecloud.fastclone.FastClone;

import java.util.ArrayList;
import java.util.List;

/**
 * .
 * created at 2017/3/15 17:27.
 *
 * @author yaoxh.
 */
public class Example {
    public static void main(String[] args) throws Exception {
        ExampleBean exampleBean = getBean();
        FastClone fastClone = new FastClone();
        ExampleBean clone = fastClone.clone(exampleBean);
        ExampleBean cloneShallow = fastClone.cloneShallow(exampleBean);

        System.out.println("====深克隆====");
        System.out.println("克隆前后id属性内存地址是否相同: " + (exampleBean.getId() == clone.getId()));
        System.out.println("克隆前后User属性内存地址是否相同: " + (exampleBean.getUser() == clone.getUser()));
        System.out.println("克隆前后List属性内存地址是否相同: " + (exampleBean.getList() == clone.getList()));

        System.out.println();

        System.out.println("====浅克隆====");
        System.out.println("克隆前后id属性内存地址是否相同: " + (exampleBean.getId() == cloneShallow.getId()));
        System.out.println("克隆前后User属性内存地址是否相同: " + (exampleBean.getUser() == cloneShallow.getUser()));
        System.out.println("克隆前后List属性内存地址是否相同: " + (exampleBean.getList() == cloneShallow.getList()));
    }

    private static ExampleBean getBean() {
        User user = new User();
        user.setName("admin");
        user.setAge(23);

        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("World");

        ExampleBean exampleBean = new ExampleBean();
        exampleBean.setId(1);
        exampleBean.setUser(user);
        exampleBean.setList(list);

        return exampleBean;
    }
}

