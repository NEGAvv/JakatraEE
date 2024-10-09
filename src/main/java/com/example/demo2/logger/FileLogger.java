package com.example.demo2.logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FileLogger {
    private final String logFilePath = "D:\\JakatraEEApp\\glassfish7\\glassfish\\domains\\domain1\\logs\\file.log";

    public void log(String message) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String logMessage = String.format("[%s] %s", timestamp, message);

        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(logFilePath, true)))) {
            out.println(logMessage);
        } catch (IOException e) {
            System.err.println("Failed to write to log file: " + e.getMessage());
        }
    }
}
