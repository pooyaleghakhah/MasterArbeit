package com.careerinde.careerinde_app.analysis;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.careerinde.careerinde_app.user.User;

public interface AnalysisRepository
        extends JpaRepository<Analysis, Long> {

    List<Analysis> findByUser(User user);
}