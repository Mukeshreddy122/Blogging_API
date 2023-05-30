package com.techie.blog.services;

import com.techie.blog.payloads.CategoryDto;

import java.util.List;

public interface CategoryServices {
//    create
    CategoryDto createCategory(CategoryDto categoryDto);
//    update
    CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);
//    delete
    void deleteCategory(Integer categoryId);
//    get
    CategoryDto getCategoryById(Integer categoryId);
//    getall
    List<CategoryDto> getAllCategories();
}
