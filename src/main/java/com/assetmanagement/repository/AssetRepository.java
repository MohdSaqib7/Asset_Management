package com.assetmanagement.repository;

import com.assetmanagement.models.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Integer> {
    List<Asset> findByNameContainingIgnoreCase(String name);
}
