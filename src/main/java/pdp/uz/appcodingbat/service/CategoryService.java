package pdp.uz.appcodingbat.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import pdp.uz.appcodingbat.entity.Category;
import pdp.uz.appcodingbat.payload.Result;
import pdp.uz.appcodingbat.repository.CategoryRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping
    public List<Category> getCategorys()
    {
        return  categoryRepository.findAll();
    }

    @DeleteMapping(value = "/api/category/{categoryId}")
    public Result deleteCategory(@PathVariable Integer categoryId){
        categoryRepository.deleteById(categoryId);
        return new Result("delete",true);
    }

    @PostMapping
    public Result addCategory(@RequestBody Category category) {
        Category category1 = new Category();
        category1.setCategoryName(category.getCategoryName());
        category1.setDescription(category.getDescription());
        categoryRepository.save(category1);
        return new Result("category", false);
    }

     @PutMapping("/api/category/{categoryId}")
    public Result editCategory(@PathVariable Integer categoryId , @RequestBody Category category) {
         Optional<Category> optionalCategory = categoryRepository.findById(category.getCategoryId());
         if (optionalCategory.isPresent()) {
            Category category1 = optionalCategory.get();
            category1.setCategoryName(category.getCategoryName());
            category1.setDescription(category.getDescription());
            categoryRepository.save(category1);
        }
        return new Result("edit qilindi", true);
    }
}

