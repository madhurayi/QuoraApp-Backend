package com.example.quroapp.Controller;

import com.example.quroapp.Services.QuestionService;
import com.example.quroapp.models.Question;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1/questions")
public class QuestionController {
    public QuestionService questionService;
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping
    public ResponseEntity<?> createQuestion(@RequestBody Question question) {
        System.out.println(question.getTitle());
        return ResponseEntity.status(HttpStatus.CREATED).body(questionService.addQuestion(question));
    }

    @GetMapping("/search")
    public ResponseEntity<?> getQuestionByBody(@RequestParam String body) {
            return ResponseEntity.status(HttpStatus.OK).body(questionService.getQuestionByBody(body));
    }
}
