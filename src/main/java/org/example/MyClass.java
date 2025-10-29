package org.example;

public class MyClass {

    public int add(int a, int b) {
        return a + b;
    }

    public double divide(double x, double y) {
        if (y == 0) throw new IllegalArgumentException("Division durch Null? Ernsthaft?");
        return x / y;
    }

    public String greet(String name) {
        return "Hallo, " + name + "!";
    }

    private String secretSauce() {
        return "Das solltest du gar nicht sehen.";
    }
}
