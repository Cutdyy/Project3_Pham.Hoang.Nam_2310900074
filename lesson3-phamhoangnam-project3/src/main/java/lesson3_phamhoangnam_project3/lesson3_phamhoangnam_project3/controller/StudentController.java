package lesson3_phamhoangnam_project3.lesson3_phamhoangnam_project3.controller;

import lesson3_phamhoangnam_project3.lesson3_phamhoangnam_project3.entity.Student;
import lesson3_phamhoangnam_project3.lesson3_phamhoangnam_project3.service.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/students") // Nhóm endpoint lại cho đẹp & RESTful
public class StudentController {

    @Autowired
    private StudentService studentService;

    // Lấy danh sách sinh viên
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getStudents();
    }

    // Lấy sinh viên theo ID
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id) {
        return studentService.getStudent(id);
    }

    // Thêm sinh viên
    @PostMapping
    public Student addStudent(@RequestBody Student student) {
        return studentService.addStudent(student);
    }

    // Cập nhật sinh viên
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    // Xóa sinh viên
    @DeleteMapping("/{id}")
    public boolean deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }
}

