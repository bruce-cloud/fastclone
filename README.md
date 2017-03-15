# fastclone<br>
    一款轻量级Java对象高效克隆框架，提供高性能的深克隆(非Object->序列化->Object这种低效率克隆)、浅克隆，支持递归克隆。
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
</pre>
#### 运行结果
<pre>
====深克隆====
克隆前后id属性内存地址是否相同: true
克隆前后User属性内存地址是否相同: false
克隆前后List属性内存地址是否相同: false

====浅克隆====
克隆前后id属性内存地址是否相同: true
克隆前后User属性内存地址是否相同: true
克隆前后List属性内存地址是否相同: true
</pre>
# 支持clone的属性类型
<pre>
 数组类型：char[]、byte[]、short[]、int[]、long[]、float[]、double[]、boolean[]、
          String[]、Object[]以及基本类型的包装类数组等。
 
 集合：Map、List、Set、EnumSet、TreeSet、TreeMap等。
 
 日期：Date、Time、Timestamp、java.sql.Date、Calendar等。
 
 其他：StringBuffer、StringBuilder、BigDecimal、BigInteger、Enum、TimeZone、Locale、
      Charset、URL、Class、Currency、基本类型包装类、自定义对象等。
</pre>
