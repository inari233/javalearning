package com.map;

import java.util.*;

@SuppressWarnings({"all"})
public class exercise02 {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put(1, new Work("jack", 50000, 1));
        map.put(2, new Work("lucy", 40000, 2));
        map.put(3, new Work("john", 10000, 3));

        Set entryset = map.entrySet();
        Iterator iterator = entryset.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            Map.Entry m = (Map.Entry) next;
            Work work = (Work) m.getValue();
            if (work.getSalary() > 18000) {
                System.out.println(work);
            }

        }

        Collection value = map.values();
        for (Object o : value) {
            Work work = (Work) o;
            if (work.getSalary() > 18000) {
                System.out.println(work);
            }
        }

        Set set = map.keySet();
        for (Object o : set) {
            Work work = (Work)map.get(o);
            if (work.getSalary() > 18000){
                System.out.println(work);
            }
        }
    }
}

class Work {
    private String name;
    private double salary;
    private int work_id;

    public Work(String name, double salary, int work_id) {
        this.name = name;
        this.salary = salary;
        this.work_id = work_id;
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

    public int getWork_id() {
        return work_id;
    }

    public void setWork_id(int work_id) {
        this.work_id = work_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Work work = (Work) o;
        return Double.compare(work.salary, salary) == 0 && work_id == work.work_id && Objects.equals(name, work.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, salary, work_id);
    }

    @Override
    public String toString() {
        return "Work{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", work_id=" + work_id +
                '}';
    }
}
