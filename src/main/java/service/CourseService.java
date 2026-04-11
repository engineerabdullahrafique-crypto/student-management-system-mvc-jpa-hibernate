package service;

import dto.CourseDto;
import exceptions.CourseNotFoundException;

import java.util.List;

public interface CourseService {

    void createCourse(CourseDto courseDto);

    CourseDto viewCourseById(int id) throws CourseNotFoundException;

    List<CourseDto> viewAllCourses() throws CourseNotFoundException;

}
