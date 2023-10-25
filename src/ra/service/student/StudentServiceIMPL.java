package ra.service.student;

import ra.config.WriteReadFile;
import ra.model.Student;
import ra.service.classroom.ClassroomServiceIMPL;
import ra.service.classroom.IClassroomService;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceIMPL implements IStudentService{
    static WriteReadFile<Student> writeReadFile = new WriteReadFile<>();
    public static List<Student> studentList ;
    static {
        studentList = writeReadFile.readFile(WriteReadFile.PATH_STUDENT);
        studentList = (studentList == null) ? new ArrayList<>(): studentList;
    }
    @Override
    public List<Student> findAll() {
        return studentList;
    }

    @Override
    public void save(Student student) {
        studentList.add(student);
        updateData();
    }

    @Override
    public void update(Student student) {
        Student studentEdit = findByID(student.getStudentId());
        studentEdit.setStudentName(student.getStudentName());
        studentEdit.setClassroom(student.getClassroom());
        studentEdit.setAddress(student.getAddress());
        studentEdit.setPhone(student.getPhone());
        updateData();
    }

    @Override
    public void delete(int id) {
        Student studentDelete = findByID(id);
        studentList.remove(studentDelete);
        updateData();
    }

    @Override
    public Student findByID(int id) {
        for (Student student : studentList) {
            if (student.getStudentId() == id){
                return student;
            }
        }
        return null;
    }

    @Override
    public void updateData() {
        writeReadFile.writeFile(WriteReadFile.PATH_STUDENT,findAll());
    }

    @Override
    public Student findByName(String name) {
        return null;
    }
}
