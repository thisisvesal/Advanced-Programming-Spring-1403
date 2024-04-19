package University;
public enum Faculty {
    ENGINEERING(36), 
    MATH(19),
    SCIENCE(32);

    private final int facultyCode;

    private Faculty(int facultyCode) {
        this.facultyCode = facultyCode;
    }

    public int getFacultyCode() {
        return facultyCode;
    }
}