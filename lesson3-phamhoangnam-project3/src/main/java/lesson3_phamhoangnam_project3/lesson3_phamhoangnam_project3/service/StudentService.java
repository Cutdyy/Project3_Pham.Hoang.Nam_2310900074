package lesson3_phamhoangnam_project3.lesson3_phamhoangnam_project3.service;

import lesson3_phamhoangnam_project3.lesson3_phamhoangnam_project3.entity.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class StudentService {

    private List<Student> students = new ArrayList<>();

    public StudentService() {
        students.addAll(Arrays.asList(
                new Student(1L, "Devmaster 1", 20, "Non", "Số 25 VNP", "0978611889", "chungtrinhj@gmail.com"),
                new Student(2L, "Devmaster 2", 25, "Non", "Số 25 VNP", "0978611889", "contact@devmaster.edu.vn"),
                new Student(3L, "Devmaster 3", 22, "Non", "Số 25 VNP", "0978611889", "chungtrinhj@gmail.com")
        ));
    }

    // Lấy toàn bộ danh sách sinh viên
    public List<Student> getStudents() {
        return students;
    }

    // Lấy sinh viên theo id
    public Student getStudent(Long id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    // Thêm mới sinh viên
    public Student addStudent(Student student) {
        students.add(student);
        return student;
    }

    // Cập nhật sinh viên
    public Student updateStudent(Long id, Student student) {
        Student oldStudent = getStudent(id);
        if (oldStudent == null) {
            return null;
        }

        students.forEach(item -> {
            if (item.getId().equals(id)) {
                item.setName(student.getName());
                item.setAge(student.getAge());
                item.setGender(student.getGender());
                item.setAddress(student.getAddress());
                item.setPhone(student.getPhone());
                item.setEmail(student.getEmail());
            }
        });

        return student;
    }

    // Xóa sinh viên
    public boolean deleteStudent(Long id) {
        return students.removeIf(student -> student.getId().equals(id));
    }
}
