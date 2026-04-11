package service;

import dto.CourseDto;
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

    List<StudentDto> getStudentsPaginated(int page, int size);

    StudentDto getStudentById(int id) throws StudentNotFoundException;

    void enrollStudentInCourse(int stdId, int courseId) throws StudentNotFoundException, CourseNotFoundException;

    List<StudentDto> viewForStudentAndCourse() throws StudentNotFoundException, CourseNotFoundException;

}
