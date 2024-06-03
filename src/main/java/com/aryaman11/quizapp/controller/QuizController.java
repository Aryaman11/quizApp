package com.aryaman11.quizapp.controller;

import org.springframework.web.bind.annotation.RestController;
import com.aryaman11.quizapp.model.QuestionWrapper;
import com.aryaman11.quizapp.service.QuizService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;




/**
 * This controller handles requests related to quizzes.
 * 
 * The root path is set to "quiz" which means all the URLs in this controller
 * will start with "quiz". 
 */
@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;
    @PostMapping("create")     
    public ResponseEntity<String> createQuiz(@RequestParam String category , @RequestParam int numQ ,@RequestParam String title){
       return quizService.createQuiz(category,numQ,title);
    }
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuiz(@PathVariable("id") Integer id) {
        return quizService.getQuiz(id);
    }
    
    
}
