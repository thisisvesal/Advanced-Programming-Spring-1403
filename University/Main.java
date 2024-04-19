// See this project on GitHub:
// https://github.com/thisisvesal/Advanced-Programming-Spring-1403/tree/master/University

import University.Course;
import University.CourseType;
import University.Faculty;
import University.Unit;
import University.University;
import User.Student;
import Utility.Utils;

public class Main {
    public static void main(String[] args) {
        University university = University.getInstance("FUM");

        Course math1 = new Course("Math1", CourseType.CORE, 3);
        Course physics1 = new Course("Physics1", CourseType.CORE, 3);
        Course math2 = new Course("Math2", CourseType.CORE, 3);
        Course fop = new Course("Fundamentals of programming", CourseType.MAJOR, 3);
        Course ap = new Course("Advanced programming", CourseType.MAJOR, 3);
        Course circuits = new Course("Circuits", CourseType.MAJOR, 3);
        Course data = new Course("Data structures", CourseType.MAJOR, 3);
        Course english = new Course("English", CourseType.ELECTIVE, 3);

        Unit math1Unit = new Unit(math1);
        Unit physics1Unit = new Unit(physics1);
        Unit math2Unit = new Unit(math2);
        Unit fopUnit = new Unit(fop);
        Unit apUnit = new Unit(ap);
        Unit circuitUnit = new Unit(circuits);
        Unit dataUnit = new Unit(data);
        Unit engUnit = new Unit(english);

        Student st1 = new Student(402, Faculty.ENGINEERING);
        Student st2 = new Student(402, Faculty.ENGINEERING);
        Student st3 = new Student(402, Faculty.ENGINEERING);
        Student st4 = new Student(402, Faculty.ENGINEERING);
        Student st5 = new Student(402, Faculty.ENGINEERING);
        Student st6 = new Student(402, Faculty.ENGINEERING);
        Student st7 = new Student(402, Faculty.ENGINEERING);
        Student st8 = new Student(402, Faculty.ENGINEERING);

        university.addStudent(st1);
        university.addStudent(st2);
        university.addStudent(st3);
        university.addStudent(st4);
        university.addStudent(st5);
        university.addStudent(st6);
        university.addStudent(st7);
        university.addStudent(st8);

        university.addCourse(ap);
        university.addCourse(fop);
        university.addCourse(math1);
        university.addCourse(math2);
        university.addCourse(physics1);
        university.addCourse(circuits);
        university.addCourse(data);
        university.addCourse(english);

        university.addUnitToCourse(ap, apUnit);
        university.addUnitToCourse(fop, fopUnit);
        university.addUnitToCourse(math1, math1Unit);
        university.addUnitToCourse(math2, math2Unit);
        university.addUnitToCourse(physics1, physics1Unit);
        university.addUnitToCourse(circuits, circuitUnit);
        university.addUnitToCourse(data, dataUnit);
        university.addUnitToCourse(english, engUnit);

        university.printAllCourses();

        st1.enrollIn(apUnit);
        st1.enrollIn(fopUnit);
        st1.enrollIn(math1Unit);
        st1.enrollIn(math2Unit);
        st1.enrollIn(physics1Unit);
        st1.enrollIn(circuitUnit);
        st1.enrollIn(dataUnit);
        st1.enrollIn(engUnit);

        st2.enrollIn(engUnit);
        st3.enrollIn(engUnit);
        st4.enrollIn(engUnit);
        st5.enrollIn(engUnit);
        st6.enrollIn(engUnit);
        st7.enrollIn(engUnit);
        st7.printReservedCourses();


        st1.printEnrolledCourses();

        st1.deleteCourse();

        st1.printEnrolledCourses();

        st1.selectCourse();

        st1.printEnrolledCourses();

        university.printStudentList();

        

        Utils.scanner.close();
    }
}
