package lesson7_phamhoangnam_project3.lesson7_phamhoangnam_project3.controller;

import lesson7_phamhoangnam_project3.lesson7_phamhoangnam_project3.entity.PhnCategory;
import lesson7_phamhoangnam_project3.lesson7_phamhoangnam_project3.service.PhnCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/phncategory")
public class PhnCategoryController {

    @Autowired
    private PhnCategoryService categoryService;

    // ---------------- LIST -----------------
    @GetMapping
    public String listCategories(Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        return "phncategory/phncategory-list";
    }

    // ---------------- CREATE -----------------
    @GetMapping("/create")
    public String createForm(Model model) {
        model.addAttribute("category", new PhnCategory());
        return "phncategory/phncategory-form";
    }

    @PostMapping("/create")
    public String saveCategory(@ModelAttribute("category") PhnCategory category) {
        categoryService.saveCategory(category);
        return "redirect:/phncategory";
    }

    // ---------------- EDIT -----------------
    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        PhnCategory category = categoryService.getCategoryById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid category Id:" + id));
        model.addAttribute("category", category);
        return "phncategory/phncategory-form";
    }

    @PostMapping("/edit/{id}")
    public String updateCategory(@PathVariable Long id, @ModelAttribute("category") PhnCategory category) {
        category.setId(id);
        categoryService.saveCategory(category);
        return "redirect:/phncategory";
    }

    // ---------------- DELETE -----------------
    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {
        categoryService.deleteCategory(id);
        return "redirect:/phncategory";
    }
}
