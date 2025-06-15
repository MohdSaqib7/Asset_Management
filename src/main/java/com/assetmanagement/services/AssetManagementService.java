package com.assetmanagement.services;


import com.assetmanagement.models.Asset;
import com.assetmanagement.models.AssignmentStatus;
import com.assetmanagement.models.Employee;
import com.assetmanagement.repository.AssetRepository;
import com.assetmanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetManagementService {

    @Autowired
    AssetRepository assetRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    public Asset addAsset(Asset asset){
        asset.setStatus(AssignmentStatus.AVAILABLE);
        return assetRepository.save(asset);
    }

    public List<Asset> getAllAssets() {
        return assetRepository.findAll();
    }

    public List<Asset> searchAssetsByName(String name) {
        List<Asset> out = assetRepository.findByNameContainingIgnoreCase(name);
        if(out.isEmpty()) return null;
        return out;
    }

    public Asset updateAsset(int id, Asset newData) {
        return assetRepository.findById(id).map(asset -> {
            asset.setName(newData.getName());
            asset.setConditionNotes(newData.getConditionNotes());
            asset.setCategory(newData.getCategory());
            asset.setPurchaseDate(newData.getPurchaseDate());
            return assetRepository.save(asset);
        }).orElse(null);
    }

    public String assignAsset(int assetId, int empId) {
        Asset asset = assetRepository.findById(assetId).orElse(null);
        Employee emp = employeeRepository.findById(empId).orElse(null);
        if (asset == null || emp == null || asset.getStatus() == AssignmentStatus.ASSIGNED){
            return "Assignment failed! Try another asset";
        }
        asset.setAssignedTo(emp);
        asset.setStatus(AssignmentStatus.ASSIGNED);
        assetRepository.save(asset);
        return "Asset assigned Successfully to :"+emp.getFullName();
    }

    public String recoverAsset(int assetId) {
        return assetRepository.findById(assetId).map(asset -> {
            asset.setAssignedTo(null);
            asset.setStatus(AssignmentStatus.RECOVERED);
            assetRepository.save(asset);
            return "Asset recovered from: ";
        }).orElse("Asset not found");
    }

    public String deleteAsset(int id) {
        return assetRepository.findById(id).map(asset -> {
            if (asset.getStatus() == AssignmentStatus.ASSIGNED) {
                return "We cannot delete asset - currently assigned it to a employee"+asset.getAssignedTo();
            }
            assetRepository.delete(asset);
            return "Asset deleted";
        }).orElse("Asset not found");
    }
}

