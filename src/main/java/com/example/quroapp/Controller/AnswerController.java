package com.example.quroapp.Controller;

import com.example.quroapp.Services.AnswerService;
import com.example.quroapp.Services.QuestionService;
import com.example.quroapp.models.Answer;
import com.example.quroapp.models.Question;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/api/v1")
public class AnswerController {
    private AnswerService answerService;
    private QuestionService questionService;
    public AnswerController(AnswerService answerService, QuestionService questionService) {
        this.answerService = answerService;
        this.questionService=questionService;
    }

    @PostMapping("/questions/{questionId}/answers")
    public ResponseEntity<?> createAnswer(@PathVariable UUID questionId, @RequestBody Answer answer) {
        Question question=questionService.getQuestionByUUId(questionId);
        answer.setQuestion(question);
        return ResponseEntity.status(HttpStatus.CREATED).body(answerService.addAnswer(answer));
    }
    @PatchMapping("/answers/{answerId}")
    public ResponseEntity<?> updateAnswer(@PathVariable UUID answerId, @RequestBody Answer answer) {
        Optional<Answer> answer1= answerService.getAnswerByUUId(answerId);
        if(answer1.isPresent()) {
            if(answer.getText()!=null ){
                answer1.get().setText(answer.getText());
            }
            if(answer.getQuestion()!=null ){
                answer1.get().setQuestion(answer.getQuestion());
            }
            if (answer.getUser()!=null) {
                answer1.get().setUser(answer.getUser());
            }
            return ResponseEntity.status(HttpStatus.OK).body(answer1);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Answer not found");
    }
}
