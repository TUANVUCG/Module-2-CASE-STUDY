import java.io.Serializable;
import java.util.Scanner;

public class Student implements Serializable {
    private String id;
    private String name;
    private int age;
    private String address;
    private double gpa;

    public Student() {
    }

    public Student(String id, String name, int age, String address, double gpa) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.gpa = gpa;


    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public void inputStudentInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập mã sinh viên : ");
        id = sc.nextLine();

        System.out.println("Nhập tên sinh viên : ");
        name = sc.nextLine();

        System.out.println("Nhập tuổi : ");
        age = Integer.parseInt(sc.nextLine());

        System.out.println("Nhập địa chỉ : ");
        address = sc.nextLine();

        System.out.println("Nhập điểm trung bình : ");
        gpa = Double.parseDouble(sc.nextLine());
    }

    public void showStudentInfo() {
        System.out.println(toString());
    }

    // Neu diem gpa < 4 - toach
    // 4<gpa<5,5 - loai D
    // 5,5<gpa<7 - Loai C
    // 7<gpa<8,5 - Loai B
    // < 8.5 - Loai A
    // Phân loại sinh viên
    public String classifyStudent() {
        String classifyStudent = null;
        if (gpa < 4) {
            classifyStudent = "Toạch !!!";
        } else if (gpa >= 4 && gpa < 5.5) {
            classifyStudent = "Loại D";
        } else if (gpa >= 5.5 && gpa < 7) {
            classifyStudent = "Loại C";
        } else if (gpa >= 7 && gpa < 8.5) {
            classifyStudent = "Loại B";
        } else if (gpa > 8.5) {
            classifyStudent = "Loại A";
        }
        return classifyStudent;
    }

    @Override
    public String toString() {
        return "Mã sinh viên : " + id + "\t" +
                "Tên : " + name + "\t" +
                "Tuổi : " + age + "\t" +
                "Địa chỉ : " + address + "\t" +
                "Điểm trung bình : " + gpa +"\t"+"Xếp loại : "+classifyStudent();
    }
}
