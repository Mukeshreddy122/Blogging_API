package com.techie.blog.services.Impl;

import com.techie.blog.entities.Category;
import com.techie.blog.exceptions.ResourceNotFoundException;
import com.techie.blog.payloads.CategoryDto;
import com.techie.blog.repositories.CategoryRepo;
import com.techie.blog.services.CategoryServices;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryServices {
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category=this.modelMapper.map(categoryDto, Category.class);
        Category addedcat=this.categoryRepo.save(category);
        return this.modelMapper.map(addedcat,CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
       Category updatedCat=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","Id",categoryId));
       updatedCat.setCategoryTitle(categoryDto.getCategoryTitle());
       updatedCat.setCategoryDescription(categoryDto.getCategoryDescription());
       this.categoryRepo.save(updatedCat);
       return this.modelMapper.map(updatedCat,CategoryDto.class);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category foundCategory=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","categoryId",categoryId));
        this.categoryRepo.delete(foundCategory);
    }

    @Override
    public CategoryDto getCategoryById(Integer categoryId) {
        Category foundCategory=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","categoryId",categoryId));
        return this.modelMapper.map(foundCategory,CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories=this.categoryRepo.findAll();
        List<CategoryDto> categoryDtos=categories.stream().map(category->this.modelMapper.map(category,CategoryDto.class)).collect(Collectors.toList());
        return categoryDtos;
    }
}
