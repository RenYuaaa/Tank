package com.study.tank.ptotoytype.v3;

/**
 * @author: renjiahui
 * @date: 2021-08-06 23:22
 * @description: 享元模式--StringBuilder是否会被克隆
 *
 */
public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {

        Person person1 = new Person();
        Person person2 = (Person) person1.clone();
        System.out.println(person2.age + " " + person2.score);
        System.out.println(person2.location);

        System.out.println(person1.location == person2.location);
        person1.location.setStreet(new StringBuilder("sh"));
        System.out.println(person2.location);

    }
}

class Person implements Cloneable {
    int age = 8;

    int score = 100;

    Location location = new Location(new StringBuilder().append("bj"), 22);


    @Override
    protected Object clone() throws CloneNotSupportedException {
        Person person = (Person) super.clone();
        person.location = (Location) this.location.clone();
        return person;
    }
}

class Location implements Cloneable {

    private StringBuilder street;

    private Integer roomNo;

    public Location(StringBuilder street, Integer roomNo) {
        this.street = street;
        this.roomNo = roomNo;
    }

    public StringBuilder getStreet() {
        return street;
    }

    public void setStreet(StringBuilder street) {
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