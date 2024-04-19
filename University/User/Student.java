package User;

import University.Course;
import University.Faculty;
import University.Unit;
import University.University;
import Utility.Utils;

public class Student {
    public final long id;
    public final int yearOfEntrance;
    public final Faculty faculty;
    private Unit[] units;
    private Unit[] reservedUnits = new Unit[3];
    private int reservedCount;
    private Course[] courses;
    private int courseCount;
    private double average;
    private static int count;

    public Student(int yearOfEntrance, int facultyCode, int average) {
        count++;
        this.yearOfEntrance = yearOfEntrance;
        this.average = average;
        this.courses = new Course[getCourseLimit()];
        this.units = new Unit[getCourseLimit()];

        faculty = switch (facultyCode) {
            case 36 -> Faculty.ENGINEERING;
            case 19 -> Faculty.MATH;
            case 32 -> Faculty.SCIENCE;
            default -> null;
        };

        this.id = idBuilder();
    }
    public Student(int yearOfEntrance, Faculty faculty, int average) {
        this(yearOfEntrance, faculty.getFacultyCode(), average);
    }
    public Student(int yearOfEntrance, int facultyCode) {
        this(yearOfEntrance, facultyCode, -1);
    }
    public Student(int yearOfEntrance, Faculty faculty) {
        this(yearOfEntrance, faculty.getFacultyCode(), -1);
    }

    private int getCourseLimit() {
        if (0 <= average && average < 12) {
            return 3;
        } else if (12 <= average && average < 17) {
            return 5;
        }
        return 7;
    }

    public void selectCourse() {
        University.getInstance().printAllCourses();
        System.out.println("You can select " + (courses.length - courseCount) + " more courses from above");
        System.out.println(id + ", enter the number of the course you'd like to select: ");
        int courseNo = Utils.scanner.nextInt();
        University.getInstance().courses.get(courseNo - 1).printInfo();
        System.out.println(id + ", enter the number of the unit you'd like to select: ");
        int unitNo = Utils.scanner.nextInt();
        this.enrollIn(University.getInstance().courses.get(courseNo - 1).units.get(unitNo - 1));
    }

    public void deleteCourse() {
        System.out.println(id + ", enter the code of the unit you want to leave");
        String code = Utils.scanner.next();
        leave(University.getInstance().getUnitByCode(code));
    }

    private long idBuilder() {
        String strId = "" + yearOfEntrance + faculty.getFacultyCode() + String.format("%05d", Student.count);
        return Long.parseLong(strId);
    }

    public static int getCount() {
        return count;
    }

    public void goInReservationList(Unit unit) {
        unit.addToQueue(this);
    }

    public void getOutOfReservationList(Unit unit) {
        unit.removeFromQueue(this);
    }

    public void reserve(Unit unit) {
        if (reservedCount >= 3) {
            System.out.println(id + " can't reserve any more than 3 units");
            return;
        }
        for (int i = 0; i < courseCount; i++) {
            if (unit.course.equals(units[i].course)) {
                System.out.println(id + " is already enrolled in this course!");
                return;
            }
        }

        reservedUnits[reservedCount] = unit;
        this.reservedCount++;
        goInReservationList(unit);
        System.out.println("Successfully reserved");
    }

    public void unreserve(Unit unit) {
        int i = 0;
        for (i = 0; i < reservedCount; i++) {
            if (reservedUnits[i].equals(unit)) {
                break;
            }
        }
        for (; i < reservedCount - 1; i++) {
            reservedUnits[i] = reservedUnits[i + 1];
        }
        reservedUnits[i] = null;
        reservedCount--;
        getOutOfReservationList(unit);
    }

    public void enrollIn(Unit unit) {
        if (getCourseLimit() - courseCount == 0) {
            System.out.println("You cannot enroll in more courses");
            return;
        } else if (unit.getAvailableCapacity() <= 0) {
            System.out.println(id + ", this unit's capacity is full");
            System.out.println("Would you like to go in the reservation list?(y/n)");
            String response = Utils.scanner.next();
            if (response.compareTo("y") == 0) {
                reserve(unit);
            }
            return;
        }
        for (int i = 0; i < courseCount; i++) {
            if (unit.course.equals(units[i].course)) {
                System.out.println(id + " is already enrolled in this course!");
                return;
            }
        }
        unit.addEnrolledCount();
        courses[courseCount] = unit.course;
        units[courseCount] = unit;
        courseCount++;
        System.out.println(id + " was successfully addded to the course");
    }

    public void leave(Unit unit) {
        int i = 0;
        for (i = 0; i < courseCount; i++) {
            if (units[i].equals(unit)) {
                break;
            }
        }
        if (i == courseCount) {
            System.out.println(id + " doesn't have this unit");
            return;
        }
        for (; i < courseCount - 1; i++) {
            units[i] = units[i + 1]; 
        }
        units[i] = null;
        courseCount--;
        System.out.println(id + " has successfuly left the course");

        // Adding the first person in reservation queue to course:
        unit.enrollFirstQueuedStudent();
    }

    public int getReservedCount() {
        return reservedCount;
    }

    public void printEnrolledCourses() {
        System.out.println("Your courses:");
        for (int i = 0; i < courseCount; i++) {
            System.out.println(units[i].course.name + " " + units[i].code);
        }
    }

    public void printReservedCourses() {
        System.out.println(id + "'s reserved courses:");
        for (int i = 0; i < reservedCount; i++) {
            System.out.println(reservedUnits[i].course.name + reservedUnits[i].code);
        }
    }

    public void printInfo() {
        System.out.println("Student info:");
        System.out.println("ID: " + id);
        System.out.println("Year of entrance: " + yearOfEntrance);
        System.out.println("Faculty code: " + faculty.getFacultyCode());
        printEnrolledCourses();
        printReservedCourses();
    }

}
