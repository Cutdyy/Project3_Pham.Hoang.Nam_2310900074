package lesson7_phamhoangnam_project3.lesson7_phamhoangnam_project3.repository;

import lesson7_phamhoangnam_project3.lesson7_phamhoangnam_project3.entity.PhnCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhnCategoryRepository extends JpaRepository<PhnCategory, Long> {
}
