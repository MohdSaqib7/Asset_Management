package com.assetmanagement.controller;

import com.assetmanagement.models.Category;
import com.assetmanagement.services.CategoryManagementService;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/category")
public class CompanyAssetCategoryManagement {

    private static final Logger log = LogManager.getLogger(CompanyAssetCategoryManagement.class);
    @Autowired
    CategoryManagementService categoryService;

    @PostMapping("/add")
    public String addCategory(@RequestBody Category category){
        log.info("in: {}",category);
        Category out = categoryService.addCategory(category);
        return "Success: "+out.toString();
    }

    @PatchMapping("/update")
    public String updateCategory(@RequestBody Category category){
        log.info("in: {}",category);
        Category out = categoryService.addCategory(category);
        if(out==null) return "Invalid ID";
        return "Success: "+out.toString();
    }

    @GetMapping("/getAll")
    public List<Category> gelAllCategories(){
        return categoryService.getAllCategory();
    }
}
