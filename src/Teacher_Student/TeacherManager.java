package Teacher_Student;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TeacherManager {
    List<Teacher> teacherList = new ArrayList<>();

    // Thêm giảng viên
    public void addTeacher() {
        Teacher teacher = new Teacher();
        teacher.inputTeacherInfo(teacherList);
        teacherList.add(teacher);
        saveTeacherInfo();
    }

    // Hiển thị tất cả thông tin giảng viên
    public void showAllTeacherInfo() {
        printTitle();
        for (Teacher teacher : teacherList) {
            teacher.showTeacherInfo();
        }
    }

    public void printTitle() {
        System.out.printf("%-25s%-18s%-20s%-17s%-22s%-24s%-25s%-19s%-19s","Họ tên","Giới tính","Ngày sinh","Quê quán",
                "Mã giảng viên","Tên lớp dạy","Lương/giờ","Số giờ dạy","Thực lĩnh");
        System.out.println("\n");
    }

    // Sắp xếp giảng viên theo lương giảm dần
    public void sortTeacherBySalary() {
        Collections.sort(teacherList, new Comparator<Teacher>() {
            @Override
            public int compare(Teacher o1, Teacher o2) {
                if (o1.findSalary() < o2.findSalary()) {
                    return 1;
                }
                return -1;
            }
        });
    }

    // Hiển thị giáo viên có lương cao nhất
    public void showTeacherHighestSalary() {
        sortTeacherBySalary();
        teacherList.get(0).showTeacherInfo();
    }


    // Tìm giảng viên theo ID
    public int findTeacherByIdOrName(String input) {
        int index = -1;
        for (int i = 0; i < teacherList.size(); i++) {
            if (teacherList.get(i).getTeacherId().equalsIgnoreCase(input)||teacherList.get(i).getName().equalsIgnoreCase(input)) {
                index = i;
            }
        }
        if (index == -1) {
            System.err.println("Không tìm thấy giảng viên phù hợp !");
        }
        return index;
    }

    // Hiển thị giảng viên theo ID
    public void showTeacherByIdOrName(String id) {
        int index = findTeacherByIdOrName(id);
        if (index != -1) {
            printTitle();
            teacherList.get(index).showTeacherInfo();
        }
    }

    // Sửa thông tin giảng viên theo ID
    public void editTeacherByIdOrName(String input) {
        int index = findTeacherByIdOrName(input);
        if (index != -1) {
            Teacher teacher = new Teacher();
            teacher.inputTeacherInfo(teacherList);
            teacherList.set(index,teacher);
            System.out.println("Danh sách sau khi sửa : ");
            showAllTeacherInfo();
        }
    }

    // Xóa thông tin giảng viên theo ID
    public void removeTeacherByIdOrName(String input) {
        int index = findTeacherByIdOrName(input);
        if (index != -1) {
            teacherList.remove(index);
            System.out.println("Danh sách sau khi xóa : ");
            showAllTeacherInfo();
        }
    }

    // Lưu thông tin giảng viên
    public void saveTeacherInfo() {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream("Teacher.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(teacherList);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    // Đọc thông tin giảng viên
    public void readTeacherInfo() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream("Teacher.txt");
            ois = new ObjectInputStream(fis);
            teacherList = (List<Teacher>) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
