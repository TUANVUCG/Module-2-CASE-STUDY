package Teacher_Student;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        TeacherManager teacherManager = new TeacherManager();
        showFirstMenu();
        choice(studentManager, teacherManager);

    }

    private static void showFirstMenu() {
        showBigMenu();
    }

    private static void choice(StudentManager studentManager, TeacherManager teacherManager) {

        String choice = sc.nextLine();
        if(choice.equals("1")){
            workTeacherInfo(teacherManager,studentManager);
        }
        if(choice.equals("2")){
            wokStudentInfo(studentManager,teacherManager);
        }
        if(choice.equals("0")){
            System.out.println("GOODBYE !");
            System.exit(0);
            return;
        }
        if(!choice.equals("1")&&!choice.equals("2")&&!choice.equals("0")){
            System.err.println("Nhập sai !");
            choice(studentManager,teacherManager);
        }
    }

    private static void workTeacherInfo(TeacherManager teacherManager, StudentManager studentManager) {
        String choose;
        do {
            showTeacherMenu();
            choose = sc.nextLine();
            switch (choose) {
                case "1":
                    // Thêm giảng viên
                    teacherManager.readTeacherInfo();
                    teacherManager.addTeacher();// done
                    break;
                case "2":
                    // Hiển thị tất cả thông tin giảng viên
                    teacherManager.showAllTeacherInfo();
                    break;
                case "3":
                    // Sửa thông tin giảng viên theo mã giảng viên
                    System.out.println("Nhập mã giảng viên cần sửa : ");
                    String editId = sc.nextLine();
                    teacherManager.editTeacherByID(editId);
                    break;
                case "4":
                    // Xóa thông tin giảng viên theo mã giảng viên
                    System.out.println("Nhập mã giảng viên cần xóa : ");
                    String removeId = sc.nextLine();
                    teacherManager.removeTeacherByID(removeId);
                    break;
                case "5":
                    // Sắp xếp giảng viên theo lương giảm dần
                    teacherManager.sortTeacherBySalary();
                    System.out.println("Danh sách sau sắp xếp : ");
                    teacherManager.showAllTeacherInfo();
                    break;
                case "6":
                    // Hiển thị giảng viên có lương cao nhất
                    System.out.println("Giảng viên có lương cao nhất : ");
                    teacherManager.showTeacherHighestSalary();
                    break;
                case "7":
                    // Lưu thông tin giảng viên
                    teacherManager.saveTeacherInfo();
                    break;
                case "8":
                    // Đọc thông tin giảng viên
                    teacherManager.readTeacherInfo();
                    teacherManager.showAllTeacherInfo();
                    break;
                case "9":
                    showBigMenu();
                    choice(studentManager,teacherManager );
                    break;
                case "0":
                    System.out.println("GOODBYE !!!");
                    break;
                default:
                    System.err.println("Nhập sai !!!");
                    break;
            }
        }while (!(choose.equals("0")));
    }

    private static void wokStudentInfo(StudentManager studentManager, TeacherManager teacherManager) {
        String choose;
        System.out.println("Nhập lựa chọn của bạn ");
        do {
            showStudentMenu();
            choose = sc.nextLine();
            switch (choose) {
                case "1":
                    studentManager.readAllStudentInfo();
                    studentManager.addStudent();// done
                    break;
                case "2":
                    studentManager.showAllStudent();// done
                    break;
                case "3":
                    // Sửa
                    System.out.println("Nhập mã sinh viên hoặc tên sinh viên cần sửa : "); // done
                    String inputEdit = sc.nextLine();
                    studentManager.editStudentByNameOrId(inputEdit);System.out.println("Danh sách sau khi sửa : ");
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
                    studentManager.sortStudentByName();// done
                    System.out.println("Danh sách sau khi sắp xếp");
                    studentManager.showAllStudent();
                    break;
                case "9":
                    studentManager.showStudentHasScholarshipByGPA();// done
                    break;
                case "10":
                    studentManager.saveAllStudentInfo();
                    System.out.println("Đã lưu !");
                    break;
                case "11":
                    studentManager.readAllStudentInfo();
                    studentManager.showAllStudent();
                    break;
                case "12":
                    studentManager.readStudentHasScholarShip();
                    break;
                case "13":
                    showBigMenu();
                    choice(studentManager,teacherManager );
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

    private static void showTeacherMenu() {
        System.out.println("-------------------------");
        System.out.println("1. Thêm giảng viên mới");
        System.out.println("2. Hiển thị tất cả thông tin giảng viên");
        System.out.println("3. Sửa thông tin giảng viên theo mã giảng viên ");
        System.out.println("4. Xóa thông tin giảng viên theo mã giảng viên ");
        System.out.println("5. Sắp xếp giảng viên theo lương giảm dần");
        System.out.println("6. Hiển thị giảng viên có lương cao nhất");
        System.out.println("7. Lưu thông tin giảng viên");
        System.out.println("8. Đọc thông tin giảng viên");
        System.out.println("9. Quay lại menu chính");
        System.out.println("0. Thoát chương trình");
    }

    private static void showStudentMenu() {
        System.out.println("---------------------");
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
        System.out.println("13. Quay lại menu chính");
        System.out.println("0. Thoát chương trình");

    }

    private static void showBigMenu() {
        System.out.println("Bạn muốn làm việc với đối tượng nào ?");
        System.out.println("1. Giảng viên");
        System.out.println("2. Sinh viên");
        System.out.println("0. Thoát chương trình ");
    }
}
