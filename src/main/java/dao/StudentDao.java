package dao;

import entity.Course;
import entity.Student;

import java.util.List;

public interface StudentDao {
    void insert(Student student);
    void update(int id, Student student);
    void delete(int id);
    Student getStudent(int id);
    List<Student> getStudents();
    void addStudentInCourse(int studentId, int courseId);
}
