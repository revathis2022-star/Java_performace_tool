package com.example.vit;

import com.example.vit.model.vitResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@RestController
@RequestMapping("/api")
public class vitController {

    @Autowired
    private vitService vitService;

    @PostMapping("/compare")
    public vitResult compareFiles(@RequestParam("normal") MultipartFile normalFile,
                                  @RequestParam("spring") MultipartFile springFile) {
        try {
            File tempNormal = File.createTempFile("normal_", ".java");
            File tempSpring = File.createTempFile("spring_", ".java");

            normalFile.transferTo(tempNormal);
            springFile.transferTo(tempSpring);

            return vitService.analyzeFiles(tempNormal, tempSpring);

        } catch (Exception e) {
            vitResult result = new vitResult();
            result.setMessage("Error: " + e.getMessage());
            return result;
        }
    }
}
