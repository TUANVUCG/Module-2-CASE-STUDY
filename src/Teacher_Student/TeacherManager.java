package Teacher_Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TeacherManager {
    List<Teacher> teacherList = new ArrayList<>();

    // Thêm giảng viên
    public void addTeacher(){
        Teacher teacher = new Teacher();
        teacher.inputTeacherInfo();
        teacherList.add(teacher);
    }

    // Hiển thị tất cả thông tin giảng viên
    public void showTeacherInfo(){
        for(Teacher teacher : teacherList){
            teacher.showTeacherInfo();
        }
    }

    // Sắp xếp giảng viên theo lương giảm dần
    public void sortTeacherBySalary(){
        Collections.sort(teacherList, new Comparator<Teacher>() {
            @Override
            public int compare(Teacher o1, Teacher o2) {
                if(o1.findSalary()>o2.findSalary()){
                    return 1;
                }
                return -1;
            }
        });
    }

    // Hiển thị giáo viên có lương cao nhất
    public void showTeacherHighestSalary(){
        sortTeacherBySalary();
        teacherList.get(0).showTeacherInfo();
    }
}
