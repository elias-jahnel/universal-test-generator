package org.elias.testgen;

import java.lang.reflect.*;

public class TestcaseGenerator {
    private final Class<?> target;

    public TestcaseGenerator(String className) {
        try {
            this.target = Class.forName(className);
        } catch (Exception e) {
            throw new RuntimeException("Unbekannte Klasse: " + className);
        }
    }

    public void generateAndRunTests() {
        System.out.println("Analysiere " + target.getName() + "...");
        Object instance = ReflectionHelper.instantiate(target);

        for (Method m : target.getDeclaredMethods()) {
            if (Modifier.isPublic(m.getModifiers()) && m.getReturnType() != void.class) {
                Object[] args = ReflectionHelper.mockArgs(m.getParameterTypes());
                Object result = ReflectionHelper.invoke(m, instance, args);
                ResultFormatter.printResult(m, args, result);
            }
        }
    }
}
