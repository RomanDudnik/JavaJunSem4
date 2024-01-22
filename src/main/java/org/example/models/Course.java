package org.example.models;

import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int duration;

    private static final String[] titles = new String[] { "Лямбды и Stream API", "Reflection API", "Сериализация", "БД и инструменты взаимодействия с ними", "Клиент-серверное программирование", "Многопоточность", "ООП", "Аннотации", "Паттерны проектирования", "Шаблоны проектирования", "Регулярные выражения" };

    private static final Random random = new Random();

    public Course(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public Course(int id, String title, int duration) {
        this.id = id;
        this.title = title;
        this.duration = duration;
    }

    public Course() {

    }

    public static Course create() {
        return new Course(titles[random.nextInt(titles.length)], random.nextInt(60, 120));
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void updateDuration() {
        duration = random.nextInt(60, 120);
    }

    public void updateTitle() {
        title = titles[random.nextInt(titles.length)];
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}
