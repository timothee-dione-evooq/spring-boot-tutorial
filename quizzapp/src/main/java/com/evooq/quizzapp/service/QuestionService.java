package com.evooq.quizzapp.service;

import com.evooq.quizzapp.dao.QuestionDao;
import com.evooq.quizzapp.Question;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

  public ResponseEntity<List<Question>> getAllQuestions() {
      try {
          return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
      } catch(Exception e) {
          e.printStackTrace();
      }
      return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
  }

  public ResponseEntity<List<Question>> getQuestionsByCategory(String category) {
      try {
          return new ResponseEntity<>(questionDao.findByCategory(category), HttpStatus.OK);
      } catch(Exception e) {
          e.printStackTrace();
      }
      return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
  }

  public ResponseEntity<Question> addQuestion(Question question) {
      try {
          return new ResponseEntity<>(questionDao.save(question), HttpStatus.CREATED);
      } catch(Exception e) {
          e.printStackTrace();
      }
      return new ResponseEntity<>(question, HttpStatus.BAD_REQUEST);
  }

    public String updateQuestion(Question question) {
      return String.valueOf(questionDao.save(question));
    }

    public String deleteQuestion(Integer questionId) {
        if (!questionDao.existsById(questionId)) {
            throw new EntityNotFoundException("Question with ID " + questionId + " dooesn't exist");
        }
        questionDao.deleteById(questionId);
        return "Question was successfully deleted";
    }
}



