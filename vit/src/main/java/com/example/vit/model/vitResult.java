package com.example.vit.service;

import com.example.vit.model.vitResult;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class vitService {

    public vitResult analyzeFiles(File normalFile, File springFile) {
        vitResult result = new vitResult();

        try {
            // Simulate running or analyzing both Java files
            long normalStart = System.currentTimeMillis();
            simulateExecution(normalFile);
            long normalEnd = System.currentTimeMillis();

            long springStart = System.currentTimeMillis();
            simulateExecution(springFile);
            long springEnd = System.currentTimeMillis();

            long normalTime = normalEnd - normalStart;
            long springTime = springEnd - springStart;

            // Calculate improvement percentage
            double improvement = ((double) (normalTime - springTime) / normalTime) * 100;

            result.setNormalTime(normalTime);
            result.setSpringBootTime(springTime);
            result.setImprovement(improvement);
            result.setMessage("Files analyzed successfully!");

        } catch (Exception e) {
            result.setMessage("Error analyzing files: " + e.getMessage());
        }

        return result;
    }

    // Dummy function to simulate file processing delay
    private void simulateExecution(File file) throws IOException, InterruptedException {
        long size = file.length();
        long delay = Math.min(size / 10, 3000); // limit delay to 3 seconds max
        Thread.sleep(delay);
    }
}
