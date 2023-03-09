package com.example.demo.controller;

import com.example.demo.mappers.Mapper_teacher_user;
import com.example.demo.pojo.teacher_user;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZJH111
 * * @date 2023/3/2
 */
@RestController
@RequestMapping("/login_register")
public class login_register {

    @Autowired
    private Mapper_teacher_user mapper_teacher_user;

    @PostMapping("/login")
    public void login(String teacher_account, String teacher_password, HttpServletRequest request, HttpServletResponse response)throws Exception
    {
        teacher_user teacher_user = mapper_teacher_user.SELECT_login(teacher_account, teacher_password);
        if(teacher_user==null){
            response.sendRedirect("/REGISTER_END.html");
        }
        else
        {
            /*session域中存放教师号和教师名字*/
            HttpSession session = request.getSession();
            session.setAttribute("teacher_number",teacher_user.getTeacher_number());
            session.setAttribute("teacher_name",teacher_user.getTeacher_name());

            response.sendRedirect("/ELEMENT_HOME.html");/*重定向*/
        }
    }

    @PostMapping("/register")
    public void register(teacher_user teacher_user,HttpServletResponse response) throws Exception
    {
        teacher_user.setTeacher_number(teacher_user.getTeacher_account());
        mapper_teacher_user.ADD(teacher_user);
        response.sendRedirect("/index.html");
    }

    @GetMapping("/CHECKuserSERVLET")
    public String CHECKuserSERVLET(HttpServletRequest request)
    {
        String teacher_account = request.getParameter("teacher_account");
        teacher_user teacherUser = mapper_teacher_user.SELECT_BY_teacher_account(teacher_account);
        if (teacherUser!=null){
            return "true";
        }
        else {
            return "false";
        }
    }
}
