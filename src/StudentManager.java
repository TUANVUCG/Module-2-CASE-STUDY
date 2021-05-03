import javax.sound.sampled.Line;
import java.io.*;
import java.util.*;

public class StudentManager {

    List<Student> studentList = new ArrayList<>();

    // Thêm một sinh viên
    public void addStudent() {
        Student student = new Student();
        student.inputStudentInfo();
        studentList.add(student);
    }


    //     2. Hiển thị thông tin tất cả sinh viên
    public void showAllStudent() {
        for (Student student : studentList) {
            student.showStudentInfo();
        }
    }

    // Sắp xếp theo mã sinh viên
    public void sortStudentById() {
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getId().compareToIgnoreCase(o2.getId());
            }
        });
        System.out.println("Danh sách sau khi sắp xếp : ");
        showAllStudent();
    }

    // Tìm sinh viên theo mã sinh viên
    public int findStudentById(String id) {
        boolean isFind = false;
        int index = -1;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId().equals(id)) {
                studentList.get(i).showStudentInfo();
                isFind = true;
                index = i;
            }
        }
        if (!isFind) {
            System.err.println("Không tìm thấy mã sinh viên phù hợp !");
        }
        return index;
    }

    // Sửa thông tin theo mã sinh viên
    public void editStudentById(String id) {
        int index = findStudentById(id);
        if (index != -1) {
            studentList.get(index).inputStudentInfo();
            System.out.println("Danh sách sau khi sửa : ");
            showAllStudent();
        }

    }

    // Xóa thông tin theo mã sinh viên
    public void removeStudentById(String id) {
        int index = findStudentById(id);
        if (index != -1) {
            studentList.remove(index);
            System.out.println("Danh sách sinh viên sau khi xóa : ");
            showAllStudent();
        }
    }

    // Sắp xếp theo điểm trung bình giảm dần
    public void sortStudentByGPA() {
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.getGpa() < o2.getGpa()) {
                    return 1;
                }
                return -1;
            }
        });
        System.out.println("Danh sách sau khi sắp xếp : ");
        showAllStudent();
    }

    // Lưu thông tin sinh viên
    public void saveStudentInfo(){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream("Student.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(studentList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(oos!=null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    // Đọc thông tin sinh viên
    public List<Student> readStudentInfo(){
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("Student.txt");
            ois = new ObjectInputStream(fis);
            studentList = (List<Student>) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(ois!=null){
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return studentList;
    }

    // Sắp xếp sinh viên theo tên
    public void sortStudentByName() {
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
        System.out.println("Danh sách sau khi sắp xếp : ");
        showAllStudent();
    }
}
