package marks;
import java.util.List;
import java.util.Map;
public class main { public static void main(String[] args) {

    // Initialize DAOs and Services
    MarksDAO marksDAO = new MarksDAO();
    reportDAO reportDAO = new reportDAO();
    GradeService gradeService = new GradeService(marksDAO);

    // Add courses
    reportDAO.addCourse(1, "Math");
    reportDAO.addCourse(2, "Science");
    reportDAO.addCourse(3, "History");

    // Add students' attendance
    reportDAO.addAttendance(101, 92.5);
    reportDAO.addAttendance(102, 68.0);
    reportDAO.addAttendance(103, 80.0);

    // Add marks for students
    Marks m1 = new Marks(1, 101, 1, 95);
    Marks m2 = new Marks(2, 101, 2, 88);
    Marks m3 = new Marks(3, 102, 1, 70);
    Marks m4 = new Marks(4, 103, 3, 60);

    marksDAO.addMarks(m1);
    marksDAO.addMarks(m2);
    marksDAO.addMarks(m3);
    marksDAO.addMarks(m4);

    // Assign grades
    gradeService.assignGrade(m1);
    gradeService.assignGrade(m2);
    gradeService.assignGrade(m3);
    gradeService.assignGrade(m4);

    // Add marks to reportDAO (for generating StudentReport)
    reportDAO.addMarks(m1);
    reportDAO.addMarks(m2);
    reportDAO.addMarks(m3);
    reportDAO.addMarks(m4);

    // Generate student reports
    System.out.println("===== Student Reports =====");
    for (int studentId : new int[]{101, 102, 103}) {
        StudentReport sr = reportDAO.generateStudentReport(studentId);
        System.out.println("Student ID: " + sr.getStudentId());
        List<String> courses = sr.getCourses();
        List<Double> marks = sr.getMarks();
        for (int i = 0; i < courses.size(); i++) {
            System.out.println("Course: " + courses.get(i) + ", Marks: " + marks.get(i));
        }
        System.out.println("Attendance: " + sr.getAttendancePercentage() + "%");
        System.out.println("-----------------------------");
    }

    // Get defaulter list (attendance < 75%)
    List<Integer> defaulters = reportDAO.getDefaulterList(75.0);
    System.out.println("===== Defaulter List =====");
    for (int id : defaulters) {
        System.out.println("Student ID: " + id);
    }

    // Generate course attendance report for Math
    System.out.println("===== Course Attendance Report (Math) =====");
    Map<String, Double> courseAttendance = reportDAO.generateCourseAttendanceReport(1);
    for (Map.Entry<String, Double> entry : courseAttendance.entrySet()) {
        System.out.println(entry.getKey() + " -> " + entry.getValue() + "%");
    }
}
}


