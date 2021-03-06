package Teacher_Student;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student extends Person{
    private String studentId;
    private String email;
    private String phoneNumber;
    private double theoryMark;
    private double practiceMark;

    public Student() {
    }

    public Student(String studentId, String email, String phoneNumber, double theoryMark, double practiceMark) {
        this.studentId = studentId;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.theoryMark = theoryMark;
        this.practiceMark = practiceMark;
    }

    public Student(String name, String gender, String birthOfDate, String address, String studentId, String email, String phoneNumber, double theoryMark, double practiceMark) {
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

    public double getTheoryMark() {
        return theoryMark;
    }

    public void setTheoryMark(float theoryMark) {
        this.theoryMark = theoryMark;
    }

    public double getPracticeMark() {
        return practiceMark;
    }

    public void setPracticeMark(float practiceMark) {
        this.practiceMark = practiceMark;
    }

    public void inputStudentInfo(List<Student> studentList) {
        super.inputPersonInfo();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nh????p ma?? sinh vi??n (vi?? du?? CG1234) : ");
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
                else {
                    System.err.println("Ma?? sinh vi??n na??y ??a?? t????n ta??i !");
                    continue;
                }
            }
            System.err.println("Ma?? sinh vi??n kh??ng ??u??ng");
        }

        System.out.print("Nh????p email (vi?? du?? : abc@abc.abc) : ");
        while (true) {
            email = sc.nextLine();
            boolean isFind = false;
            for(Student student : studentList){
                if(student.getEmail().equals(email)){
                    isFind = true;
                }
            }
            String regex = "^[a-zA-Z]+[a-zA-Z0-9]*@[a-z]+(\\.[a-zA-Z0-9]+)$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);
            if(matcher.find()) {
                if(!isFind)
                    break;
                else {
                    System.err.println("Email na??y ??a?? ????????c s???? du??ng, vui lo??ng nh????p email kha??c !!!");
                    continue;
                }
            }
            System.err.println("Email kh??ng ??u??ng !!!");
        }

        System.out.print("Nh????p s???? ??i????n thoa??i ( s???? ??i????n thoa??i g????m 10 ho????c 11 ch???? s???? vi????t li????n ) :  ");
        while(true) {
            phoneNumber = sc.nextLine();
            boolean isFind = false;
            for(Student student : studentList){
                if(student.getPhoneNumber().equals(phoneNumber)){
                    isFind = true;
                }
            }
            String regex = "\\d{10,11}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(phoneNumber);
            if(matcher.find()) {
                if(!isFind)
                    break;
                else {
                    System.err.println("S???? ??i????n thoa??i na??y ??a?? ????????c s???? du??ng, vui lo??ng nh????p s???? ??i????n thoa??i kha??c !");
                    continue;
                }
            }
            System.err.println("S???? ??i????n thoa??i kh??ng ??u??ng !!!");
        }

        System.out.print("Nh????p ??i????m ly?? thuy????t : ");
        while(true) {
            theoryMark = Double.parseDouble(sc.nextLine());
            if(theoryMark>=0&&theoryMark<=10){
                break;
            }
            else{
                System.err.println("??i????m t???? 0 ??????n 10 !");
            }
        }

        System.out.print("Nh????p ??i????m th????c ha??nh : ");
        while (true) {
            practiceMark = Double.parseDouble(sc.nextLine());
            if(practiceMark>=0&&practiceMark<=10){
                break;
            }
            else {
                System.err.println("??i????m t???? 0 ??????n 10 !");
            }
        }
    }


    public void showStudentInfo(){
        System.out.println(this.toString());
    }

    public double findGPA(){
        return (theoryMark + (practiceMark * 2)) / 3;
    }


    @Override
    public String toString() {
        return super.toString() + String.format("%-25s%-30s%-25s%-25.1f%-25.1f%-25.1f",studentId,email,phoneNumber,theoryMark,practiceMark,findGPA());
    }
}
