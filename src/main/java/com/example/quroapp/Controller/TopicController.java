package com.example.quroapp.Controller;

import com.example.quroapp.Services.TopicService;
import com.example.quroapp.models.Topic;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/topics")
public class TopicController {
    public TopicService topicService;
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @PostMapping
    public ResponseEntity<?> addTopic(@RequestBody Topic topic) {
        return ResponseEntity.status(HttpStatus.CREATED).body(topicService.addTopic(topic));
    }

    @GetMapping
    public ResponseEntity<?> getAllTopics() {
        return ResponseEntity.status(HttpStatus.OK).body(topicService.getAllTopics());
    }
}
