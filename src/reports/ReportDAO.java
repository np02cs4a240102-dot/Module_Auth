package reports;
import java.util.*;
public class ReportDAO {
	

	

	

	    // Method 1: Generate report for a single student
	    public studentReport generateStudentReport(int studentId) {
	        // Dummy data for demonstration
	        List<String> courses = Arrays.asList("Math", "Science", "History");
	        List<Double> marks = Arrays.asList(85.0, 90.5, 78.0);
	        double attendance = 92.5;

	        return new studentReport(studentId, courses, marks, attendance);
	    }

	    // Method 2: Generate course attendance report
	    public Map<String, Double> generateCourseAttendanceReport(int courseId) {
	        Map<String, Double> attendanceMap = new HashMap<>();
	        // Dummy data: student names and their attendance in this course
	        attendanceMap.put("Alice", 95.0);
	        attendanceMap.put("Bob", 88.5);
	        attendanceMap.put("Charlie", 70.0);

	        return attendanceMap;
	    }

	    // Method 3: Get defaulter list based on minimum attendance
	    public List<String> getDefaulterList(double minAttendance) {
	        // Dummy student attendance data
	        Map<String, Double> studentAttendance = new HashMap<>();
	        studentAttendance.put("Alice", 95.0);
	        studentAttendance.put("Bob", 88.5);
	        studentAttendance.put("Charlie", 70.0);
	        studentAttendance.put("David", 60.0);

	        List<String> defaulters = new ArrayList<>();
	        for (Map.Entry<String, Double> entry : studentAttendance.entrySet()) {
	            if (entry.getValue() < minAttendance) {
	                defaulters.add(entry.getKey());
	            }
	        }

	        return defaulters;
	    }
	}


