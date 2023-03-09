package com.example.demo;



import com.example.demo.mappers.Mapper_chapter_completion;
import com.example.demo.pojo.chapter_completion_2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class DemoApplicationTests {


    @Autowired
    private Mapper_chapter_completion mapper_chapter_completion;
    @Test
    void UUSSEERR_test()
    {
        mapper_chapter_completion.SELECT_END("10001", "30001");

    }

}
