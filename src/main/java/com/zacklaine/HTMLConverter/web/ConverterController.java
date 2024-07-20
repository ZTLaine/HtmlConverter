package com.zacklaine.HTMLConverter.web;

import com.zacklaine.HTMLConverter.service.FileService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

@Controller
public class ConverterController {

    private final FileService fileService;

    ConverterController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/html-pdf")
    public void HtmlToPdf() throws IOException {
//        String content = Files.readString(Paths.get("../../../../../../" + "2023 PFT Results.html"));
//
//        Path path = Paths.get("E:\\\\Coding\\\\HTMLConverter\\\\2023 PFT Results.html");
//        String content = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
//
//        System.out.println(content.substring(0, 25));

        fileService.htmlToPdf("2023 PFT Results.html", "2023 PFT Results.pdf");
    }

}
