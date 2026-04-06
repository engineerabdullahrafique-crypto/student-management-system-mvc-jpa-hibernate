package controller;

import dto.CourseDto;
import dto.StudentDto;
import exceptions.CourseNotFoundException;
import exceptions.StudentNotFoundException;
import service.CourseService;
import service.CourseServiceImpl;
import service.StudentService;
import service.StudentServiceImpl;
import utils.InputValidation;

import java.util.List;
import java.util.Scanner;

public class StudentController {
    private StudentService studentService = new StudentServiceImpl();
    private CourseService courseService = new CourseServiceImpl();
    private Scanner scanner = new Scanner(System.in);

    public void addStudent() {
        System.out.println("Enter student name: ");
        String name = scanner.nextLine();
        /*System.out.println("Enter student age: ");
        scanner.nextLine();*/
        int age = InputValidation.getValidInt("Enter student age: ");
        System.out.println("Enter student gender: ");
        String gender = scanner.nextLine();
        StudentDto studentDto = new StudentDto();
        studentDto.setName(name);
        studentDto.setAge(age);
        studentDto.setGender(gender);
        studentService.addStudent(studentDto);
        System.out.println("Student added");
    }

    public void updateStudent() {
        /*System.out.println("Enter student id which you want to update: ");
        scanner.nextLine();*/
        int id = InputValidation.getValidInt("Enter student id which you want to update: ");
        StudentDto studentDto = null;
        try {
            studentDto = studentService.getStudentById(id);
        } catch (StudentNotFoundException e) {
            throw new RuntimeException(e);
        }
        if (studentDto == null) {
            System.out.println("Student not found");
            return;
        }
        System.out.println("Current name: " + studentDto.getName());
        System.out.println("Enter student name: ");
        String name = scanner.nextLine();
        System.out.println("Current age: " + studentDto.getAge());
        System.out.println("Enter student age: ");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Current gender: " + studentDto.getGender());
        System.out.println("Enter student gender: ");
        String gender = scanner.nextLine();
        studentDto.setName(name);
        studentDto.setAge(age);
        studentDto.setGender(gender);
        try {
            studentService.updateStudent(id, studentDto);
        } catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Student updated");
    }

    public void deleteStudent() {
        /*System.out.println("Enter student id which you want to delete: ");
        int id = scanner.nextInt();*/
        int id = InputValidation.getValidInt("Enter student id which you want to delete: ");
        scanner.nextLine();
        StudentDto studentDto = null;
        try {
            studentDto = studentService.getStudentById(id);
        } catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Student Info: " + studentDto.getName() + " " + studentDto.getAge() + " " + studentDto.getGender());
        System.out.println("Are you sure you want to delete? (yes/no): ");
        String confirm = scanner.nextLine();

        if (!confirm.equalsIgnoreCase("yes")) {
            System.out.println("Delete cancelled");
            return;
        }
        try {
            studentService.deleteStudent(id);
        } catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Student deleted");
    }

    public void getAllStudents() {

        System.out.println("All Students:");

        List<StudentDto> students = studentService.getStudents();

        if (students == null || students.isEmpty()) {
            System.out.println("No students found");
            return;
        }

        for (StudentDto s : students) {
            System.out.println("----------------------");
            System.out.println("Name: " + s.getName());
            System.out.println("Age: " + s.getAge());
            System.out.println("Gender: " + s.getGender());
        }
    }

    public void getStudentById() {
        /*System.out.println("Enter student id which you want to view: ");
        int id = scanner.nextInt();*/
        int id = InputValidation.getValidInt("Enter student id which you want to view: ");
        scanner.nextLine();
        StudentDto studentDto = null;
        try {
            studentDto = studentService.getStudentById(id);
        } catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
        }
        if (studentDto == null) {
            System.out.println("Student not found");
            return;
        }
        System.out.println("Student Info: " + studentDto.getName() + " " + studentDto.getAge());
    }

    public void addInCourse() {
//        System.out.println("Enter student id which you want to add in course: ");
//        int id = scanner.nextInt();
        int id = InputValidation.getValidInt("Enter student id which you want to add in course: ");
        StudentDto student = null;
        try {
            student = studentService.getStudentById(id);
        } catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Student Name: " + student.getName());
        List<CourseDto> courseDto = null;
        try {
            courseDto = courseService.viewAllCourses();
        } catch (CourseNotFoundException e) {
            System.out.println(e.getMessage());
        }
        for (CourseDto courseDto1 : courseDto) {
            if (courseDto1 == null) {
                System.out.println("Course not found");
            }
            System.out.println("Course Id: " + courseDto1.getId());
            System.out.println("Course Name: " + courseDto1.getName());
        }
        /*System.out.println("Enter Course Id in which you want to add in course: ");
        int courseId = scanner.nextInt();
        scanner.nextLine();*/
        int courseId = InputValidation.getValidInt("Enter Course Id in which you want to add in course: ");
        try {
            studentService.enrollStudentInCourse(id, courseId);
        } catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (CourseNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
