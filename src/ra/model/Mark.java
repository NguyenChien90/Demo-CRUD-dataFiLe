package ra.model;

import java.io.Serializable;
import static ra.service.mark.MarkServiceIMPL.markList;

public class Mark implements Serializable {
    private int markId;
    private Student student;
    private Subject subject;
    private double poin;

    public Mark() {
        if (markList.isEmpty()){
            this.markId = 1;
        }else {
            this.markId = markList.get(markList.size() -1).getMarkId() + 1;
        }
    }

    public Mark(int markId, Student student, Subject subject, double poin) {
        this.markId = markId;
        this.student = student;
        this.subject = subject;
        this.poin = poin;
    }

    public int getMarkId() {
        return markId;
    }

    public void setMarkId(int markId) {
        this.markId = markId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public double getPoin() {
        return poin;
    }

    public void setPoin(double poin) {
        this.poin = poin;
    }

    @Override
    public String toString() {
        return String.format("Mã điểm: %-5d - Tên sinh viên: %-15s - Tên môn học: %-10s - Điểm số: %5.2f",
                markId,student.getStudentName(),subject.getSubjectName(),poin);
    }
}
