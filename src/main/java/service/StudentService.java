package service;

import dto.StudentDto;
import entity.Student;

import java.util.List;

public interface StudentService {
    void addStudent(StudentDto StudentDto);

    void updateStudent(int id, StudentDto StudentDto);

    void deleteStudent(int id);

    List<StudentDto> getStudents();

    StudentDto getStudentById(int id);

    void enrollStudentInCourse(int stdId, int courseId);

}
