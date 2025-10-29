package org.elias.testgen;

import java.lang.reflect.*;
import java.util.Random;

public class ReflectionHelper {

    public static Object instantiate(Class<?> cls) {
        try {
            return cls.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            System.out.println("Kann " + cls.getName() + " nicht instanziieren: " + e.getMessage());
            return null;
        }
    }

    public static Object[] mockArgs(Class<?>[] params) {
        Random r = new Random();
        Object[] args = new Object[params.length];
        for (int i = 0; i < params.length; i++) {
            Class<?> p = params[i];
            if (p == int.class) args[i] = r.nextInt(100);
            else if (p == double.class) args[i] = r.nextDouble();
            else if (p == String.class) args[i] = "AutoGen_" + r.nextInt(1000);
            else args[i] = null;
        }
        return args;
    }

    public static Object invoke(Method m, Object instance, Object[] args) {
        try {
            m.setAccessible(true);
            return m.invoke(instance, args);
        } catch (Exception e) {
            System.out.println("Fehler beim Aufruf von " + m.getName() + ": " + e.getMessage());
            return null;
        }
    }
}
