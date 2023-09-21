package com.example.CacheDesigning.services;

import com.example.CacheDesigning.exceptions.KeyNotFoundException;
import com.example.CacheDesigning.repository.CacheRepository;
import com.example.CacheDesigning.repository.CacheRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;

public class CacheServiceImpl implements CacheService {

    @Autowired
    CacheRepository cacheRepository;
    public CacheServiceImpl(){
        cacheRepository = new CacheRepositoryImpl(10);
    }


    public void addObjectService(String key,String value){
        if(cacheRepository.getCacheSize()){
            cacheRepository.evictSize();
        }
        cacheRepository.insertKeyValuePair(key,value);
    }

    public void updateObjectService(String key,String value){
        cacheRepository.updateKeyValuePair(key,value);
    }

    public String getObjectService(String key){
        if(!cacheRepository.checkKey(key)){
            throw new KeyNotFoundException();
        }
        return cacheRepository.fetchValue(key);
    }
}
