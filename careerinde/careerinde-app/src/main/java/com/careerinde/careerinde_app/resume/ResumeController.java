package com.careerinde.careerinde_app.resume;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.multipart.MultipartFile;

import com.careerinde.careerinde_app.ai.OpenAIService;

import com.careerinde.careerinde_app.analysis.Analysis;
import com.careerinde.careerinde_app.analysis.AnalysisRepository;

import com.careerinde.careerinde_app.ats.AtsAnalyzerService;
import com.careerinde.careerinde_app.ats.RecommendationService;

@Controller
public class ResumeController {

    private final PdfService pdfService;

    private final AtsAnalyzerService atsAnalyzerService;

    private final RecommendationService recommendationService;

    private final AnalysisRepository analysisRepository;

    private final OpenAIService openAIService;

    public ResumeController(
            PdfService pdfService,
            AtsAnalyzerService atsAnalyzerService,
            RecommendationService recommendationService,
            AnalysisRepository analysisRepository,
            OpenAIService openAIService) {

        this.pdfService = pdfService;

        this.atsAnalyzerService =
                atsAnalyzerService;

        this.recommendationService =
                recommendationService;

        this.analysisRepository =
                analysisRepository;

        this.openAIService =
                openAIService;
    }

    @GetMapping("/resume/upload")
    public String uploadPage() {

        return "resume-upload";
    }

    @PostMapping("/resume/upload")
    public String uploadResume(
            @RequestParam("file")
            MultipartFile file,

            Model model)
            throws IOException {

        String uploadDir =
                System.getProperty("user.dir")
                        + "/uploads/";

        File directory =
                new File(uploadDir);

        if (!directory.exists()) {

            directory.mkdirs();
        }

        String fileName =
                file.getOriginalFilename();

        File destination =
                new File(uploadDir + fileName);

        file.transferTo(destination);

        String extractedText =
                pdfService.extractText(destination);

        String aiResponse =
                openAIService
                        .analyzeCV(extractedText);

        int atsScore =
                extractAtsScore(aiResponse);

        List<String> skills =
                atsAnalyzerService
                        .detectSkills(extractedText);

        List<String> missingSkills =
                atsAnalyzerService
                        .missingSkills(extractedText);

        List<String> suggestions =
                recommendationService
                        .generateSuggestions(extractedText);

        Analysis analysis =
                new Analysis();

        analysis.setAtsScore(atsScore);

        analysis.setDetectedSkills(
                String.join(", ", skills));

        analysis.setMissingSkills(
                String.join(", ", missingSkills));

        analysis.setSuggestions(
                String.join(", ", suggestions));

        analysis.setCvText(extractedText);

        analysisRepository.save(analysis);

        model.addAttribute(
                "atsScore",
                atsScore);

        model.addAttribute(
                "skills",
                skills);

        model.addAttribute(
                "missingSkills",
                missingSkills);

        model.addAttribute(
                "suggestions",
                suggestions);

        model.addAttribute(
                "aiResponse",
                aiResponse);

        model.addAttribute(
                "cvText",
                extractedText);

        return "cv-result";
    }

    private int extractAtsScore(
            String response) {

        try {

            String[] lines =
                    response.split("\n");

            for (String line : lines) {

                if (line.startsWith(
                        "ATS_SCORE:")) {

                    String score =
                            line.replace(
                                    "ATS_SCORE:",
                                    "")
                                    .trim();

                    return Integer.parseInt(score);
                }
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return 0;
    }
}