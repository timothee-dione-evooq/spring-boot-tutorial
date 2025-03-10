package com.evooq.quizzapp.service;

import com.evooq.quizzapp.dao.QuestionDao;
import com.evooq.quizzapp.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

  public List<Question> getAllQuestions() {
      return questionDao.findAll();
  }
}