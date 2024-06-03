package com.aryaman11.quizapp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.aryaman11.quizapp.model.Quiz;


@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer> {

    
} 
