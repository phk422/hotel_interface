package com.school.hotel;

import com.school.hotel.service.CommonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;

@SpringBootTest
class HotelApplicationTests {

    @Autowired
    private CommonService service;

    @Test
    void contextLoads() {
    }

    @Test
    public void testImgDelete() throws FileNotFoundException {
        String s = service.deleteImgByPath("eb2379b9-03e6-44ca-b742-f1937f57b8c1.jpg");
        System.out.println(s);
    }
}
