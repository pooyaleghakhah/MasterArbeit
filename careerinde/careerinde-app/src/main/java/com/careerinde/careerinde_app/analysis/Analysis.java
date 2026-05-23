package com.careerinde.careerinde_app.analysis;

import com.careerinde.careerinde_app.user.User;

import jakarta.persistence.*;

@Entity
@Table(name = "analyses")
public class Analysis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int atsScore;

    @Column(length = 5000)
    private String detectedSkills;

    @Column(length = 5000)
    private String missingSkills;

    @Column(length = 5000)
    private String suggestions;

    @Column(length = 10000)
    private String cvText;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Analysis() {
    }

    public Long getId() {
        return id;
    }

    public int getAtsScore() {
        return atsScore;
    }

    public void setAtsScore(int atsScore) {
        this.atsScore = atsScore;
    }

    public String getDetectedSkills() {
        return detectedSkills;
    }

    public void setDetectedSkills(String detectedSkills) {
        this.detectedSkills = detectedSkills;
    }

    public String getMissingSkills() {
        return missingSkills;
    }

    public void setMissingSkills(String missingSkills) {
        this.missingSkills = missingSkills;
    }

    public String getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(String suggestions) {
        this.suggestions = suggestions;
    }

    public String getCvText() {
        return cvText;
    }

    public void setCvText(String cvText) {
        this.cvText = cvText;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}