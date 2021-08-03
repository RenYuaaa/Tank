package com.study.tank.builder;

/**
 * @author: renjiahui
 * @date: 2021-08-03 23:42
 * @description:
 */
public class Person {

    private int id;

    private String name;

    private int age;

    private double weight;

    private int score;

    private Location location;

    public Person() {
    }

    public static class PersonBuilder {
        Person person = new Person();

        public PersonBuilder basicInfo(int id, String name, int age) {
            person.id = id;
            person.name = name;
            person.age = age;
            return this;
        }

        public PersonBuilder weight(double weight) {
            person.weight = weight;
            return this;
        }

        public PersonBuilder score(int score) {
            person.score = score;
            return this;
        }

        public PersonBuilder location(String street, String roomNo) {
            person.location = new Location(street, roomNo);
            return this;
        }

        public Person build() {
            return person;
        }
    }
}

class Location {
    private String street;

    private String roomNo;

    public Location(String street, String roomNo) {
        this.street = street;
        this.roomNo = roomNo;
    }
}
