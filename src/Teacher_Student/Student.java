package Teacher_Student;

import java.util.Scanner;

public class Student extends Person{
    private String studentId;
    private String email;
    private String phoneNumber;
    private float theoryMark;
    private float practiceMark;

    public Student() {
    }

    public Student(String studentId, String email, String phoneNumber, float theoryMark, float practiceMark) {
        this.studentId = studentId;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.theoryMark = theoryMark;
        this.practiceMark = practiceMark;
    }

    public Student(String name, String gender, String birthOfDate, String address, String studentId, String email, String phoneNumber, float theoryMark, float practiceMark) {
        super(name, gender, birthOfDate, address);
        this.studentId = studentId;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.theoryMark = theoryMark;
        this.practiceMark = practiceMark;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public float getTheoryMark() {
        return theoryMark;
    }

    public void setTheoryMark(float theoryMark) {
        this.theoryMark = theoryMark;
    }

    public float getPracticeMark() {
        return practiceMark;
    }

    public void setPracticeMark(float practiceMark) {
        this.practiceMark = practiceMark;
    }

    public void inputStudentInfo() {
        super.inputPersonInfo();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã sinh viên (ví dụ CG12345) : ");
        studentId = sc.nextLine();

        System.out.println("Nhập email : ");
        email = sc.nextLine();

        System.out.println("Nhập số điện thoại : ");
        phoneNumber = sc.nextLine();

        System.out.println("Nhập điểm lý thuyết : ");
        theoryMark = Float.parseFloat(sc.nextLine());

        System.out.println("Nhập điểm thực hành : ");
        practiceMark = Float.parseFloat(sc.nextLine());
    }

    public void showStudentInfo(){
        System.out.println(this.toString());
    }

    public float findGPA(){
        return (theoryMark + (practiceMark * 2)) / 3;
    }

    public boolean inspectScholarship(){
        boolean isPass = false;
        float gpa = findGPA();
        if(gpa>=8.0){
            if(theoryMark>=7&&practiceMark>=7){
                isPass = true;
            }
        }
        return isPass;
    }

    public void passScholarship(){
        boolean isPass;
        if(isPass=inspectScholarship()){
            System.out.println("Đạt học bổng !");
        }
        System.out.println("Tiếc quá, cố tẹo nữa thôi !");
    }

    @Override
    public String toString() {
        return super.toString() + "Mã sinh viên: "+studentId+"\t"+"Email: "+email+"\t"+"Số điện thoại: "+phoneNumber+"\t"+
                "Điểm lý thuyết: "+theoryMark+"\t"+"Điểm thực hành: "+practiceMark+"\t"+"Điểm trung bình: "+findGPA()+"\n";
    }
}
