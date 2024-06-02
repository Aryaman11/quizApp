package com.aryaman11.quizapp.service;
import com.aryaman11.quizapp.Question;
import com.aryaman11.quizapp.dao.QuestionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestion(){
        try{
           return new ResponseEntity<>(questionDao.findAll(),HttpStatus.OK);
        }catch(Exception e){
           e.printStackTrace();
           return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<List<Question>> categoryAll(String category){
        try{
            return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();    
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<String> addQuestion(Question question){
        try{
         questionDao.save(question);
        return new ResponseEntity<>("Question added successfully",HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }

    public ResponseEntity<String> deleteQuestion(int id){
        try{
            questionDao.deleteById(id);
        return new ResponseEntity<>("Question deleted successfully",HttpStatus.OK);
        }catch(Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
}
