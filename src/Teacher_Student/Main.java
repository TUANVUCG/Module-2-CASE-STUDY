package Teacher_Student;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        TeacherManager teacherManager = new TeacherManager();
        String choose = null;
        do {
            showMenu();
            choose = sc.nextLine();
            switch (choose) {
                case "1":
                    studentManager.addStudent();// done
                    break;
                case "2":
                    studentManager.showAllStudent();// done
                    break;
                case "3":
                    // Sửa
                    System.out.println("Nhập mã sinh viên hoặc tên sinh viên cần sửa : "); // done
                    String inputEdit = sc.nextLine();
                    studentManager.editStudentByNameOrId(inputEdit);
                    System.out.println("Danh sách sau khi sửa : ");
                    studentManager.showAllStudent();
                    break;
                case "4":
                    // Xóa
                    System.out.println("Nhập mã sinh viên hoặc tên sinh viên cần xóa : ");
                    String inputRemove = sc.nextLine();
                    studentManager.removeStudentByNameOrId(inputRemove);
                    System.out.println("Danh sách sau khi xóa : ");
                    studentManager.showAllStudent();
                    break;
                case "5":
                    System.out.print("Nhập tên hoặc mã sinh viên cần tìm : ");
                    String nameFind = sc.nextLine();
                    studentManager.showStudentByNameOrId(nameFind);
                    break;
                case "6":
                    studentManager.sortStudentByGPA(studentManager.studentList);// done
                    System.out.println("Danh sách sau khi sắp xếp");
                    studentManager.showAllStudent();
                    break;
                case "7":
                    studentManager.showStudentMinAndMaxGPA();// done
                    break;
                case "8":
                    studentManager.sortStudentByName();
                    System.out.println("Danh sách sau khi sắp xếp");
                    studentManager.showAllStudent();
                    break;
                case "9":
                    studentManager.showStudentHasScholarshipByGPA();
                    break;
                case "10":
                    studentManager.saveAllStudentInfo();
                    break;
                case "11":
                    studentManager.readAllStudentInfo();
                    studentManager.showAllStudent();
                    break;
                case "12":
                    studentManager.readStudentHasScholarShip();
                    break;
                case "0":
                    System.out.println("GOODBYE !!!");
                    break;
                default:
                    System.err.println("Nhập sai !!!");
                    break;
            }
        } while (!(choose.equals("0")));
    }

    private static void showMenu() {
        System.out.println("1. Thêm sinh viên mới");
        System.out.println("2. Hiển thị tất cả sinh viên ");
        System.out.println("3. Sửa thông tin sinh viên theo mã sinh viên hoặc tên");
        System.out.println("4. Xóa sinh viên theo mã sinh viên hoặc tên ");
        System.out.println("5. Tìm kiếm sinh viên theo tên hoặc mã sinh viên");
        System.out.println("6. Sắp xếp sinh viên theo điểm trung bình từ thấp đến cao");
        System.out.println("7. Hiển thị sinh viên có điểm trung bình cao nhất và thấp nhất");
        System.out.println("8. Sắp xếp sinh viên theo thứ tự tên từ A->Z");
        System.out.println("9. Hiển thị các sinh viên có học bổng");
        System.out.println("10. Lưu thông tin sinh viên");
        System.out.println("11. Đọc thông tin tất cả sinh viên");
        System.out.println("12. Đọc thông tin các sinh viên được học bổng");
        System.out.println("0. Thoát chương trình");

    }
}
