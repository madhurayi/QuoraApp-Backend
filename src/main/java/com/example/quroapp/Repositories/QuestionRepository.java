package com.example.quroapp.Repositories;

import com.example.quroapp.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    List<Question> findQuestionByBodyContaining(String body);

    @Query(nativeQuery = true,value="select * from Question where id=:uuid")
    Question findQuestionByUUID(UUID uuid);
}
