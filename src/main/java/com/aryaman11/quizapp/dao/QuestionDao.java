package com.aryaman11.quizapp.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aryaman11.quizapp.Question;
import java.util.List;
@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {
  
    public List<Question> findByCategory(String category);
}