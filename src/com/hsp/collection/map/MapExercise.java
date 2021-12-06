package com.hsp.collection.map;

import java.util.*;

/**
 * @ProjectName: com.hsp.collection.map
 * @author: ZhsngBiBo
 * @description: map 小练习
 * @data: 2021/9/30
 */
public class MapExercise {
    /*
    * 使用hashmap添加三个员工，k-id，v-员工对象
    * 遍历显示工资大于18000的员工
    * */
    public static void main(String[] args) {
        Staff s1 = new Staff(1, "萧炎", 20000);
        Staff s2 = new Staff(2, "萧山", 19000);
        Staff s3 = new Staff(3, "萧战", 10000);
        HashMap<Integer, Staff> map = new HashMap<>();
        map.put(s1.getId(),s1);
        map.put(s2.getId(),s2);
        map.put(s3.getId(),s3);

        double salsrys = 18000;
        for (Integer integer :map.keySet()) {
            if (map.get(integer).getSalary()>salsrys){
                System.out.println(integer+"-"+map.get(integer));
            }
        }

        Set<Map.Entry<Integer, Staff>> entrySet = map.entrySet();
        Iterator<Map.Entry<Integer, Staff>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Staff> next = iterator.next();
            if (next.getValue().getSalary()>salsrys){
                System.out.println(next.getKey()+"--"+next.getValue());
            }
        }

        for (Map.Entry<Integer, Staff> entry : map.entrySet()) {
            System.out.println(entry.getKey()+"---"+entry.getValue());
        }

    }
}
class Staff {
    private int id;
    private String name;
    private double salary;

    public Staff(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Staff staff = (Staff) o;
        return id == staff.id &&
                Double.compare(staff.salary, salary) == 0 &&
                Objects.equals(name, staff.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, salary);
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}