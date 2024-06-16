package com.example.quroapp.Services;

import com.example.quroapp.Repositories.QuestionRepository;
import com.example.quroapp.models.Question;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class QuestionService {
    private QuestionRepository questionRepository;
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }
    public List<Question> getQuestionByBody(String body) {
        return questionRepository.findQuestionByBodyContaining(body);
    }
    public Question getQuestionByUUId(UUID id) {
        return questionRepository.findQuestionByUUID(id);
    }
}
