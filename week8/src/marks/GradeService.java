package marks;

public class GradeService {

    private MarksDAO marksDAO;

    public GradeService(MarksDAO marksDAO) {
        this.marksDAO = marksDAO;
    }

    // Calculate grade based on marks
    public String calculateGrade(double marks) {
        if (marks >= 90) return "A+";
        else if (marks >= 80) return "A";
        else if (marks >= 70) return "B+";
        else if (marks >= 60) return "B";
        else if (marks >= 50) return "C";
        else return "F";
    }

    // Assign grade to a Marks object
    public boolean assignGrade(Marks marks) {
        if (marks != null) {
            marks.setGrade(calculateGrade(marks.getMarks()));
            return marksDAO.updateMarks(marks);
        }
        return false;
    }
}
