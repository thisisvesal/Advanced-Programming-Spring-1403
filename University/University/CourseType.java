package University;
public enum CourseType {
    MAJOR(1),
    ELECTIVE(2),
    LAB(3),
    CORE(4);

    private int code;

    private CourseType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
