package Teacher_Student;

import java.util.Scanner;

public class Teacher extends Person {
    private String className;
    private double salaryOneHour;
    private double hourOnMonth;


    public Teacher() {
    }

    public Teacher(String className, double salaryOneHour, double hourOnMonth) {
        this.className = className;
        this.salaryOneHour = salaryOneHour;
        this.hourOnMonth = hourOnMonth;
    }

    public Teacher(String name, String gender, String birthOfDate, String address, String className, double salaryOneHour, double hourOnMonth) {
        super(name, gender, birthOfDate, address);
        this.className = className;
        this.salaryOneHour = salaryOneHour;
        this.hourOnMonth = hourOnMonth;
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

    public void inputTeacherInfo() {
        super.inputPersonInfo();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tên lớp dạy : ");
        className = sc.nextLine();

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
        return super.toString() + "Tên lớp dạy: " + className + "\t" + "Lương một giờ dạy: " + salaryOneHour + "\t" + "Số giờ dạy trong tháng: " + hourOnMonth + "\t" + "Lương thực lĩnh: " + findSalary();
    }
}
