package marks;

public class Main {
    public static void main(String[] args) {

        // Create DAO and service
        MarksDAO marksDAO = new MarksDAO();
        GradeService gradeService = new GradeService(marksDAO);

        // Add some marks
        Marks student1Course1 = new Marks(1, 101, 1, 95); // studentId 101, courseId 1, marks 95
        Marks student2Course1 = new Marks(2, 102, 1, 72); // studentId 102, courseId 1, marks 72
        Marks student3Course2 = new Marks(3, 103, 2, 58); // studentId 103, courseId 2, marks 58

        marksDAO.addMarks(student1Course1);
        marksDAO.addMarks(student2Course1);
        marksDAO.addMarks(student3Course2);

        // Assign grades
        gradeService.assignGrade(student1Course1);
        gradeService.assignGrade(student2Course1);
        gradeService.assignGrade(student3Course2);

        // Print all students' grades
        printMarks(student1Course1);
        printMarks(student2Course1);
        printMarks(student3Course2);

        // Get marks by student
        System.out.println("\nMarks for student 101:");
        for (Marks m : marksDAO.getMarksByStudent(101)) {
            printMarks(m);
        }
    }

    private static void printMarks(Marks marks) {
        System.out.println("Student ID: " + marks.getStudentId() +
                ", Course ID: " + marks.getCourseId() +
                ", Marks: " + marks.getMarks() +
                ", Grade: " + marks.getGrade());
    }
}
