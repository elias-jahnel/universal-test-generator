package org.elias.testgen;

import java.lang.reflect.Method;
import java.util.Arrays;

public class ResultFormatter {
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";
    private static final String RESET = "\u001B[0m";

    public static void printResult(Method m, Object[] args, Object result) {
        String color = (result != null) ? GREEN : RED;
        System.out.println(color + "[TEST]" + RESET + " " + m.getName() +
                "(" + Arrays.toString(args) + ") -> " + result);
    }
}
