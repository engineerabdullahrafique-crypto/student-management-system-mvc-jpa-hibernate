package service;

import dal.CourseDaoImpl;
import dao.CourseDao;
import dto.CourseDto;
import entity.Course;
import exceptions.CourseNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class CourseServiceImpl implements CourseService {
    private CourseDao courseDao = new CourseDaoImpl();

    @Override
    public void createCourse(CourseDto courseDto) {
        Course course = new Course();
        course.setName(courseDto.getName());
        courseDao.insert(course);
    }

    @Override
    public CourseDto viewCourseById(int id) throws CourseNotFoundException {
        Course course = courseDao.getCourse(id);
        if (course == null) {
            throw new CourseNotFoundException("Course With ID: " + id + " Not Found");
        }
        CourseDto courseDto = new CourseDto();
        courseDto.setId(course.getId());
        courseDto.setName(course.getName());
        return courseDto;
    }

    @Override
    public List<CourseDto> viewAllCourses() throws CourseNotFoundException {
        List<Course> course = courseDao.getCourses();
        if (course == null) {
            throw new CourseNotFoundException("No Courses Found");
        }
        List<CourseDto> courseDtos = new ArrayList<>();
        for (Course c : course) {
            CourseDto courseDto = new CourseDto();
            courseDto.setId(c.getId());
            courseDto.setName(c.getName());
            courseDtos.add(courseDto);
        }
        return courseDtos;
    }
}
