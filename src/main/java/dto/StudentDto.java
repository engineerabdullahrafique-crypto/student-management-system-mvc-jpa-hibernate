package dto;

import java.util.List;

public class StudentDto {

    private int id;
    private String name;
    private int age;
    private String gender;
    private List<CourseDto> courseDtoList;

    public StudentDto() {
    }

    public StudentDto(int age, List<CourseDto> courseDtoList, String gender, String name) {
        this.age = age;
        this.courseDtoList = courseDtoList;
        this.gender = gender;
//        this.id = id;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<CourseDto> getCourseDtoList() {
        return courseDtoList;
    }

    public void setCourseDtoList(List<CourseDto> courseDtoList) {
        this.courseDtoList = courseDtoList;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    @Override
    public String toString() {
        return "StudentDto{" +
                "age=" + age +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}