package com.careerinde.careerinde_app.profile;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.careerinde.careerinde_app.user.User;

public interface ProfileRepository
        extends JpaRepository<Profile, Long> {

    Optional<Profile> findByUser(User user);
}