package com.hashtable;

import java.util.Objects;

public class HashTable {
    public static void main(String[] args) {

    }
}


class emp{
    public int id;
    public emp next;

    public emp(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "emp{" +
                "id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        emp emp = (emp) o;
        return id == emp.id;
    }

}

class emp_linked{
    public emp head;

    public void add(emp new_emp){
        if(head == null){
            head = new emp(0);
            head.next = null;
        }
        emp e = head;
        while (true){
            if (e.next == null) {
                e.next = new_emp;
                break;
            }
            e = e.next;
        }
    }


    public emp delete(int id){
        if(head == null){
            throw new RuntimeException("链表为空");
        }
        emp r;
        emp e = head;
        while (true){
            if(e.next.id == id){
                r = e.next;
                e.next = e.next.next;
                break;
            }
            e = e.next;
        }
        if(r != null) {
            return r;
        } else {
            throw new RuntimeException("没有找到节点");
        }
    }


    public void show(){
        if(head == null){
            System.out.println("链表为空");
            return;
        }

        emp e = head;
        while (e.next != null) {
            System.out.println(e);
            e = e.next;
        }
    }
}

class HashTableUse{
    public emp_linked[] emp_links;
    public static final int INITIAL_SIZE = 16;
    public int size;

    public HashTableUse() {
        emp_links = new emp_linked[INITIAL_SIZE];
    }

    public void add(emp new_emp){
        int no = hash(new_emp);

        if(emp_links[no] == null){
            emp_linked emp_linked = new emp_linked();
            emp_links[no] = emp_linked;
            emp_linked.head.next = new_emp;
        } else {
            emp e = emp_links[no].head;
            while (true){
                if(e.next == null){
                    e.next = new_emp;
                    break;
                }
                e = e.next;
            }
        }
    }

    public int hash(emp e){
        return e.id % size;
    }


}
