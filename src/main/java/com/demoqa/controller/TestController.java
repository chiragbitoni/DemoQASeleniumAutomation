package com.demoqa.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.testng.TestNG;

import java.util.Collections;
import java.util.List;

@RestController
public class TestController {

    protected  String actial = "";
    @GetMapping("/api/run-tests")
    public String runTests() {
        try {
            System.out.println("Starting test execution...");

            TestNG testng = new TestNG();
            String suitePath = System.getProperty("user.dir") + "/target/test-classes/testng.xml";
            actial = System.getProperty("user.dir") + "/target/test-classes/testng.xml";
            testng.setTestSuites(List.of(suitePath));
            testng.run();

            System.out.println("Test execution finished.");
            return "Test execution started. Check 'test-results.json' for results." + actial;
        } catch (Exception e) {
            System.out.println();
            e.printStackTrace();
            return "Test execution failed: " + e.getMessage();
        }

    }
}
