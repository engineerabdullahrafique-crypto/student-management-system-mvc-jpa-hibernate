package service;

import dto.StudentDto;
import entity.Student;
import exceptions.CourseNotFoundException;
import exceptions.StudentNotFoundException;

import java.util.List;

public interface StudentService {
    void addStudent(StudentDto StudentDto);

    void updateStudent(int id, StudentDto StudentDto) throws StudentNotFoundException;

    void deleteStudent(int id) throws StudentNotFoundException;

    List<StudentDto> getStudents();

    StudentDto getStudentById(int id) throws StudentNotFoundException;

    void enrollStudentInCourse(int stdId, int courseId) throws StudentNotFoundException, CourseNotFoundException;

}
