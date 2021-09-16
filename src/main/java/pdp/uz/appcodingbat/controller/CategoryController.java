package pdp.uz.appcodingbat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pdp.uz.appcodingbat.entity.Category;
import pdp.uz.appcodingbat.payload.Result;
import pdp.uz.appcodingbat.service.CategoryService;

import java.util.List;

@RestController
@RequestMapping("/api/ctegory")
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @GetMapping
    public List<Category> getCategorys() {
        List<Category> categoryList = categoryService.getCategorys();
        return categoryList;
    }

    //Delete
    @DeleteMapping(value = "/api/category/{categoryId}")
    public Result deleteCategory(@PathVariable Integer categoryId) {
        Result result = categoryService.deleteCategory(categoryId);
        return result;
    }

    @PostMapping
    public Result addCategory(@RequestBody Category category){
        Result result = categoryService.addCategory(category);
        return result;
    }

    //Update
    @PutMapping (value = "/api/category/{categoryId}")
    public Result editCategory(@PathVariable Integer categoryId, @RequestBody Category category) {
        Result result = categoryService.editCategory(categoryId,category);
        return result;
    }

}
