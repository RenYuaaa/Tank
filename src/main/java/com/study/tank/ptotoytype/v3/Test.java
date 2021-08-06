package com.study.tank.ptotoytype.v3;

/**
 * @author: renjiahui
 * @date: 2021-08-06 23:22
 * @description: 原型模式--StringBuilder是否会被克隆
 * 克隆Person时，也克隆Location对象，这样person1改变location中的String类型的属性，就不会影响person2中location对象的String类型属性--这种属于深克隆
 * 但如果location中有StringBUilder属性，则改变person1中location对象中的StringBuilder属性，则会影响person2中location对象中的StringBuilder属性。
 * 因此，对Person克隆时，在克隆Location对象后，也要克隆Location对象中的StringBuilder属性
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