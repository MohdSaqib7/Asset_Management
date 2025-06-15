package com.assetmanagement.controller;

import com.assetmanagement.models.Asset;
import com.assetmanagement.services.AssetManagementService;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/asset")
public class CompanyAssetManagement {

    private static final Logger log = LogManager.getLogger(CompanyAssetManagement.class);
    @Autowired
    AssetManagementService assetManagementService;

    @PostMapping("/add")
    public String addAsset(@RequestBody Asset asset){
        log.info("in: {}",asset);
        Asset out = assetManagementService.addAsset(asset);
        return "out:"+out.toString();
    }

    @PatchMapping("/update/{id}")
    public String updateAsset(@PathVariable int id, @RequestBody Asset asset){
        log.info("id:{}, in: {}",id, asset);
        Asset out = assetManagementService.updateAsset(id, asset);
        if(out==null) return "Failed to update";
        return "Success: "+out.toString();
    }

    @GetMapping("/searchAsset/{assetName}")
    public List<Asset> searchAsset(@PathVariable String assetName){
        log.info("in: {}",assetName);
        return assetManagementService.searchAssetsByName(assetName);
    }

    @GetMapping("/getAll")
    public List<Asset> getAllAsset(){
        log.info("in::");
        return assetManagementService.getAllAssets();
    }

    @PatchMapping("/assignAsset")
    public String assignAsset(@RequestParam int assetId, @RequestParam int empId){
        log.info("in:: assetId :{} empId: {}",assetId, empId);
        return assetManagementService.assignAsset(assetId,empId);
    }

    @PatchMapping("/recover/{assetId}")
    public String recoverAsset(@PathVariable int assetId){
        log.info("in: {}",assetId);
        return assetManagementService.recoverAsset(assetId);
    }

    @DeleteMapping("delete/{assetId}")
    public String DeleteAsset(@PathVariable int assetId){
        log.info("in: {}",assetId);
        return assetManagementService.deleteAsset(assetId);
    }
}
