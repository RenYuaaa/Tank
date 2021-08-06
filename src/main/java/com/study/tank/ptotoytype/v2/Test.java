package com.study.tank.ptotoytype.v2;

/**
 * @author: renjiahui
 * @date: 2021-08-06 23:22
 * @description: 原型模式、深克隆
 * Person实现Cloneable接口，并且Location也实现Cloneable接口，当克隆Person时，也克隆Location对象，就实现了深克隆
 * Location对象中有个String类型的属性，克隆Location对象时，也不会新键String类型的属性，因为String类型有常量池，可以直接在常量池中拿到该属性
 */
public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {

        Person person1 = new Person();
        Person person2 = (Person) person1.clone();
        System.out.println(person2.age + " " + person2.score);
        System.out.println(person2.location);

        System.out.println(person1.location == person2.location);
        person1.location.setStreet("sh");
        System.out.println(person2.location);

    }
}

class Person implements Cloneable {
    int age = 8;

    int score = 100;

    Location location = new Location("bj", 22);


    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person person = (Person) super.clone();

        person.location = (Location) this.location.clone();
        return person;
    }
}

class Location implements Cloneable {

    private String street;

    private Integer roomNo;

    public Location(String street, Integer roomNo) {
        this.street = street;
        this.roomNo = roomNo;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(Integer roomNo) {
        this.roomNo = roomNo;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}