package com.aryaman11.quizapp.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.aryaman11.quizapp.model.Question;

import java.util.List;
@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
  
    public List<Question> findByCategory(String category);
    
    @Query(value="SELECT * FROM question q WHERE q.category = :category ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
       public List<Question> findRandomQuestions(String category, int numQ);
}