package service;

import dto.CourseDto;

import java.util.List;

public interface CourseService {

    void createCourse(CourseDto courseDto);

    CourseDto viewCourseById(int id);

    List<CourseDto> viewAllCourses();

}
