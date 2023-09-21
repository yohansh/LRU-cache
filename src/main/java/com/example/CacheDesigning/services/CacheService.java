package com.example.CacheDesigning.services;

public interface CacheService {

    public void addObjectService(String key,String value);

    public void updateObjectService(String key,String value);

    public String getObjectService(String key);
}
