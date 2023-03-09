package com.example.demo.controller;

import com.example.demo.mappers.Mapper_class_table;
import com.example.demo.mappers.Mapper_student_user;
import com.example.demo.pojo.class_table;
import com.example.demo.pojo.student_user;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("stumanage")
@MultipartConfig
public class stumanage {

    @Autowired
    private Mapper_student_user mapper_student_user;
    @Autowired
    private Mapper_class_table mapper_class_table;

    @PostMapping("/check_myclass")
    public String check_myclass(HttpServletRequest request) throws IOException {
        String teacher_number = (String) request.getSession().getAttribute("teacher_number");
        List<class_table> class_tables = mapper_class_table.SELECTALL_BY_teacher_number(teacher_number);
        BufferedReader br=request.getReader();
        String paras = br.readLine();
        for (class_table class_table : class_tables) {
            if(paras.equals(class_table.getClass_number()))
            {
                HttpSession session = request.getSession();
                session.setAttribute("cur_class_number",paras);
                return "YES";
            }
        }
        return "NO";
    }

    @PostMapping("/showstu")
    public List<student_user> SHOWstu(HttpServletRequest request) throws IOException {
        BufferedReader br=request.getReader();
        String paras = br.readLine();
        return mapper_student_user.SELECTALL_BY_class_number(paras);
    }

    @PostMapping("/add")
    public String ADD(@RequestBody String body) throws IOException {
        ObjectMapper objectMapper=new ObjectMapper();
        student_user student_user = objectMapper.readValue(body, student_user.class);
        student_user.setStudent_account(student_user.getStudent_number());
        student_user.setStudent_password(student_user.getStudent_number());
        student_user.setStudent_chapter("1");
        mapper_student_user.ADD(student_user);
        return "success";
    }

    @PostMapping("/delete")
    public String delete(@RequestBody String body) throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        student_user student_user = objectMapper.readValue(body, student_user.class);
        mapper_student_user.Delete_BY_student_number(student_user.getStudent_number());
        return "success";
    }

    @PostMapping("/changeinfo")
    public String changeinfo(@RequestBody String body) throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        student_user student_user = objectMapper.readValue(body, student_user.class);
        mapper_student_user.UPDATA(student_user.getStudent_number(),student_user.getStudent_name());
        return "success";
    }

    @PostMapping("/delete_batch")
    public String deletebatch(@RequestBody String body) throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        String[] strings = objectMapper.readValue(body, String[].class);
        mapper_student_user.DELETE_batch(strings);
        return "success";
    }

    @PostMapping("/addexcel")
    public void add_BY_Excel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String cur_class_number = (String) session.getAttribute("cur_class_number");
        Part part = request.getPart("excel");
        //System.out.println(part);
        XSSFWorkbook workbook = new XSSFWorkbook(part.getInputStream());


        XSSFSheet sheet = workbook.getSheetAt(0);
        //获取最后一行的num，即总行数。此处从0开始
        int maxRow = sheet.getLastRowNum();
        for (int row = 0; row <= maxRow; row++) {
            //获取最后单元格num，即总单元格数 ***注意：此处从1开始计数***
            student_user student_user=new student_user();
            student_user.setClass_number(cur_class_number);
            student_user.setStudent_chapter("1");

            BigDecimal stunumber_E = new BigDecimal(String.valueOf(sheet.getRow(row).getCell(0)));
            String stunumber = stunumber_E.toString();
            String stuname = String.valueOf(sheet.getRow(row).getCell(1));
            if(stunumber.substring(stunumber.length()-2).equals(".0"))
            {stunumber=stunumber.substring(0,stunumber.length()-2);}
            student_user.setStudent_number(stunumber);
            student_user.setStudent_account(stunumber);
            student_user.setStudent_password(stunumber);
            student_user.setStudent_name(stuname);
            mapper_student_user.ADD(student_user);
        }
        response.sendRedirect("/ELEMENT_students.html");
    }
}
