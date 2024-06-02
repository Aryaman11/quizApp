package com.aryaman11.quizapp.controller;
import com.aryaman11.quizapp.service.QuestionService;
import com.aryaman11.quizapp.Question;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.*;


@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping("getAllQuestion")
    public List<Question> getAllQuestion(){
        return questionService.getAllQuestion();
    }

    @GetMapping("category/{cat}")
    public List <Question> categoryAll(@PathVariable String cat){ {
        return questionService.categoryAll(cat);
    }
    
    
    }
}
