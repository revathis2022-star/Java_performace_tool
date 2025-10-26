package com.example.vit;

import com.example.vit.model.vitResult;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.IOException;

@Service
public class vitService {

    public vitResult analyzeFiles(File normalFile, File springFile) {
        vitResult result = new vitResult();

        try {
            long normalTime = runJavaFile(normalFile);
            long springTime = runJavaFile(springFile);

            double improvement = ((double)(normalTime - springTime) / normalTime) * 100.0;

            result.setNormalTime(normalTime);
            result.setSpringBootTime(springTime);
            result.setImprovement(improvement);
            result.setMessage("File benchmark completed successfully!");

        } catch (Exception e) {
            result.setMessage("Error analyzing files: " + e.getMessage());
        }

        return result;
    }

    private long runJavaFile(File file) throws IOException, InterruptedException {
        String fileName = file.getName().replace(".java", "");
        String dir = file.getParent();

        Process compile = new ProcessBuilder("javac", file.getAbsolutePath())
                .redirectErrorStream(true)
                .start();
        compile.waitFor();

        long start = System.nanoTime();
        Process run = new ProcessBuilder("java", "-cp", dir, fileName)
                .redirectErrorStream(true)
                .start();
        run.waitFor();
        long end = System.nanoTime();

        return (end - start) / 1_000_000; // return time in milliseconds
    }
}
