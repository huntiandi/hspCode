package com.hsp;

import java.util.Objects;

/**
 * @ProjectName: com.hsp
 * @author: ZhsngBiBo
 * @description: 重写equals
 * @data: 2021/9/17
 */
public class Person {
    private String name ;
    private int age ;
    private char gender ;

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

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;//若地址相同返回TRUE
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;//向下转型因为需要得到object的所有属性
        return age == person.age &&
                gender == person.gender &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, gender);
    }
}
