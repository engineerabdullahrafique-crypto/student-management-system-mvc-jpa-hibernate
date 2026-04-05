package dal;

import dao.StudentDao;
import entity.Course;
import entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import utils.JPAUtil;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public void insert(Student student) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(student);
        tx.commit();
        em.close();
    }

    @Override
    public void update(int id, Student student) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.merge(student);
        tx.commit();
        em.close();
    }

    @Override
    public void delete(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Student student = em.find(Student.class, id);
        em.remove(student);
        tx.commit();
    }

    @Override
    public Student getStudent(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        Student student = em.find(Student.class, id);
        return student;
    }

    @Override
    public List<Student> getStudents() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Student> students = em.createQuery("from Student").getResultList();
        return students;
    }

    @Override
    public void addStudentInCourse(int studentId, int courseId) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        Student student = em.find(Student.class, studentId);
        Course course = em.find(Course.class, courseId);

        if (student == null || course == null) {
            System.out.println("Student or Course not found");
            return;
        }

        // 🔥 Add relationship
        student.getCourseList().add(course);
        course.getStudents().add(student);
        tx.commit();
    }
}
