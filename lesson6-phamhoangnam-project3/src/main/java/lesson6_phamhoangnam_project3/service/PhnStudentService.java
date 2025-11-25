package lesson6_phamhoangnam_project3.service;

import lesson6_phamhoangnam_project3.dto.PhnStudentDTO;
import lesson6_phamhoangnam_project3.entity.PhnStudent;
import lesson6_phamhoangnam_project3.repository.PhnStudentRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class PhnStudentService {

    private PhnStudentRepository phnStudentRepository;

    @Autowired
    public PhnStudentService(PhnStudentRepository phnStudentRepository) {
        this.phnStudentRepository = phnStudentRepository;
    }

    public List<PhnStudent> findAll() {
        return phnStudentRepository.findAll();
    }

    public Optional<PhnStudentDTO> findById(Long id) {
        PhnStudent student = phnStudentRepository.findById(id).orElse(null);
        if (student == null) return Optional.empty();

        PhnStudentDTO dto = new PhnStudentDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());
        dto.setAge(student.getAge());

        return Optional.of(dto);
    }

    public Boolean save(PhnStudentDTO studentDTO) {
        PhnStudent student = new PhnStudent();
        student.setName(studentDTO.getName());
        student.setEmail(studentDTO.getEmail());
        student.setAge(studentDTO.getAge());
        try {
            phnStudentRepository.save(student);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public PhnStudent updateStudentById(Long id, PhnStudentDTO updatedStudent) {
        return phnStudentRepository.findById(id)
                .map(student -> {
                    student.setName(updatedStudent.getName());
                    student.setEmail(updatedStudent.getEmail());
                    student.setAge(updatedStudent.getAge());
                    return phnStudentRepository.save(student);
                })
                .orElseThrow(() -> new IllegalArgumentException("Invalid student ID: " + id));
    }

    public void deleteStudent(Long id) {
        phnStudentRepository.deleteById(id);
    }
}