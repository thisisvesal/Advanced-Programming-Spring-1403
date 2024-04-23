package University;

import java.util.ArrayList;

import User.Student;

// Singleton design
public class University {
    private static University instance;
    public final ArrayList<Course> courses = new ArrayList<Course>();
    public final ArrayList<Student> students = new ArrayList<Student>();
    // 2D arrayList:
    public final ArrayList<ArrayList<Unit>> units = new ArrayList<ArrayList<Unit>>();
    public final String name;

    private University(String name) {
        this.name = name;
    }

    // Pass university name as an argument here
    public static University getInstance(String name) {
        if (instance == null) {
            instance = new University(name);
        }
        return instance;
    }
    // Default name
    public static University getInstance() {
        return getInstance("FUM");
    }

    public void printAllCourses() {
        System.out.println("Full list of courses at " + name + ":");
        int i = 0;
        for (Course course : courses) {
            i++;
            System.out.println(i + ". " + course.name);
        }
    }

    public void addCourse(Course course) {
        if (courses.size() >= 10) {
            System.out.println("Maximum course count reached");
            return;
        }
        courses.add(course);
        units.add(new ArrayList<Unit>());
    }

    public void addUnitToCourse(Course course, Unit unit) {
        course.addUnit(unit);
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).equals(course)) {
                units.get(i).add(unit);
                return;
            }
        }
    }
    public void addUnitToCourse(Course course) {
        Unit unit = new Unit(course);
        course.addUnit(unit);
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).equals(course)) {
                units.get(i).add(unit);
                return;
            }
        }
    }

    public void addStudent(Faculty faculty) {
        students.add(new Student(402, faculty));
    }
    public void addStudent(Faculty faculty, int average) {
        students.add(new Student(402, faculty, average));
    }
    public void addStudent(Student student) {
        students.add(student);
    }

    public Unit getUnitByCode(String code) {
        for (Course course : courses) {
            for (Unit unit : course.units) {
                if (unit.code.compareTo(code) == 0) {
                    return unit;
                }
            }
        }

        System.out.println("Unit not found");
        return null;
    }

    public void printStudentList() {
        System.out.println(name + "'s list of students:");
        for (Student student : students) {
            System.out.println(student.id);
        }
    }
}
