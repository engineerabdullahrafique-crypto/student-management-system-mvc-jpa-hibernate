package utils;

import dto.StudentDto;
import entity.Student;

import java.util.Comparator;

public class StudentSorting implements Comparator<StudentDto> {

    @Override
    public int compare(StudentDto o1, StudentDto o2) {
        int checkAge = Integer.compare(o1.getAge(), o2.getAge());
        if (checkAge == 0) {
            checkAge = o1.getName().compareTo(o2.getName());
        }
        return checkAge;
    }
}
