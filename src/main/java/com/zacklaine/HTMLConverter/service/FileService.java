package com.zacklaine.HTMLConverter.service;

import org.springframework.stereotype.Service;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class FileService {
    private String filePath;

    FileService() {
        this.filePath = ".." + File.separator + ".." + File.separator + ".." + File.separator +
                ".." + File.separator + ".." + File.separator + ".." + File.separator;
    }

    public void htmlToPdf(String htmlFile, String pdfFile) throws IOException {
        String htmlContent = readFileContent(filePath + htmlFile);

        try (OutputStream os = new FileOutputStream(filePath + pdfFile)) {
            ITextRenderer renderer = new ITextRenderer();
            renderer.setDocumentFromString(htmlContent);
            renderer.layout();
            renderer.createPDF(os);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //Start here, something is off with the filepath when passed here
    private String readFileContent(String htmlFilePath) throws IOException {
        System.out.println("Current working directory: " + System.getProperty("user.dir"));

        byte[] encoded = Files.readAllBytes(Paths.get(htmlFilePath));
        String content = new String(encoded, StandardCharsets.UTF_8);

        if (content.startsWith("\uFEFF")) {
            content = content.substring(1);
        }

        return content;
    }
}
