package com.example.quroapp.Repositories;

import com.example.quroapp.models.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AnswerRepository extends JpaRepository<Answer, Integer> {
    @Query(nativeQuery = true,value="select * from Answer where id=:answerId")
     Optional<Answer> findByAnswerUUId(UUID answerId);
}
