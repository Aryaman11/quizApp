package com.aryaman11.quizapp;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("question")
public class quizController {
    @GetMapping("getAllQuestion")
    public String  getAllQuestion(){

        return "hello.... this is the first question in the quiz";
    }
    
}
