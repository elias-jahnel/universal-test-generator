package org.elias.testgen;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starte universellen Testcase-Generator...");
        TestcaseGenerator generator = new TestcaseGenerator("org.example.MyClass");
        generator.generateAndRunTests();
    }
}
