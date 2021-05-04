package Teacher_Student;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public void inputStudentInfo(List<Student> studentList) {
        super.inputPersonInfo();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã sinh viên (ví dụ CG1234) : ");
        while (true){
            studentId = sc.nextLine();
            boolean isFind = false;
            for(Student student : studentList){
                if(student.getStudentId().equals(studentId)){
                    isFind = true;
                }
            }
            String regex = "^CG\\d{4}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(studentId);
            if(matcher.find()) {
                if(!isFind)
                break;
                else if(isFind){
                    System.err.println("Mã sinh viên đã tồn tại !");
                    continue;
                }
            }
            System.err.println("Mã sinh viên không đúng");
        }

        System.out.print("Nhập email (ví dụ : abc@abc.abc) : ");
        while (true) {
            email = sc.nextLine();
            // abc@abc.abc
            String regex = "^[a-zA-Z]+[a-zA-Z0-9]*@[a-z]+(\\.[a-zA-Z0-9]+)$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);
            if(matcher.find()){
                break;
            }
            else {
                System.err.println("Email không đúng !!!");
            }
        }

        System.out.print("Nhập số điện thoại ( số điện thoại gồm 10 hoặc 11 chữ số viết liền ) :  ");
        while(true) {
            phoneNumber = sc.nextLine();
            String regex = "\\d{10,11}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(phoneNumber);
            if(matcher.find()){
                break;
            }
            else{
                System.err.println("Số điện thoại không đúng !!!");
            }
        }

        System.out.print("Nhập điểm lý thuyết : ");
        while(true) {
            theoryMark = Float.parseFloat(sc.nextLine());
            if(theoryMark>=0&&theoryMark<=10){
                break;
            }
            else{
                System.err.println("Điểm từ 0 đến 10 !");
            }
        }

        System.out.print("Nhập điểm thực hành : ");
        while (true) {
            practiceMark = Float.parseFloat(sc.nextLine());
            if(practiceMark>=0&&practiceMark<=10){
                break;
            }
            else {
                System.err.println("Điểm từ 0 đến 10 !");
            }
        }
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
