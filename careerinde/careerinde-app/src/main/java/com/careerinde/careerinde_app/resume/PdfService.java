package com.careerinde.careerinde_app.resume;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;

import org.apache.pdfbox.text.PDFTextStripper;

import org.springframework.stereotype.Service;

@Service
public class PdfService {

    public String extractText(File pdfFile)
            throws IOException {

        PDDocument document =
                Loader.loadPDF(pdfFile);

        PDFTextStripper pdfStripper =
                new PDFTextStripper();

        String text =
                pdfStripper.getText(document);

        document.close();

        return text;
    }
}