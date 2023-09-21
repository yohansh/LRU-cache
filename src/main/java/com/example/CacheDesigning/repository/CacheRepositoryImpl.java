package com.example.CacheDesigning.repository;


import com.example.CacheDesigning.model.DoubleLinkedList;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CacheRepositoryImpl implements CacheRepository {
    Map<String, DoubleLinkedList> concurrentHashMap;
    DoubleLinkedList head;
    DoubleLinkedList tail;

    static final long cacheSize = 100;

    public CacheRepositoryImpl(long cacheSize){
        this.concurrentHashMap = new ConcurrentHashMap<>();
        this.head = new DoubleLinkedList(null,null);
        this.tail = new DoubleLinkedList(null,null);
        tail.prev = head;
        head.next = tail;
    }

    public void insertKeyValuePair(String key,String value){
        DoubleLinkedList newNode = new DoubleLinkedList(key,value);
        concurrentHashMap.put(key,newNode);
        DoubleLinkedList headNextNode = head.next;
        head.setNext(newNode);
        newNode.setPrev(head);
        newNode.setNext(headNextNode);
        headNextNode.setPrev(newNode);
    }

    public boolean getCacheSize(){
        return cacheSize==concurrentHashMap.size();
    }

    public boolean checkKey(String key){
        return concurrentHashMap.containsKey(key);
    }

    public void updateKeyValuePair(String key, String value){
        DoubleLinkedList curNode = concurrentHashMap.get(key);
        removeNode(curNode);
        insertKeyValuePair(key,value);
    }

    public void removeNode(DoubleLinkedList node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.next = null;
        node.prev = null;
        concurrentHashMap.remove(node.key);
    }

    public String fetchValue(String key){
        String value = concurrentHashMap.get(key).value;
        removeNode(concurrentHashMap.get(key));
        insertKeyValuePair(key,value);
        return value;
    }

    public void evictSize(){
        DoubleLinkedList toBeRemovedNode = tail.prev;
        removeNode(toBeRemovedNode);
    }


}
