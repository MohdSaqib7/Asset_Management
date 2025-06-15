package com.assetmanagement.repository;

import com.assetmanagement.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllCategoryAssetRepo extends JpaRepository<Category, Integer> { }
