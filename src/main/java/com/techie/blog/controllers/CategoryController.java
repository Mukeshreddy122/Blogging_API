package com.techie.blog.controllers;

import com.techie.blog.payloads.ApiResponse;
import com.techie.blog.payloads.CategoryDto;
import com.techie.blog.services.CategoryServices;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
    @Autowired
    private CategoryServices categoryServices;
    @PostMapping("/")
//    create the category
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
        CategoryDto createdCategory=this.categoryServices.createCategory(categoryDto);
        return new ResponseEntity<>(createdCategory, HttpStatus.CREATED);
    }
    @PutMapping("/{categoryId}")
//    update the category
    public ResponseEntity<CategoryDto> updateCategory(@Valid @PathVariable Integer categoryId,@RequestBody CategoryDto categoryDto){
        CategoryDto updatedCategory=this.categoryServices.updateCategory(categoryDto,categoryId);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }
//    delete the category
@DeleteMapping("/{categoryId}")
public ResponseEntity<ApiResponse> deleteUser(@PathVariable("categoryId") Integer categoryId){
    this.categoryServices.deleteCategory(categoryId);
    return  new ResponseEntity<ApiResponse>(new ApiResponse("Category deleted successfully",true),HttpStatus.OK);
}
//    get the category by ID
@GetMapping("/{categoryId}")
public ResponseEntity<CategoryDto> getUserById(@PathVariable("categoryId") Integer categoryId){
    CategoryDto category=this.categoryServices.getCategoryById(categoryId);
    return new ResponseEntity<>(category,HttpStatus.FOUND);
}
//    get all the categories
@GetMapping("/all")
public ResponseEntity<List<CategoryDto>> getAlUsers(){
    List<CategoryDto> categoryDtos=this.categoryServices.getAllCategories();
    return new ResponseEntity<>(categoryDtos,HttpStatus.OK);
}
}
