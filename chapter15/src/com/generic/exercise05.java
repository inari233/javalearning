package com.generic;

import java.util.*;

public class exercise05 {
    public static void main(String[] args) {
        DAO<User> userDAO = new DAO<>();
        userDAO.save("11", new User(11, 12, "tom"));
        userDAO.save("12", new User(12, 12, "tom1"));
        userDAO.save("13", new User(13, 12, "tom2"));
        userDAO.save("41", new User(14, 12, "tom3"));
        userDAO.save("15", new User(15, 12, "tom4"));


        System.out.println(userDAO.list());


    }
}

class DAO<T>{
    Map<String, T>map = new HashMap<>();

    public void save(String id, T entity){
        map.put(id,entity);
    }

    public T get(String id){
        return map.get(id);
    }

    public void update(String id, T entity){
        map.put(id, entity);
    }

    public List<T> list(){
        return null;

    }

    public void delete(String id){
        map.remove(id);
    }

}

class User{
    private int id;
    private int age;
    private String name;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && age == user.age && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, age, name);
    }


}
