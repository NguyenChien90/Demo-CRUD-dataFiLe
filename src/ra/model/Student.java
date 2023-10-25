package ra.model;

import java.io.Serializable;

import static ra.service.mark.MarkServiceIMPL.markList;
import static ra.service.student.StudentServiceIMPL.studentList;

public class Student implements Serializable {

    private int studentId;
    private String studentName;
    private Classroom classroom;
    private String birthday;
    private String address;
    private boolean gender;
    private String phone;

    public Student() {
        if (studentList.isEmpty()){
            this.studentId = 1;
        }else {
            this.studentId = studentList.get(studentList.size() -1).getStudentId() + 1;
        }
    }

    public Student(int studentId, String studentName, Classroom classroom, String birthday, String address, boolean gender, String phone) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.classroom = classroom;
        this.birthday = birthday;
        this.address = address;
        this.gender = gender;
        this.phone = phone;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format("Mã sinh viên: %-3s - Tên sinh viên: %-10s - Tên lớp: %-8s - Ngày sinh: %-10s - Địa chỉ: %-5s - Giới tính: %3s - Điện thoại: %s",
                studentId, studentName, classroom.getClassroomName(), birthday, address, gender ? "Nam" : "Nữ", phone);

    }
}
