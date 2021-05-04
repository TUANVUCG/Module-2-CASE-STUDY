package Teacher_Student;

import java.io.Serializable;
import java.util.Scanner;

public class Person implements Serializable {
    private String name;
    private String gender;
    private String birthOfDate;
    private String address;

    public Person() {
    }

    public Person(String name, String gender, String birthOfDate, String address) {
        this.name = name;
        this.gender = gender;
        this.birthOfDate = birthOfDate;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthOfDate() {
        return birthOfDate;
    }

    public void setBirthOfDate(String birthOfDate) {
        this.birthOfDate = birthOfDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void inputPersonInfo(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập tên : ");
        name = sc.nextLine();

        System.out.print("Nhập giới tính (Nam/nữ) : ");
        gender = sc.nextLine();

        System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
        birthOfDate = sc.nextLine();

        System.out.print("Nhập địa chỉ : ");
        address = sc.nextLine();
    }

    public void showPersonInfo(){
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "Tên: "+name+"\t"+"Giới tính: "+gender+"\t"+"Ngày sinh: "+birthOfDate+"\t"+"Địa chỉ: "+address+"\t";
    }
}
