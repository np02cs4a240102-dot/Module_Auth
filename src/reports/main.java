package reports;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		        
		        ReportDAO dao = new ReportDAO();

		        
		        int studentId = 101;
		        studentReport studentReport = dao.generateStudentReport(studentId);
		        System.out.println("===== Student Report =====");
		        System.out.println(studentReport);

		       
		        int courseId = 1;
		        Map<String, Double> courseAttendance = dao.generateCourseAttendanceReport(courseId);
		        System.out.println("\n===== Course Attendance Report =====");
		        for (Map.Entry<String, Double> entry : courseAttendance.entrySet()) {
		            System.out.println("Student: " + entry.getKey() + ", Attendance: " + entry.getValue() + "%");
		        }

		        
		        double minAttendance = 75.0;
		        List<String> defaulters = dao.getDefaulterList(minAttendance);
		        System.out.println("\n===== Defaulter List (Attendance < " + minAttendance + "%) =====");
		        for (String student : defaulters) {
		            System.out.println(student);
		        }
		    }
		


	}


