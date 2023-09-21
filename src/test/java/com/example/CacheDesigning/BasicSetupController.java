package com.example.CacheDesigning;

import com.example.CacheDesigning.controller.CacheController;
import com.example.CacheDesigning.services.CacheService;
import com.example.CacheDesigning.services.CacheServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class BasicSetupController {

    @Autowired
    protected CacheController cacheController;
    public BasicSetupController(){
        cacheController = new CacheController();

    }

}
