package com.example.demo.controller;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PutObjectRequest;
import com.aliyun.oss.model.PutObjectResult;
import com.example.demo.mappers.Mapper_question_table;
import com.example.demo.pojo.question_table;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
@RequestMapping("question")
@MultipartConfig
public class question {
    @Autowired
    private Mapper_question_table mapper_question_table;

    @GetMapping("/show")
    public List<question_table> showquestions()
    {
        return mapper_question_table.SELECTALL();
    }

    @PostMapping("/addchoose")
    public String ADDchoose(HttpServletRequest request) throws IOException {
        String s = request.getReader().readLine();
        ObjectMapper objectMapper=new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(s);
        JsonNode chapter_number = jsonNode.get("chapter_number");
        System.out.println(String.valueOf(chapter_number));
        JsonNode question_title = jsonNode.get("question_title");
        JsonNode option_a = jsonNode.get("option_a");
        JsonNode option_b = jsonNode.get("option_b");
        JsonNode option_c = jsonNode.get("option_c");
        JsonNode option_d = jsonNode.get("option_d");
        JsonNode question_answer = jsonNode.get("question_answer");
        JsonNode question_explain = jsonNode.get("question_explain");
        question_table question=new question_table();
        String max = mapper_question_table.MAX();
        if(max==null){
            question.setQuestion_number("10001");
        }else
        {
            String max_substring = max.substring(0, max.length() - 2);
            Integer question_number = Integer.valueOf(max_substring);
            question_number+=1;
            question.setQuestion_number(String.valueOf(question_number));
        }
        question.setAccuracy("0.00%");
        question.setWrong_number(0);
        question.setSubmit_number(0);
        question.setChapter_number(chapter_number.asText());
        question.setQuestion_title(question_title.asText());
        question.setOption_a(option_a.asText());
        question.setOption_b(option_b.asText());
        question.setOption_c(option_c.asText());
        question.setOption_d(option_d.asText());
        question.setQuestion_explain(question_explain.asText());
        question.setQuestion_type(0);//选择题
        switch (question_answer.asText()){
            case "A":question.setQuestion_answer(1);break;
            case "B":question.setQuestion_answer(2);break;
            case "C":question.setQuestion_answer(3);break;
            case "D":question.setQuestion_answer(4);break;
        }
        mapper_question_table.ADD_CHOOSE(question);
        return "success";
    }

    @PostMapping("/addpd")
    public String ADDpd(HttpServletRequest request) throws IOException {
        String s = request.getReader().readLine();
        ObjectMapper objectMapper=new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(s);
        String chapter_number = jsonNode.get("chapter_number").asText();
        String question_title = jsonNode.get("question_title").asText();
        String answer = jsonNode.get("question_answer").asText();
        String explain = jsonNode.get("question_explain").asText();
        question_table question=new question_table();
        String max = mapper_question_table.MAX();
        if(max==null){
            question.setQuestion_number("10001");
        }else
        {
            String max_substring = max.substring(0, max.length() - 2);
            Integer question_number = Integer.valueOf(max_substring);
            question_number+=1;
            question.setQuestion_number(String.valueOf(question_number));
        }

        question.setAccuracy("0.00%");
        question.setWrong_number(0);
        question.setSubmit_number(0);
        question.setChapter_number(chapter_number);
        question.setQuestion_title(question_title);
        question.setOption_a("对");
        question.setOption_b("错");
        question.setQuestion_explain(explain);
        question.setQuestion_type(1);//判断题
        switch (answer){
            case "对":question.setQuestion_answer(1);break;
            case "错":question.setQuestion_answer(2);break;
        }
        mapper_question_table.ADD_CHOOSE(question);
        return "success";
    }

    @PostMapping("/delete")
    public String delete(@RequestBody String body) throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        question_table question_table = objectMapper.readValue(body, question_table.class);
        mapper_question_table.DELETE_BY_question_number(question_table.getQuestion_number());
        return "success";
    }

    @PostMapping("/keepquestionnumber")
    public String keepnumber(HttpServletRequest request,@RequestBody String body) throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        question_table question_table = objectMapper.readValue(body, question_table.class);
        HttpSession session = request.getSession();
        session.setAttribute("cur_questionnumber",question_table.getQuestion_number());
        return "success";
    }

    @PostMapping("/oss")
    public void oss(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String questionnumber = (String) session.getAttribute("cur_questionnumber");
        String url="https://*/*/"+questionnumber+".jpg";

        String endpoint = "*";//为了安全
        String accessKeyId = "*";//改为自己的
        String accessKeySecret = "*";
        String bucketName = "*";

        String objectName = "springbootimage/"+questionnumber+".jpg";//保持与题号一致

        Part part = request.getPart("fig");

        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        try {
            InputStream inputStream = part.getInputStream();

            ObjectMetadata objectMetadata=new ObjectMetadata();
            //设置图片格式
            objectMetadata.setContentType("image/jpg");

            // 创建PutObjectRequest对象。
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, objectName, inputStream);
            // 设置该属性可以返回response。如果不设置，则返回的response为空。
            putObjectRequest.setProcess("true");
            // 创建PutObject请求。
            PutObjectResult result = ossClient.putObject(putObjectRequest);

            // 如果上传成功，则返回200。
            if(result.getResponse().getStatusCode()==200)
            {
                mapper_question_table.add_imgurl(questionnumber,url);
            }
            ossClient.shutdown();
            response.sendRedirect("/ELEMENT_questions.html");/*重定向*/
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
