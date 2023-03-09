package com.example.demo.controller;

import com.example.demo.mappers.Mapper_chapter_completion;
import com.example.demo.pojo.chapter_completion;
import com.example.demo.pojo.chapter_completion_2;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("completion")
public class chaptercompletion {

    @Autowired
    private Mapper_chapter_completion mapper_chapter_completion;

    @GetMapping("/all")
    public List<chapter_completion> showall() {
        return mapper_chapter_completion.SELECTALL();
    }

    @PostMapping("/two")
    public List<chapter_completion_2> show_by_two(HttpServletRequest request) throws IOException {
        String s = request.getReader().readLine();
        ObjectMapper objectMapper=new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(s);
        String chapter_number = jsonNode.get("chapter_number").asText();
        String class_number = jsonNode.get("class_number").asText();
        return mapper_chapter_completion.SELECT_END(chapter_number,class_number);
    }

}
