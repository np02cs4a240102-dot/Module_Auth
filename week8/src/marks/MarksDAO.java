package marks;

import java.util.ArrayList;
import java.util.List;

public class MarksDAO {

    private List<Marks> marksDB = new ArrayList<>();

    public boolean addMarks(Marks marks) {
        return marksDB.add(marks);
    }

    public boolean updateMarks(Marks marks) {
        for (int i = 0; i < marksDB.size(); i++) {
            Marks m = marksDB.get(i);
            if (m.getStudentId() == marks.getStudentId() && m.getCourseId() == marks.getCourseId()) {
                marksDB.set(i, marks);
                return true;
            }
        }
        return false;
    }

    public Marks getMarks(int studentId, int courseId) {
        for (Marks m : marksDB) {
            if (m.getStudentId() == studentId && m.getCourseId() == courseId) {
                return m;
            }
        }
        return null;
    }

    public List<Marks> getMarksByStudent(int studentId) {
        List<Marks> result = new ArrayList<>();
        for (Marks m : marksDB) {
            if (m.getStudentId() == studentId) {
                result.add(m);
            }
        }
        return result;
    }
}
