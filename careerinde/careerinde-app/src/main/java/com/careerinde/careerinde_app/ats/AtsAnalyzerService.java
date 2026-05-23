package com.careerinde.careerinde_app.ats;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AtsAnalyzerService {

    public int calculateScore(String text) {

        int score = 0;

        text = text.toLowerCase();

        if (text.contains("java")) {
            score += 10;
        }

        if (text.contains("spring")) {
            score += 10;
        }

        if (text.contains("spring boot")) {
            score += 10;
        }

        if (text.contains("postgresql")) {
            score += 8;
        }

        if (text.contains("sql")) {
            score += 5;
        }

        if (text.contains("docker")) {
            score += 10;
        }

        if (text.contains("aws")) {
            score += 10;
        }

        if (text.contains("azure")) {
            score += 10;
        }

        if (text.contains("cloud")) {
            score += 8;
        }

        if (text.contains("kubernetes")) {
            score += 10;
        }

        if (text.contains("git")) {
            score += 5;
        }

        if (text.contains("github")) {
            score += 5;
        }

        if (text.contains("react")) {
            score += 8;
        }

        if (text.contains("fastapi")) {
            score += 8;
        }

        if (text.contains("python")) {
            score += 8;
        }

        if (text.contains("power bi")) {
            score += 8;
        }

        if (text.contains("data science")) {
            score += 8;
        }

        if (text.contains("ai")) {
            score += 8;
        }

        if (text.contains("digital transformation")) {
            score += 8;
        }

        if (text.contains("industry 4.0")) {
            score += 8;
        }

        if (text.contains("jira")) {
            score += 5;
        }

        if (text.contains("project management")) {
            score += 8;
        }

        return Math.min(score, 100);
    }

    public List<String> detectSkills(String text) {

        List<String> skills =
                new ArrayList<>();

        text = text.toLowerCase();

        if (text.contains("java")) {
            skills.add("Java");
        }

        if (text.contains("spring")) {
            skills.add("Spring");
        }

        if (text.contains("spring boot")) {
            skills.add("Spring Boot");
        }

        if (text.contains("spring security")) {
            skills.add("Spring Security");
        }

        if (text.contains("postgresql")) {
            skills.add("PostgreSQL");
        }

        if (text.contains("sql")) {
            skills.add("SQL");
        }

        if (text.contains("docker")) {
            skills.add("Docker");
        }

        if (text.contains("aws")) {
            skills.add("AWS");
        }

        if (text.contains("azure")) {
            skills.add("Azure");
        }

        if (text.contains("cloud")) {
            skills.add("Cloud");
        }

        if (text.contains("kubernetes")) {
            skills.add("Kubernetes");
        }

        if (text.contains("git")) {
            skills.add("Git");
        }

        if (text.contains("github")) {
            skills.add("GitHub");
        }

        if (text.contains("react")) {
            skills.add("React");
        }

        if (text.contains("fastapi")) {
            skills.add("FastAPI");
        }

        if (text.contains("python")) {
            skills.add("Python");
        }

        if (text.contains("power bi")) {
            skills.add("Power BI");
        }

        if (text.contains("data science")) {
            skills.add("Data Science");
        }

        if (text.contains("ai")) {
            skills.add("AI");
        }

        if (text.contains("digital transformation")) {
            skills.add("Digital Transformation");
        }

        if (text.contains("industry 4.0")) {
            skills.add("Industry 4.0");
        }

        if (text.contains("jira")) {
            skills.add("Jira");
        }

        if (text.contains("project management")) {
            skills.add("Project Management");
        }

        return skills;
    }

    public List<String> missingSkills(String text) {

        List<String> missing =
                new ArrayList<>();

        text = text.toLowerCase();

        if (!text.contains("docker")) {
            missing.add("Docker");
        }

        if (!text.contains("aws")
                && !text.contains("azure")) {

            missing.add("Cloud Experience");
        }

        if (!text.contains("kubernetes")) {
            missing.add("Kubernetes");
        }

        if (!text.contains("spring security")) {
            missing.add("Spring Security");
        }

        if (!text.contains("microservices")) {
            missing.add("Microservices");
        }

        if (!text.contains("rest api")) {
            missing.add("REST API");
        }

        return missing;
    }
}
