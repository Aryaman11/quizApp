package com.aryaman11.quizapp.controller;
import com.aryaman11.quizapp.service.QuestionService;
import com.aryaman11.quizapp.Question;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.*;


@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping("getAllQuestion")
    public ResponseEntity<List<Question>> getAllQuestion(){
        return questionService.getAllQuestion();
    }

    @GetMapping("delete/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable("id") int id){
        return questionService.deleteQuestion(id);
    }

    @GetMapping("category/{cat}")
    public ResponseEntity<List <Question>> categoryAll(@PathVariable String cat){ 
        return questionService.categoryAll(cat);
    }
    
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody Question question){
           return questionService.addQuestion(question);
    }

    
    
    }

