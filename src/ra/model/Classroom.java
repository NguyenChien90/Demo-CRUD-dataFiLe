package ra.model;

import ra.service.classroom.ClassroomServiceIMPL;

import java.io.Serializable;

import static ra.service.classroom.ClassroomServiceIMPL.classroomList;

public class Classroom implements Serializable {
    private int classroomId;
    private String classroomName;
    private boolean status;

    public Classroom() {
        if (classroomList.isEmpty()){
            this.classroomId = 1;
        }else {
            this.classroomId = classroomList.get(classroomList.size() -1).getClassroomId() + 1;
        }
    }

    public Classroom(int classroomId, String classroomName, boolean status) {
        this.classroomId = classroomId;
        this.classroomName = classroomName;
        this.status = status;
    }

    public int getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        //  kiểu định dạng String.format
        return String.format("%5d         %10s      %20s",classroomId,classroomName,(status ? "Đang học":"Kết thúc"));
    }
}
