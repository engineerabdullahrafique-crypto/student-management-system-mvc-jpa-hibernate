package service;

import dal.CourseDaoImpl;
import dal.StudentDaoImpl;
import dao.CourseDao;
import dao.StudentDao;
import dto.StudentDto;
import entity.Course;
import entity.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao = new StudentDaoImpl();
    private CourseDao courseDao = new CourseDaoImpl();

    @Override
    public void addStudent(StudentDto StudentDto) {
        Student student = new Student();
        student.setName(StudentDto.getName());
        student.setAge(StudentDto.getAge());
        student.setGender(StudentDto.getGender());
        studentDao.insert(student);
    }

    @Override
    public void updateStudent(int id, StudentDto studentDto) {
        Student student = studentDao.getStudent(id);
        if (student == null) {
            return;
        }
        student.setName(studentDto.getName());
        student.setAge(studentDto.getAge());
        student.setGender(studentDto.getGender());
        studentDao.update(id, student);
    }

    @Override
    public void deleteStudent(int id) {
        studentDao.delete(id);
    }

    @Override
    public List<StudentDto> getStudents() {
        List<Student> student = studentDao.getStudents();
        List<StudentDto> studentDtos = new ArrayList<>();
        for (Student s : student) {
            StudentDto studentDto = new StudentDto();
            studentDto.setId(s.getId());
            studentDto.setName(s.getName());
            studentDto.setAge(s.getAge());
            studentDto.setGender(s.getGender());
            studentDtos.add(studentDto);
        }
        return studentDtos;
    }

    @Override
    public StudentDto getStudentById(int id) {
        Student student = studentDao.getStudent(id);
        if (student == null) {
            return null;
        }
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setName(student.getName());
        studentDto.setAge(student.getAge());
        studentDto.setGender(student.getGender());
        return studentDto;
    }

    @Override
    public void enrollStudentInCourse(int stdId, int courseId) {

        studentDao.addStudentInCourse(stdId, courseId);

        System.out.println("Student enrolled successfully!");
    }
}
