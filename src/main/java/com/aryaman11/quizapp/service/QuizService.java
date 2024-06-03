package com.aryaman11.quizapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.HttpStatus;

import com.aryaman11.quizapp.dao.QuestionDao;
import com.aryaman11.quizapp.dao.QuizDao;
import com.aryaman11.quizapp.model.Question;
import com.aryaman11.quizapp.model.QuestionWrapper;
import com.aryaman11.quizapp.model.Quiz;
import com.aryaman11.quizapp.model.Response;

import java.util.Optional;

@Service
public class QuizService {

    @Autowired
    private QuizDao quizDao;

    @Autowired
    private QuestionDao questionDao;

    @Transactional
    public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
        List<Question> questions = questionDao.findRandomQuestions(category, numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestion(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("Quiz created successfully", HttpStatus.CREATED);
    }

    public ResponseEntity<List<QuestionWrapper>> getQuiz(Integer id){

        Optional<Quiz> quiz =  quizDao.findById(id);
        List<Question> questionFromDB = quiz.get().getQuestion();
        List<QuestionWrapper> questionForUsers = new ArrayList<>();
        for(Question q: questionFromDB){
            QuestionWrapper qw = new QuestionWrapper();
            qw.setId(q.getId());
            qw.setQuestion_title(q.getQuestion_title());
            qw.setOption1(q.getOption1());
            qw.setOption2(q.getOption2());
            qw.setOption3(q.getOption3());
            qw.setOption4(q.getOption4());
            questionForUsers.add(qw);
        } 
        return new ResponseEntity<>(questionForUsers,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calResult(Integer id, List<Response> response) {
    Optional<Quiz> optionalQuiz = quizDao.findById(id);
   

    Quiz quiz = optionalQuiz.get();
    List<Question> questions = quiz.getQuestion();
    int right = 0;
    int i = 0;
    for (Response r : response) {
        if (r.getResponse().equals(questions.get(i).getRight_answer())) {
            right++;
        }
        i++;
    }
    return new ResponseEntity<>(right, HttpStatus.OK);
}

}
