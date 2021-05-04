package Teacher_Student;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Teacher extends Person {
    private String className;
    private double salaryOneHour;
    private double hourOnMonth;
    private String teacherId;


    public Teacher() {
    }

    public Teacher(String className, double salaryOneHour, double hourOnMonth) {
        this.className = className;
        this.salaryOneHour = salaryOneHour;
        this.hourOnMonth = hourOnMonth;
    }

    public Teacher(String name, String gender, String birthOfDate, String address, String className, double salaryOneHour, double hourOnMonth,String teacherId) {
        super(name, gender, birthOfDate, address);
        this.className = className;
        this.salaryOneHour = salaryOneHour;
        this.hourOnMonth = hourOnMonth;
        this.teacherId = teacherId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public double getSalaryOneHour() {
        return salaryOneHour;
    }

    public void setSalaryOneHour(double salaryOneHour) {
        this.salaryOneHour = salaryOneHour;
    }

    public double getHourOnMonth() {
        return hourOnMonth;
    }

    public void setHourOnMonth(double hourOnMonth) {
        this.hourOnMonth = hourOnMonth;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public void inputTeacherInfo(List<Teacher> teacherList) {
        super.inputPersonInfo();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã sinh viên (ví dụ TC1234) : ");
        while (true) {
            teacherId = sc.nextLine();
            boolean isFind = false;
            for (Teacher teacher : teacherList) {
                if (teacher.getTeacherId().equals(teacherId)) {
                    isFind = true;
                }
            }
            String regex = "^TC\\d{4}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(teacherId);
            if (matcher.find()) {
                if (!isFind)
                    break;
                else if (isFind) {
                    System.err.println("Mã giảng viên đã tồn tại !");
                    continue;
                }
            }
            System.err.println("Mã giảng viên không đúng");
        }

        System.out.print("Nhập tên lớp dạy ");
        System.out.println("Tên lớp bắt đầu bằng chữ C, tiếp theo là 4 chữ số và kết thúc bằng G,H,I hoặc K");
        while (true) {
            className = sc.nextLine();
            String regex = "^C\\d{4}[GHIK]";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(className);
            if(matcher.find()){
                break;
            }
            else{
                System.err.println("Nhập tên lớp không đúng !");
            }
        }

        System.out.print("Nhập lương một giờ dạy : ");
        salaryOneHour = Double.parseDouble(sc.nextLine());

        System.out.print("Nhập số giờ dạy trong tháng : ");
        hourOnMonth = Double.parseDouble(sc.nextLine());
    }

    public double findSalary() {
        return salaryOneHour * hourOnMonth;
    }

    public void showTeacherInfo() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return super.toString() + "Mã giảng viên : "+teacherId+"\t"+"Tên lớp dạy: " + className + "\t" + "Lương một giờ dạy: " + salaryOneHour + "\t" + "Số giờ dạy trong tháng: " + hourOnMonth + "\t" + "Lương thực lĩnh: " + findSalary();
    }
}
