import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        StudentManager studentManager = new StudentManager();
        String choose = null;
        do {
            showMenu();
            choose = sc.nextLine();
            switch (choose) {
                case "1":
                    studentManager.addStudent();
                    break;
                case "2":
                    studentManager.showAllStudent();
                    break;
                case "3":
                    studentManager.sortStudentById();
                    break;
                case "4":
                    System.out.println("Nhập mã sinh viên cần tìm : ");
                    String idFind = sc.nextLine();
                    studentManager.findStudentById(idFind);
                    break;
                case "5":
                    System.out.println("Nhập mã sinh viên cần sửa : ");
                    String idEdit = sc.nextLine();
                    studentManager.editStudentById(idEdit);
//                    System.out.println("Danh sách sinh viên sau khi sửa : ");
//                    studentManager.showAllStudent();
                    break;
                case "6":
                    System.out.println("Nhập mã sinh viên cần xóa : ");
                    String idRemove = sc.nextLine();
                    studentManager.removeStudentById(idRemove);
                    break;
                case "7":
                    studentManager.sortStudentByGPA();

                    break;
                case "8":
                    studentManager.sortStudentByName();

                    break;
                case "9":
                    studentManager.saveStudentInfo();
                    System.out.println("Đã lưu !");
                    break;
                case "10":
                    studentManager.readStudentInfo();
                    studentManager.showAllStudent();
                    break;
                case "0":
                    System.out.println("GOODBYE !!!");
                    break;
                default:
                    System.err.println("Nhập sai ròi !!!");
            }
        } while (!choose.equals("0"));
    }

    private static void showMenu() {
        System.out.println("-----------------------");
        System.out.println("1. Thêm sinh viên");
        System.out.println("2. Hiển thị thông tin tất cả sinh viên");
        System.out.println("3. Sắp xếp sinh viên theo mã sinh viên");
        System.out.println("4. Tìm sinh viên theo mã sinh viên");
        System.out.println("5. Sửa thông tin sinh viên theo mã sinh viên");
        System.out.println("6. Xóa sinh viên theo mã sinh viên");
        System.out.println("7. Sắp xếp sinh viên theo điểm trung bình giảm dần");
        System.out.println("8. Sắp xếp sinh viên theo tên");
        System.out.println("9. Lưu thông tin sinh viên");
        System.out.println("10. Đọc thông tin sinh viên");
        System.out.println("0. Thoát chương trình ");
    }
}
