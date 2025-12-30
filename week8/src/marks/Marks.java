package marks;

public class Marks {
    private int marksId;
    private int studentId;
    private int courseId;
    private double marks;
    private String grade;

    public Marks() {}

    public Marks(int marksId, int studentId, int courseId, double marks) {
        this.marksId = marksId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.marks = marks;
        this.grade = null; // Grade will be assigned later
    }

    // Getters and setters
    public int getMarksId() { return marksId; }
    public void setMarksId(int marksId) { this.marksId = marksId; }

    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }

    public int getCourseId() { return courseId; }
    public void setCourseId(int courseId) { this.courseId = courseId; }

    public double getMarks() { return marks; }
    public void setMarks(double marks) { this.marks = marks; }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
}
