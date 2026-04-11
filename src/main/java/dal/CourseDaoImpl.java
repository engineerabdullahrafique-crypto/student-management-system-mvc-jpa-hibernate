package dal;

import dao.CourseDao;
import entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import utils.JPAUtil;

import java.util.List;

public class CourseDaoImpl implements CourseDao {
    @Override
    public void insert(Course course) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(course);
        tx.commit();
        em.close();
    }

    @Override
    public Course getCourse(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        Course course = em.find(Course.class, id);
        return course;
    }

    @Override
    public List<Course> getCourses() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Course> courseList = em.createQuery("from Course", Course.class).getResultList();
        return courseList;
    }
}
