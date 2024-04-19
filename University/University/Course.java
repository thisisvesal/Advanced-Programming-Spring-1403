package University;

import java.util.ArrayList;

public class Course {
    public final String name;
    public final CourseType courseType;
    public final int unitCount;
    public final ArrayList<Unit> units = new ArrayList<Unit>();
    public Course(String name, CourseType courseType, int unitCount) {
        this.name = name;
        this.courseType = courseType;
        this.unitCount = unitCount;
    }

    // Differemt from printInfo
    public String getInfo() {
        String info = "";
        info += "Course name: " + name + "\n";
        info += "Course type: " + courseType + "\n";
        info += "Unit count: " + unitCount + "\n";
        for (int i = 0; i < units.size(); i++) {
            info += "Unit " + (i + 1) + ": " + units.get(i).code + "\n";
        }

        return info;
    }

    public void printInfo() {
        System.out.println(this.getInfo());
    }

    public void addUnit(Unit unit) {
        units.add(unit);
    }

    @Override
    public boolean equals(Object course) {
        if (((Course)course).name == this.name) {
            return true;
        }
        return false;
    }
}
