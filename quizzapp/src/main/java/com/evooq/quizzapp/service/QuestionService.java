package com.evooq.quizzapp.service;

import com.evooq.quizzapp.dao.QuestionDao;
import com.evooq.quizzapp.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

  public List<Question> getAllQuestions() {
      return questionDao.findAll();
  }

  public List<Question> getQuestionsByCategory(String category) {
      return questionDao.findByCategory(category);
  }

  public String addQuestion(@RequestBody Question question) {
     return String.valueOf(questionDao.save(question));
  }
}



