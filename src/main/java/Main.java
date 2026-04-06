import controller.CourseController;
import controller.StudentController;
import utils.InputValidation;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        StudentController studentController = new StudentController();
        CourseController courseController = new CourseController();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Get Student By ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Create Course");
            System.out.println("7. View Course By ID");
            System.out.println("8. View All Courses");
            System.out.println("9. Add Student In Course");
            System.out.println("10. All Student With Their Enrolled Courses");
            System.out.println("0. Exit");

//            System.out.print("Enter choice: ");
//            int choice = scanner.nextInt();
//            scanner.nextLine();
            int choice = InputValidation.getValidInt("Enter choice: ");


            switch (choice) {

                case 1:
                    studentController.addStudent();
                    break;

                case 2:
                    studentController.getAllStudents();
                    break;

                case 3:
                    studentController.getStudentById();
                    break;

                case 4:
                    studentController.updateStudent();
                    break;

                case 5:
                    studentController.deleteStudent();
                    break;

                case 6:
                    courseController.createCourse();
                    break;

                case 7:
                    courseController.viewCourseById();
                    break;

                case 8:
                    courseController.viewAllCourses();
                    break;

                case 9:
                    studentController.addInCourse();
                    break;
                case 10:
                    studentController.viewEnrolledStudentWithCourses();
                    break;

                case 0:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}