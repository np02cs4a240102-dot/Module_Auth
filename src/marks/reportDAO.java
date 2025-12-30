package marks;

import java.util.*;

import marks.Marks;

public class reportDAO {

    // Simulated data storage
    private Map<Integer, List<Marks>> marksData = new HashMap<>();
    private Map<Integer, Double> attendanceData = new HashMap<>();
    private Map<Integer, String> coursesData = new HashMap<>(); // courseId -> courseName

    // Add marks data (for testing)
    public void addMarks(Marks marks) {
        marksData.computeIfAbsent(marks.getStudentId(), k -> new ArrayList<>()).add(marks);
    }

    // Add course
    public void addCourse(int courseId, String courseName) {
        coursesData.put(courseId, courseName);
    }

    // Add attendance
    public void addAttendance(int studentId, double percentage) {
        attendanceData.put(studentId, percentage);
    }

    // Generate StudentReport
    public StudentReport generateStudentReport(int studentId) {
        List<Marks> marksList = marksData.getOrDefault(studentId, new ArrayList<>());
        List<String> courses = new ArrayList<>();
        List<Double> marks = new ArrayList<>();

        for (Marks m : marksList) {
            courses.add(coursesData.getOrDefault(m.getCourseId(), "Unknown"));
            marks.add(m.getMarks());
        }

        double attendance = attendanceData.getOrDefault(studentId, 0.0);
        return new StudentReport(studentId, courses, marks, attendance);
    }

    // Course-wise attendance report
    public Map<String, Double> generateCourseAttendanceReport(int courseId) {
        Map<String, Double> result = new HashMap<>();
        for (Map.Entry<Integer, Double> entry : attendanceData.entrySet()) {
            result.put("Student " + entry.getKey(), entry.getValue());
        }
        return result;
    }

    // Get list of students below minimum attendance
    public List<Integer> getDefaulterList(double minAttendance) {
        List<Integer> defaulters = new ArrayList<>();
        for (Map.Entry<Integer, Double> entry : attendanceData.entrySet()) {
            if (entry.getValue() < minAttendance) {
                defaulters.add(entry.getKey());
            }
        }
        return defaulters;
    }
}
