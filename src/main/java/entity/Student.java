package entity;

import java.util.List;

public class Student {
    private int id;
    private String name;
    private int age;
    private String gender;
    private List<Course> courseList;

    public Student() {
    }

    public Student(int id, String name, int age, String gender, List<Course> courseList) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.courseList = courseList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", courseList=" + courseList +
                '}';
    }
}
