package dao;

import entity.Course;

import java.util.List;

public interface CourseDao {

    void insert(Course course);

    Course getCourse(int id);

    List<Course> getCourses();
}
