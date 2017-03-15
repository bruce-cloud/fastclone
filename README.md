# fastclone<br>
轻量级Java对象高效克隆框架，提供高效的深克隆(非Object->序列化->Object)、浅克隆。<br>
# Demo
 以下代码存在于项目的com.brucecloud.fastclone.example包下~
#### ExampleBean.java
<pre>
public class ExampleBean {
    private int id;
    private User user;
    private List list;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
</pre>
#### User.java
<pre>
public class User {
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
</pre>
#### Example.java
<pre>
public class Example {
    public static void main(String[] args) throws Exception {
        ExampleBean exampleBean = getBean();
        FastClone fastClone = new FastClone();
        ExampleBean clone = fastClone.clone(exampleBean);
        ExampleBean cloneShallow = fastClone.cloneShallow(exampleBean);

        System.out.println("====深克隆====");
        System.out.println(exampleBean.getId() == clone.getId());
        System.out.println(exampleBean.getUser() == clone.getUser());
        System.out.println(exampleBean.getList() == clone.getList());

        System.out.println();

        System.out.println("====浅克隆====");
        System.out.println(exampleBean.getId() == cloneShallow.getId());
        System.out.println(exampleBean.getUser() == cloneShallow.getUser());
        System.out.println(exampleBean.getList() == cloneShallow.getList());
    }

    private static ExampleBean getBean(){
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
</pre>
