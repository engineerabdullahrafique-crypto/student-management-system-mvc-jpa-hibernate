package dto;

import entity.Student;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class CourseDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToMany(mappedBy = "courseDtoList")
    private List<StudentDto> studentDtos;

    public CourseDto() {
    }

    public CourseDto(String name, List<StudentDto> studentDtos) {
//        this.id = id;
        this.name = name;
        this.studentDtos = studentDtos;
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

    public List<StudentDto> getStudentDtos() {
        return studentDtos;
    }

    public void setStudentDtos(List<StudentDto> studentDtos) {
        this.studentDtos = studentDtos;
    }

    @Override
    public String toString() {
        return "CourseDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studentDtos=" + studentDtos +
                '}';
    }
}
