package com.careerinde.careerinde_app.ats;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class RecommendationService {

    public List<String> generateSuggestions(String text) {

        List<String> suggestions =
                new ArrayList<>();

        text = text.toLowerCase();

        if (!text.contains("docker")) {

            suggestions.add(
                    "Learn Docker for modern backend deployment.");
        }

        if (!text.contains("aws")) {

            suggestions.add(
                    "Add AWS cloud skills to improve Germany job opportunities.");
        }

        if (!text.contains("spring security")) {

            suggestions.add(
                    "Learn Spring Security for enterprise Java development.");
        }

        if (!text.contains("github")) {

            suggestions.add(
                    "Add GitHub portfolio links to your CV.");
        }

        if (!text.contains("english")) {

            suggestions.add(
                    "Mention your English proficiency clearly.");
        }

        if (!text.contains("german")) {

            suggestions.add(
                    "German language skills can significantly improve your chances.");
        }

        return suggestions;
    }
}