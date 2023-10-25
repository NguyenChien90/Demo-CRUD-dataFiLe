package ra.model;
import java.io.Serializable;
import static ra.service.subject.SubjectServiceIMPL.subjectList;

public class Subject implements Serializable {
    private int subjectId;
    private String subjectName;

    public Subject() {
        if (subjectList.isEmpty()){
            this.subjectId = 1;
        }else {
            this.subjectId = subjectList.get(subjectList.size() -1).getSubjectId() + 1;
        }
    }

    public Subject(int subjectId, String subjectName) {
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public String toString() {
        return String.format("Mã môn học: %-5s - Tên môn học: %-10s", subjectId, subjectName);

    }
}
