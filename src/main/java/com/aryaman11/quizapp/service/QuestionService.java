package com.aryaman11.quizapp.service;
import com.aryaman11.quizapp.Question;
import com.aryaman11.quizapp.dao.QuestionDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    public List<Question> getAllQuestion(){
        return questionDao.findAll();
    }
}
