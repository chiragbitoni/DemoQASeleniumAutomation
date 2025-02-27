package com.demoqa.listener;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestContext;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestResultListener implements ITestListener{
    private final JSONArray results = new JSONArray();
    private final long testRunStartTime = System.currentTimeMillis();
    private final String testRunId = "Run-" + testRunStartTime;

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
        saveResultsToFile(context);
    }

    private void addResult(ITestResult result, String status) {
        JSONObject testResult = new JSONObject();
        testResult.put("testCaseId", result.getMethod().getMethodName());
        testResult.put("description", result.getMethod().getDescription());
        testResult.put("testName", result.getName());
        testResult.put("status", status);
        testResult.put("message", getThrowableMessage(result));
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

    private String formatTime(long millis) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date(millis));
    }

    private void saveResultsToFile(ITestContext context) {
        try {
            JSONArray allRuns;

            // Load existing results to append new ones
            if (Files.exists(Paths.get("test-results.json"))) {
                String existingData = new String(Files.readAllBytes(Paths.get("test-results.json")));
                allRuns = new JSONArray(existingData);
            } else {
                allRuns = new JSONArray();
            }

            // Create the new test run entry
            JSONObject testRun = new JSONObject();
            testRun.put("testRunId", testRunId);
            testRun.put("testExecutionDate", formatTime(testRunStartTime));
            testRun.put("testTotalTime", System.currentTimeMillis() - testRunStartTime);
            testRun.put("testCases", results);

            // Add new run to existing results
            allRuns.put(testRun);

            // Save updated results back to file
            try (FileWriter file = new FileWriter("target/test-results.json")) {
                file.write(allRuns.toString(4)); // Pretty print with indentation
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
