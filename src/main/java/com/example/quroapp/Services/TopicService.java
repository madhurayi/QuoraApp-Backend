package com.example.quroapp.Services;

import com.example.quroapp.Repositories.TopicRepository;
import com.example.quroapp.models.Topic;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {
    public TopicRepository topicRepository;
    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public Topic addTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }
}
