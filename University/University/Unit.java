package University;

import java.util.LinkedList;
import java.util.Queue;

import User.Student;

public class Unit {
    public final Course course;
    public final String code;
    private int capacity;
    private int enrolledCount;
    private Queue<Student> queue = new LinkedList<>();
    private static int count;

    public Unit(Course course, int capacity) {
        count++;
        this.course = course;
        this.code = codeBuilder();
        this.setCapacity(capacity);
    }

    public Unit(Course course) {
        this(course, 5);
    }

    private String codeBuilder() {
        return "" + course.courseType.getCode() + count;
    }

    public void setCapacity(int capacity) {
        if (capacity <= 0) {
            System.out.println("Invalid capacity");
            return;
        }
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getAvailableCapacity() {
        return capacity - enrolledCount;
    }

    public void addToQueue(Student someone) {
        queue.add(someone);
    }

    public void removeFromQueue(Student someone) {
        queue.remove(someone);
    }

    public int getEnrolledCount() {
        return enrolledCount;
    }

    public void addEnrolledCount() {
        enrolledCount++;
    }

    public void enrollFirstQueuedStudent() {
        if (capacity - enrolledCount == 0) {
            System.out.println("The unit is full at the moment");
            return;
        }
        
        if (!queue.isEmpty()) {
            Student front = queue.peek(); // remove is not used here, because the student may not be qualified
            front.enrollIn(this);
        }
    }

    // Different from printInfo
    public String getInfo() {
        String info = "";
        info += "Course: " + course.name + "\n";
        info += "Unit code: " + code + "\n";
        info += "Total capacity: " + capacity + "\n";
        info += "Enrolled count: " + enrolledCount + "\n";
        info += "Available capacity: " + getAvailableCapacity() + "\n";
        info += "In queue: " + queue.size() + "\n";

        return info;
    }

    public void printInfo() {
        System.out.println(this.getInfo());
    }

    @Override
    public boolean equals(Object unit) {
        if (((Unit) unit).code == this.code) {
            return true;
        }
        return false;
    }

}
