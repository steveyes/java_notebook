package basic;

import java.util.Arrays;
import java.util.Comparator;

public class SortArray {
    public static void main(String[] args) {
        Person[] arr = {
                new Person("liuyan", 38),
                new Person("dilireba", 18),
                new Person("gulinazha", 19),
        };

        sort01(arr);
        printPerson(arr);
        System.out.println("----------------------------------------");
        sort02(arr);
        printPerson(arr);
    }

    private static void printPerson(Person[] arr) {
        for (Person person : arr) {
            System.out.println(person);
        }
    }

    private static void sort01(Person[] arr) {
        Arrays.sort(arr, new Comparator<Person>() {
            @Override
            public int compare(Person person, Person t1) {
                return person.getAge() - t1.getAge();
            }
        });
    }

    private static void sort02(Person[] arr) {
        Arrays.sort(arr, (Person p1, Person p2) -> {
            return p2.getAge() - p1.getAge();
        });
    }
}


class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

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
}
