package com.example.CacheDesigning.model;

public class DoubleLinkedList {
    public String key;
    public String value;
    public DoubleLinkedList next;
    public DoubleLinkedList prev;

    public DoubleLinkedList(String  key,String value){
        this.key = key;
        this.value = value;
        this.next = null;
        this.prev = null;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setNext(DoubleLinkedList next) {
        this.next = next;
    }

    public void setPrev(DoubleLinkedList prev) {
        this.prev = prev;
    }
}
