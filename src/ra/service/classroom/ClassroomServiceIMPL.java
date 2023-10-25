package ra.service.classroom;

import ra.config.WriteReadFile;
import ra.model.Classroom;

import java.util.ArrayList;
import java.util.List;

public class ClassroomServiceIMPL implements IClassroomService {
    static WriteReadFile<Classroom> writeReadFile = new WriteReadFile<>();
    public static List<Classroom> classroomList;

    static {
        classroomList = writeReadFile.readFile(WriteReadFile.PATH_CLASSROOM);
        classroomList = (classroomList == null) ? new ArrayList<>() : classroomList;
    }

    @Override
    public List<Classroom> findAll() {
        return classroomList;
    }

    @Override
    public void save(Classroom classroom) {
        classroomList.add(classroom);
        updateData();
    }

    @Override
    public void update(Classroom classroom) {
        Classroom classroomEdit = findByID(classroom.getClassroomId());
        classroomEdit.setClassroomName(classroom.getClassroomName());
        classroomEdit.setStatus(classroom.isStatus());
        updateData();
    }

    @Override
    public void delete(int id) {
        //        classroomList.remove(findById(id)); viết tắt
        Classroom classroomDelete = findByID(id); //viết rõ ràng
        classroomList.remove(classroomDelete);
        updateData();
    }

    @Override
    public Classroom findByID(int id) {
        for (Classroom classroom : classroomList) {
            if (classroom.getClassroomId() == id) {
                return classroom;
            }
        }
        return null;
    }
    @Override
    public void updateData() {
        writeReadFile.writeFile(WriteReadFile.PATH_CLASSROOM, findAll());
    }
}
