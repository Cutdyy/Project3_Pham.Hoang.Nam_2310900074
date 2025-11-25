package lesson6_phamhoangnam_project3.controller;

import lesson6_phamhoangnam_project3.dto.PhnStudentDTO;
import lesson6_phamhoangnam_project3.service.PhnStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/phn-students")
public class PhnStudentController {

    private final PhnStudentService phnStudentService;

    @Autowired
    public PhnStudentController(PhnStudentService phnStudentService) {
        this.phnStudentService = phnStudentService;
    }

    @GetMapping
    public String getStudents(Model model) {
        model.addAttribute("students", phnStudentService.findAll());
        return "phnStudent-list"; // KHÔNG còn /students/
    }

    @GetMapping("/add-new")
    public String addNewStudent(Model model) {
        model.addAttribute("student", new PhnStudentDTO());
        return "phnStudent-add"; // Tên file nằm thẳng trong templates
    }

    @GetMapping("/edit/{id}")
    public String showFormForUpdate(@PathVariable("id") Long id, Model model) {
        PhnStudentDTO student = phnStudentService.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid student ID: " + id));
        model.addAttribute("student", student);
        return "phnStudent-edit"; // KHÔNG có folder
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") PhnStudentDTO student) {
        phnStudentService.save(student);
        return "redirect:/phn-students";
    }

    @PostMapping("/update/{id}")
    public String updateStudent(@PathVariable("id") Long id,
                                @ModelAttribute("student") PhnStudentDTO student) {
        phnStudentService.updateStudentById(id, student);
        return "redirect:/phn-students";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id) {
        phnStudentService.deleteStudent(id);
        return "redirect:/phn-students";
    }
}
