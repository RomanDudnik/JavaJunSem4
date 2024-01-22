package org.example.models;

import javax.persistence.*;
import java.util.Random;

// анотации для связи с таблицей в базе (маппинг с hibernate):
// resources/hibernate.cfg.xml
@Entity                         // сущность класса Student в базе данных
@Table(name = "students")       // указатель на конкретную таблицу
public class Student {
    @Id                                                     // уникальный идентификатор
    @GeneratedValue(strategy = GenerationType.IDENTITY)     // способ генерации идентификатора (автоинкремент)
    private int id;
    private String name;
    private int age;

    private static final String[] names = new String[] { "Анатолий", "Глеб", "Клим", "Мартин", "Лазарь", "Владлен", "Клим", "Панкратий", "Рубен", "Герман" };
    private static final Random random = new Random();

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Student() {

    }

    public static Student create(){
        return new Student(names[random.nextInt(names.length)], random.nextInt(20, 26));
    }

    public int getId() {
        return id;
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

    public void updateAge(){
        age = random.nextInt(20, 26);
    }

    public void updateName(){
        name = names[random.nextInt(names.length)];
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
