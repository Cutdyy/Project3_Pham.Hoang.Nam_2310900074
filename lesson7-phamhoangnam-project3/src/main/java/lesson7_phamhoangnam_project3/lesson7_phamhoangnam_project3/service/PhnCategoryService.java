package lesson7_phamhoangnam_project3.lesson7_phamhoangnam_project3.service;

import lesson7_phamhoangnam_project3.lesson7_phamhoangnam_project3.entity.PhnCategory;

import java.util.List;
import java.util.Optional;

public interface PhnCategoryService {

    // Lấy tất cả danh mục
    List<PhnCategory> getAllCategories();

    // Lấy danh mục theo id
    Optional<PhnCategory> getCategoryById(Long id);

    // Lưu / cập nhật danh mục
    PhnCategory saveCategory(PhnCategory category);

    // Xóa danh mục theo id
    void deleteCategory(Long id);
}
