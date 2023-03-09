package com.example.demo.controller;

import com.example.demo.mappers.Mapper_class_table;
import com.example.demo.pojo.class_table;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author ZJH111
 * * @date 2023/3/5
 */
@RestController
@RequestMapping("classmanage")
public class classmanage {

    @Autowired
    private Mapper_class_table mapper_class_table;

    @PostMapping("/add")
    public String ADDclass(@RequestBody String body,HttpServletRequest request) throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        class_table class_table = objectMapper.readValue(body, class_table.class);
        String teacher_number = (String) request.getSession().getAttribute("teacher_number");
        class_table.setTeacher_number(teacher_number);
        mapper_class_table.ADD(class_table);
        return "success";
    }

    @GetMapping("/myclass")
    public List<class_table> MYclaa(HttpServletRequest request)
    {
        String teacher_number = (String) request.getSession().getAttribute("teacher_number");
        return mapper_class_table.SELECTALL_BY_teacher_number(teacher_number);
    }

    @PostMapping("/changeinfo")
    public String changeinfo(@RequestBody String body) throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        class_table class_table = objectMapper.readValue(body, class_table.class);
        String class_name = class_table.getClass_name();
        String class_number = class_table.getClass_number();
        mapper_class_table.UPDATA(class_number,class_name);
        return "success";
    }

    @PostMapping("/delete")
    public String deleteclass(@RequestBody String body) throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        class_table class_table = objectMapper.readValue(body, class_table.class);
        String class_number = class_table.getClass_number();
        mapper_class_table.DELECT_BY_class_number(class_number);
        return "success";
    }

    @PostMapping("/deletebatch")
    public String deletebatch(@RequestBody String body) throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        String[] classnumner_sss = objectMapper.readValue(body, String[].class);
        mapper_class_table.DELETE_batch(classnumner_sss);
        return "success";
    }
}
