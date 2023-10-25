package ra.config;
import java.io.*;
import java.util.List;

public class WriteReadFile<T> {
    public static final String PATH_CLASSROOM = "src/ra/config/data/classroom.txt";
    public static final String PATH_STUDENT = "src/ra/config/data/student.txt";
    public static final String PATH_MARK = "src/ra/config/data/mark.txt";
    public static final String PATH_SUBJECT = "src/ra/config/data/subject.txt";

    public void writeFile(String PATH_FILE, List<T> list) {
        File file = new File(PATH_FILE);
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            fos.close();
            oos.close();
        } catch (Exception e) {
            System.out.println("Write Error!!");
        }
    }
    public List<T> readFile(String PATH_FILE){
        File file = new File(PATH_FILE);
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        List<T> list = null;
        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            list = (List<T>) ois.readObject();
            if (fis != null){
                fis.close();
            }
            if (ois != null){
                ois.close();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file!!!");
        } catch (IOException e) {
            System.out.println("File rông!!!");
        } catch (ClassNotFoundException e) {
           e.printStackTrace();
        }
        return list;

    }

}
