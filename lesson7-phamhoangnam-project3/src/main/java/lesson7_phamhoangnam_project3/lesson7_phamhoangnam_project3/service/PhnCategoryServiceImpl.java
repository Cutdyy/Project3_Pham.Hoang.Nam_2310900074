package lesson7_phamhoangnam_project3.lesson7_phamhoangnam_project3.service;

import lesson7_phamhoangnam_project3.lesson7_phamhoangnam_project3.entity.PhnCategory;
import lesson7_phamhoangnam_project3.lesson7_phamhoangnam_project3.repository.PhnCategoryRepository;
import lesson7_phamhoangnam_project3.lesson7_phamhoangnam_project3.service.PhnCategoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PhnCategoryService  Impl implements PhnCategoryService {

    private final PhnCategoryRepository categoryRepository;

    @Override
    public List<PhnCategory> getAllCategories() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<PhnCategory> getCategoryById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public PhnCategory saveCategory(PhnCategory category) {
        return categoryRepository.save(category);
    }

    @Override
    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
