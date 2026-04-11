package dto;

import java.util.List;

public class CourseDto {
    private Long id;
    private String name;
    private List<StudentDto> studentDtos;

    public CourseDto() {
    }

    public CourseDto(String name, List<StudentDto> studentDtos) {
//        this.id = id;
        this.name = name;
        this.studentDtos = studentDtos;
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
