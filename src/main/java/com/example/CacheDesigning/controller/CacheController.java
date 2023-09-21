package com.example.CacheDesigning.controller;

import com.example.CacheDesigning.services.CacheService;
import com.example.CacheDesigning.services.CacheServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;

public class CacheController {

    @Autowired
    CacheService cacheService;

    public CacheController(){
        cacheService = new CacheServiceImpl();
    }
    public void addObject(@NonNull String key,@NonNull String value){
       cacheService.addObjectService(key,value);
    }

    public String getObject(@NonNull String key){
      return cacheService.getObjectService(key);
    }

    public void updateObject(@NonNull String key,@NonNull String value){
         cacheService.updateObjectService(key,value);
    }

}
