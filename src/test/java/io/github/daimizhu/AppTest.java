package io.github.daimizhu;

import io.github.daimizhu.service.TransitionServiceTest;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class AppTest {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TransitionServiceTest.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("Both Tests finished successfully...");
        }
    }
}
