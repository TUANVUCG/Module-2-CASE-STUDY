package Teacher_Student;


import java.io.*;
import java.util.*;

public class StudentManager {
    Scanner sc = new Scanner(System.in);
    List<Student> studentList = new ArrayList<>();

    // Thêm sinh viên
    public void addStudent() {
        Student student = new Student();
        student.inputStudentInfo();
        studentList.add(student);
    }

    // Hiển thị tất cả sinh viên
    public void showAllStudent() {
        for (Student student : studentList) {
            student.showStudentInfo();
        }
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
        studentList.get(studentList.size() - 1).showStudentInfo();
        System.out.println("Sinh viên có điểm trung bình thấp nhất : ");
        studentList.get(0).showStudentInfo();
    }


    // Sắp xếp sinh viên theo thứ tự tên từ A->Z
    public void sortStudentByName() {
        Collections.sort(studentList, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareToIgnoreCase(o2.getName());
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
    public List<Student> read(String fileName, List<Student> studentList) {
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
        System.out.println("Đã lưu !");
    }

    // Đọc thông tin tất cả sinh viên
    public void readAllStudentInfo() {
        read("Student.txt", studentList);
    }

    // Lưu thông tin sinh viên được học bổng
    public void saveStudentHasScholarShip() {
        List<Student> studentHasScholarShip = findStudentHasScholarship();
        save("ScholarShip.txt", studentHasScholarShip);
    }

    // Đọc thông tin sinh viên được học bổng
    public void readStudentHasScholarShip() {
        List<Student> studentHasScholarship = null;
        read("ScholarShip.txt", studentHasScholarship);
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
            studentList.get(index).showStudentInfo();
        }
    }

    // Sửa thông tin theo tên hoặc mã sinh viên
    public void editStudentByNameOrId(String input) {
        int index = findStudent(input);
        if (index != -1) {
            studentList.get(index).inputStudentInfo();
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
