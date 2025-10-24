package com.example.vit.controller;

import com.example.vit.model.vitResult;
import com.example.vit.service.vitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class vitController {

    @Autowired
    private vitService benchmarkService;

    @GetMapping("/")
    public String index() {
        return "index"; // Loads index.html
    }

    @PostMapping("/analyze")
    public String analyzeFiles(@RequestParam("normalFile") MultipartFile normalFile,
                               @RequestParam("springFile") MultipartFile springFile,
                               Model model) {

        try {
            // 1️⃣ Create upload directory
            File uploadDir = new File("uploads");
            if (!uploadDir.exists()) uploadDir.mkdirs();

            // 2️⃣ Save uploaded files
            File normal = new File(uploadDir, normalFile.getOriginalFilename());
            File spring = new File(uploadDir, springFile.getOriginalFilename());
            normalFile.transferTo(normal);
            springFile.transferTo(spring);

            // 3️⃣ Analyze both files using service
            vitResult result = benchmarkService.analyzeFiles(normal, spring);

            // 4️⃣ Send results to result.html
            model.addAttribute("result", result);
            return "result";

        } catch (IOException e) {
            e.printStackTrace();
            model.addAttribute("error", "Error while uploading or analyzing files: " + e.getMessage());
            return "index";
        }
    }
}
