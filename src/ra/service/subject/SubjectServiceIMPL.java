package ra.service.subject;

import ra.config.WriteReadFile;
import ra.model.Subject;

import java.util.ArrayList;
import java.util.List;

public class SubjectServiceIMPL implements ISubjectService {
    static WriteReadFile<Subject> writeReadFile = new WriteReadFile<>();
    public static List<Subject> subjectList;
    static {
        subjectList = writeReadFile.readFile(WriteReadFile.PATH_SUBJECT);
        subjectList = subjectList == null ? new ArrayList<>() : subjectList;
    }
    @Override
    public List<Subject> findAll() {
        return subjectList;
    }

    @Override
    public void save(Subject subject) {
        subjectList.add(subject);
        updateData();
    }

    @Override
    public void update(Subject subject) {
        Subject subjectEdit = findByID(subject.getSubjectId());
        subjectEdit.setSubjectName(subject.getSubjectName());
        updateData();
    }

    @Override
    public void delete(int id) {
        Subject subjectDelete = findByID(id);
        subjectList.remove(subjectDelete);
        updateData();
    }

    @Override
    public Subject findByID(int id) {
        for (Subject subject : subjectList) {
            if (subject.getSubjectId() == id){
                return subject;
            }
        }
        return null;
    }

    @Override
    public void updateData() {
        writeReadFile.writeFile(WriteReadFile.PATH_SUBJECT,findAll());
    }
}
