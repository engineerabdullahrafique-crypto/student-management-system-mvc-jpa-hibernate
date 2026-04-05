package controller;

import dto.CourseDto;
import entity.Course;
import service.CourseService;
import service.CourseServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseController {
    private CourseService courseService = new CourseServiceImpl();
    private Scanner scanner = new Scanner(System.in);


    public void createCourse() {
        System.out.println("Enter course name: ");
        String name = scanner.nextLine();
        CourseDto courseDto = new CourseDto();
        courseDto.setName(name);
        courseService.createCourse(courseDto);
        System.out.println("Course created");
    }

    public void viewCourseById() {
        System.out.println("Enter Id: ");
        int id = scanner.nextInt();
        CourseDto courseDto = courseService.viewCourseById(id);
        if (courseDto == null) {
            System.out.println("Course not found");
            return;
        }
        System.out.println("Course id: " + courseDto.getId());
        System.out.println("Course name: " + courseDto.getName());
    }

    public void viewAllCourses() {
        List<CourseDto> courseDto = courseService.viewAllCourses();
        if (courseDto == null) {
            System.out.println("No courses found");
            return;
        }
        for (CourseDto courseDto1 : courseDto) {
            System.out.println("Course id: " + courseDto1.getId());
            System.out.println("Course name: " + courseDto1.getName());
        }
    }
}
