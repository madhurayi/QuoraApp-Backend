package com.example.quroapp.Services;

import com.example.quroapp.Repositories.AnswerRepository;
import com.example.quroapp.models.Answer;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class AnswerService {
    private AnswerRepository answerRepository;
    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }
    public Answer addAnswer(Answer answer) {

        return answerRepository.save(answer);
    }
    public Optional<Answer> getAnswerByUUId(UUID id) {
        return answerRepository.findByAnswerUUId(id);
    }

}
