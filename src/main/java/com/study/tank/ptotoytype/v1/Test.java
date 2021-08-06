package com.study.tank.ptotoytype.v1;

/**
 * @author: renjiahui
 * @date: 2021-08-06 23:22
 * @description: 原型模式、浅克隆
 *  当person1对象被clone时，是将person中的int类型数据拿过来，并将Location对象地址指向原有的Location对象，并不复制。
 *  所以当person1改变Location对象中属性的值时，person2取出Location中的值也发生改变---浅克隆
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
        return super.clone();
    }
}

class Location {

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
}