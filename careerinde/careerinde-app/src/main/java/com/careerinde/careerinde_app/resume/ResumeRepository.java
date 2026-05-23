package com.careerinde.careerinde_app.resume;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.careerinde.careerinde_app.user.User;

public interface ResumeRepository
        extends JpaRepository<Resume, Long> {

    Optional<Resume> findByUser(User user);
}