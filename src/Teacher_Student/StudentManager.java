package Teacher_Student;


import java.io.*;
import java.util.*;

public class StudentManager {
    List<Student> studentList = new ArrayList<>();

    // Thêm sinh viên
    public void addStudent() {
        Student student = new Student();
        student.inputStudentInfo(studentList);
        studentList.add(student);
        saveAllStudentInfo();
    }

    // Hiển thị tất cả sinh viên
    public void showAllStudent() {
        printTitle();
        for (Student student : studentList) {
            student.showStudentInfo();
        }
    }

    private void printTitle() {
        System.out.printf("%-25s%-18s%-20s%-17s%-35s%-22s%-25s%-27s%-29s%-25s","Họ tên","Giới tính","Ngày sinh","Quê quán","Mã sinh viên","Email","Số điện thoại","Điểm lý thuyết","Điểm thực hành","Điểm trung bình");
        System.out.println("\n");
    }

    // Sắp xếp sinh viên theo điểm trung bình từ thấp đến cao
    public void sortStudentByGPA(List<Student> studentList) {
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                if (o1.findGPA() > o2.findGPA()) {
                    return 1;
                }
                return -1;
            }
        });
    }

    // Hiển thị sinh viên theo điểm trung bình từ thấp đến cao
    public void showStudentByGpa() {
        sortStudentByGPA(studentList);
        showAllStudent();
    }

    // Hiển thị sinh viên có điểm trung bình cao nhất và thấp nhất
    public void showStudentMinAndMaxGPA() {
        sortStudentByGPA(studentList);
        System.out.println("Sinh viên có điểm trung bình cao nhất : ");
        printTitle();
        studentList.get(studentList.size() - 1).showStudentInfo();
        System.out.println("Sinh viên có điểm trung bình thấp nhất : ");
        printTitle();
        studentList.get(0).showStudentInfo();
    }


    // Sắp xếp sinh viên theo thứ tự tên từ A->Z
    public void sortStudentByName() {
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return -o1.getName().compareToIgnoreCase(o2.getName());
            }
        });
    }

    // Hiển thị sinh viên theo thứ tự tên từ A -> Z
    public void showStudentByName() {
        sortStudentByName();
        showAllStudent();
    }

    // Hiển thị tất cả các sinh viên được học bổng, sắp xếp theo điểm từ cao xuống thấp
    // Tìm các sinh viên có học bổng
    public List<Student> findStudentHasScholarship() {
        List<Student> studentHasScholarshipList = new ArrayList<>();
        for (Student student : studentList) {
            if (student.inspectScholarship()) {
                studentHasScholarshipList.add(student);
            }
        }
        return studentHasScholarshipList;
    }

    // Hiển thị sinh viên có học bổng theo điểm trung bình
    public void showStudentHasScholarshipByGPA() {
        List<Student> studentHasScholarshipList = findStudentHasScholarship();
        sortStudentByGPA(studentHasScholarshipList);
        printTitle();
        for (Student student : studentHasScholarshipList) {
            student.showStudentInfo();
        }
    }

    // Lưu thông tin
    public void save(String fileName, List<Student> studentList) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(fileName);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(studentList);
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

    // Đọc thông tin
    public List<Student> read(String fileName) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(fileName);
            ois = new ObjectInputStream(fis);
            studentList = (List<Student>) ois.readObject();
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
        return studentList;
    }

    // Lưu thông tin tất cả sinh viên
    public void saveAllStudentInfo() {
        save("Student.txt", studentList);
        saveStudentHasScholarShip();
    }

    // Đọc thông tin tất cả sinh viên
    public void readAllStudentInfo() {
        read("Student.txt");
    }

    // Lưu thông tin sinh viên được học bổng
    public void saveStudentHasScholarShip() {
        List<Student> studentHasScholarShip = findStudentHasScholarship();
        save("ScholarShip.txt", studentHasScholarShip);
    }

    // Đọc thông tin sinh viên được học bổng
    public void readStudentHasScholarShip() {
        List<Student> studentHasScholarship = read("ScholarShip.txt");;
        System.out.println("Danh sách sinh viên đạt học bổng");
        for (Student student : studentHasScholarship) {
            student.showStudentInfo();
        }
    }


    // Kiểm tra xem có tìm thấy sinh viên theo tên hoặc mã sinh viên không
    public int findStudent(String input) {
        int index = -1;
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getName().equalsIgnoreCase(input) || studentList.get(i).getStudentId().equalsIgnoreCase(input)) {
                index = i;
            }
        }
        if (index == -1) {
            System.err.println("Không tìm thấy tên sinh viên phù hợp !");
        }
        return index;
    }

    // Hiển thị thông tin sinh viên theo tên hoặc mã sinh viên
    public void showStudentByNameOrId(String input) {
        int index = findStudent(input);
        if (index != -1) {
            printTitle();
            studentList.get(index).showStudentInfo();
        }
    }

    // Sửa thông tin theo tên hoặc mã sinh viên
    public void editStudentByNameOrId(String input) {
        int index = findStudent(input);
        if (index != -1) {
            Student student = new Student();
            student.inputStudentInfo(studentList);
            studentList.set(index, student);
        }
    }

    // Xóa thông tin theo tên hoặc mã sinh viên
    public void removeStudentByNameOrId(String input){
        int index = findStudent(input);
        if (index != -1) {
            studentList.remove(index);
        }
    }
}
