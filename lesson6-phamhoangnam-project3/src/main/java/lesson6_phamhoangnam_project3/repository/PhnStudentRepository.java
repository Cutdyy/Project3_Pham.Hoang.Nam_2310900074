package lesson6_phamhoangnam_project3.repository;

import lesson6_phamhoangnam_project3.entity.PhnStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhnStudentRepository extends JpaRepository<PhnStudent, Long> {
}