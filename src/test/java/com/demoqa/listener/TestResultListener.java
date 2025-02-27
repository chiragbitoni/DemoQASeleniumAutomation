package com.demoqa.listener;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestResultListener implements ITestListener {
    private final JSONArray results = new JSONArray();
    private final long testRunStartTime = System.currentTimeMillis();
    private final String testRunId = "Run-" + testRunStartTime;
    private static final String RESULTS_FILE_PATH = "target/test-results.json";

    @Override
    public void onTestSuccess(ITestResult result) {
        addResult(result, "PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        addResult(result, "FAILED");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        addResult(result, "SKIPPED");
    }

    @Override
    public void onFinish(ITestContext context) {
        saveResultsToFile();
    }

    private void addResult(ITestResult result, String status) {
        JSONObject testResult = new JSONObject();
        testResult.put("testCaseId", result.getMethod().getMethodName());
        testResult.put("description", result.getMethod().getDescription());
        testResult.put("testName", result.getName());
        testResult.put("status", status);
        testResult.put("message", getThrowableMessage(result));
        testResult.put("errorStackTrace", getStackTrace(result));
        testResult.put("timeSpan", result.getEndMillis() - result.getStartMillis());
        testResult.put("timeMs", result.getEndMillis() - result.getStartMillis());
        testResult.put("startTime", formatTime(result.getStartMillis()));
        testResult.put("endTime", formatTime(result.getEndMillis()));
        testResult.put("class", result.getTestClass().getName());

        results.put(testResult);
    }

    private String getThrowableMessage(ITestResult result) {
        if (result.getThrowable() != null) {
            return result.getThrowable().getMessage();
        }
        return "No errors";
    }

    private String getStackTrace(ITestResult result) {
        if (result.getThrowable() != null) {
            return Stream.of(result.getThrowable().getStackTrace())
                    .map(StackTraceElement::toString)
                    .collect(Collectors.joining("\n"));
        }
        return "No stack trace available";
    }

    private String formatTime(long millis) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date(millis));
    }

    private void saveResultsToFile() {
        try {
            // Ensure target directory exists
            Path targetPath = Paths.get("target");
            if (!Files.exists(targetPath)) {
                Files.createDirectories(targetPath);
            }

            JSONArray allRuns;
            Path resultsPath = Paths.get(RESULTS_FILE_PATH);

            // Load existing results, handling invalid JSON
            if (Files.exists(resultsPath)) {
                try {
                    String existingData = new String(Files.readAllBytes(resultsPath));
                    allRuns = new JSONArray(existingData);
                } catch (Exception e) {
                    System.err.println("Invalid JSON in test-results.json, resetting file.");
                    allRuns = new JSONArray();
                }
            } else {
                allRuns = new JSONArray();
            }

            // Add current test run
            JSONObject testRun = new JSONObject();
            testRun.put("testRunId", testRunId);
            testRun.put("testExecutionDate", formatTime(testRunStartTime));
            testRun.put("testTotalTime", System.currentTimeMillis() - testRunStartTime);
            testRun.put("testCases", results);

            allRuns.put(testRun);

            // Save results
            try (FileWriter file = new FileWriter(RESULTS_FILE_PATH)) {
                file.write(allRuns.toString(4)); // Pretty print JSON
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
