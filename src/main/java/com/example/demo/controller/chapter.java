package com.example.demo.controller;

import com.example.demo.mappers.Mapper_chapter_table;
import com.example.demo.pojo.chapter_table;
import com.example.demo.pojo.class_table;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("chapter")
public class chapter {

    @Autowired
    private Mapper_chapter_table mapper_chapter_table;

    @PostMapping("/add")
    public String ADD(@RequestBody String body) throws JsonProcessingException {

        ObjectMapper objectMapper=new ObjectMapper();
        chapter_table chapter_table = objectMapper.readValue(body, chapter_table.class);
        String max = mapper_chapter_table.MAX();
        if(max==null)
        {
            chapter_table.setChapter_number("10001");
        }
        else
        {
            String max_substring = max.substring(0, max.length() - 2);
            Integer chapter_number = Integer.valueOf(max_substring);
            chapter_number+=1;
            chapter_table.setChapter_number(String.valueOf(chapter_number));
        }
        mapper_chapter_table.ADD(chapter_table);
        return "success";
    }

    @GetMapping("allchapter")
    public List<chapter_table> allchapter()
    {
        return mapper_chapter_table.SELECTALL();
    }

    @PostMapping("/changeinfo")
    public String changeinfo(@RequestBody String body) throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        chapter_table chapter_table = objectMapper.readValue(body, chapter_table.class);
        mapper_chapter_table.UPDATA(chapter_table.getChapter_number(),chapter_table.getChapter_name());
        return "success";
    }

    @PostMapping("/delete")
    public String delete(@RequestBody String body) throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        chapter_table chapter_table = objectMapper.readValue(body, chapter_table.class);
        mapper_chapter_table.DELETE_BY_chapter_number(chapter_table.getChapter_number());
        return "success";
    }
}
