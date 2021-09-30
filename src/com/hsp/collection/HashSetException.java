package com.hsp.collection;

import java.util.HashSet;
import java.util.Objects;

/**
 * @ProjectName: com.hsp.collection
 * @author: ZhsngBiBo
 * @description: hashSet练习题
 * @data: 2021/9/30
 */
public class HashSetException {
    public static void main(String[] args) {
        HashSet<Person> pset = new HashSet<>();
        Person p1 = new Person(1, "AA");
        pset.add(p1);
        Person p2 = new Person(2, "BB");
        pset.add(p2);
        p1.name = "CC";
        //删不掉（1，CC）是因为这里根据hash值生成的索引去删除，而person重写了hash方法
        //现在1，CC在原本1，AA所在的索引值，而remove拿的是1，CC重新生成的hash值去删除，所以删不掉
        pset.remove(p1);
        System.out.println(pset);
        pset.add(new Person(1,"CC"));
        System.out.println(pset);
        //这里添加1,AA可以成功是因为，索引还是一开始的1,AA所在的索引但是
        //重写了equals，原本的AA被改成了CC和现在的AA不相同，会直接挂到1,CC后面
        pset.add(new Person(1,"AA"));
        System.out.println(pset);
    }
}
class Person{
    public  int id;
    public  String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}