package org.elias.testgen;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java -jar universal-test-generator.jar <class-name>");
            return;
        }
        String targetClass = args[0];
        System.out.println("Starte universellen Testcase-Generator für " + targetClass + "...");
        TestcaseGenerator generator = new TestcaseGenerator(targetClass);
        generator.generateAndRunTests();
    }
}

