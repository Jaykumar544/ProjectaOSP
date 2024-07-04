package com.biit.repositories;

import com.biit.entities.Feedback;
import com.biit.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long>
{
    Optional<Feedback> findById(int id);
}