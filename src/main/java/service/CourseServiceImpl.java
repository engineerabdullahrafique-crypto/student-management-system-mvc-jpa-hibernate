package service;

import dal.CourseDaoImpl;
import dao.CourseDao;
import dto.CourseDto;
import entity.Course;

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
    public CourseDto viewCourseById(int id) {
        Course course = courseDao.getCourse(id);
        if (course == null) {
            System.out.println("Course not found");
            return null;
        }
        CourseDto courseDto = new CourseDto();
        courseDto.setId(course.getId());
        courseDto.setName(course.getName());
        return courseDto;
    }

    @Override
    public List<CourseDto> viewAllCourses() {
        List<Course> course = courseDao.getCourses();
        if (course == null) {
            System.out.println("Course not found");
            return new ArrayList<>();
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
