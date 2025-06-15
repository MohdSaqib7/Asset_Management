package com.assetmanagement.services;

import com.assetmanagement.models.Category;
import com.assetmanagement.repository.AllCategoryAssetRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryManagementService {

    @Autowired
    AllCategoryAssetRepo repository;

    public Category addCategory(Category category){
        return repository.save(category);
    }

    public Category updateCategory(Category category){
        Optional<Category> existing = repository.findById(category.getId());
        if (existing.isPresent()) {
            return repository.save(category);
        }
        return null;
    }

    public List<Category> getAllCategory(){
        return repository.findAll();
    }
}
