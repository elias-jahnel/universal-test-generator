package org.elias.testgen;

import java.lang.reflect.Method;
import java.util.Arrays;

public class ResultFormatter {
    public static void printResult(Method m, Object[] args, Object result) {
        System.out.println("[TEST] " + m.getName() + "(" + Arrays.toString(args) + ") -> " + result);
    }
}
