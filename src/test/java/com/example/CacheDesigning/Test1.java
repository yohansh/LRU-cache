package com.example.CacheDesigning;

import com.example.CacheDesigning.services.CacheService;
import com.example.CacheDesigning.services.CacheServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test1 extends BasicSetupController{

//    @BeforeEach
//    void setUp() {
//        new BasicSetupController();
//    }

    @Autowired
    CacheService cacheService;

    @Test
   public void addText(){
        cacheService = new CacheServiceImpl();

        for(int i=0;i<=10;i++){
            String key = "KEY"+i;
            String value = "VALUE"+i;
            cacheService.addObjectService(key,value);
        }

        assertEquals(cacheService.getObjectService("KEY2"), "VALUE2");
   }

    @Test
    public void updateText(){
        cacheService = new CacheServiceImpl();

        for(int i=0;i<=10;i++){
            String key = "KEY"+i;
            String value = "VALUE"+i;
            cacheService.addObjectService(key,value);
        }

        assertEquals(cacheService.getObjectService("KEY6"), "VALUE6");
    }
}
