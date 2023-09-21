package com.example.CacheDesigning.repository;

public interface CacheRepository {

    void insertKeyValuePair(String key,String value);
    public boolean getCacheSize();

    public boolean checkKey(String key);

    void updateKeyValuePair(String key,String value);

    String fetchValue(String key);

    public void evictSize();
}
