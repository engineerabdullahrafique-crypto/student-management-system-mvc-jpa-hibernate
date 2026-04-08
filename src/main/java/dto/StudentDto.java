package dto;

import enums.Gender;

import java.util.List;

public class StudentDto {

    private Long id;
    private String name;
    private Integer age;
    //    private String gender;
    private Gender gender;
    private List<CourseDto> courseDtoList;

    public StudentDto() {
    }

    public StudentDto(Integer age, List<CourseDto> courseDtoList, Gender gender, String name) {
        this.age = age;
        this.courseDtoList = courseDtoList;
        this.gender = gender;
//        this.id = id;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<CourseDto> getCourseDtoList() {
        return courseDtoList;
    }

    public void setCourseDtoList(List<CourseDto> courseDtoList) {
        this.courseDtoList = courseDtoList;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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