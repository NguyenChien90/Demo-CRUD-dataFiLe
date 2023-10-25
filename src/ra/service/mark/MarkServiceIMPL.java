package ra.service.mark;

import ra.config.WriteReadFile;
import ra.model.Classroom;
import ra.model.Mark;
import ra.service.student.IStudentService;
import ra.service.student.StudentServiceIMPL;
import ra.service.subject.ISubjectService;
import ra.service.subject.SubjectServiceIMPL;

import java.util.ArrayList;
import java.util.List;

public class MarkServiceIMPL implements IMarkService {
    static WriteReadFile<Mark> writeReadFile = new WriteReadFile<>();
    public static List<Mark> markList ;
    static {
        markList = writeReadFile.readFile(WriteReadFile.PATH_MARK);
        markList = (markList == null) ? new ArrayList<>() : markList;
    }
    @Override
    public List<Mark> findAll() {
        return markList;
    }

    @Override
    public void save(Mark mark) {
        markList.add(mark);
        updateData();
    }

    @Override
    public void update(Mark mark) {
        Mark markEdit = findByID(mark.getMarkId());
        markEdit.setPoin(mark.getPoin());
        updateData();
    }

    @Override
    public void delete(int id) {
        markList.remove(findByID(id));
        updateData();
    }

    @Override
    public Mark findByID(int id) {
        for (Mark mark : markList) {
            if (mark.getMarkId() == id) {
                return mark;
            }
        }
        return null;
    }

    @Override
    public void updateData() {
        writeReadFile.writeFile(WriteReadFile.PATH_MARK,findAll());
    }
}
