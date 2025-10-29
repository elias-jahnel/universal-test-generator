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
        if (p == int.class || p == Integer.class) args[i] = r.nextInt(100);
        else if (p == double.class || p == Double.class) args[i] = r.nextDouble();
        else if (p == boolean.class || p == Boolean.class) args[i] = r.nextBoolean();
        else if (p == String.class) args[i] = "AutoGen_" + r.nextInt(1000);
        else args[i] = null;
    }
    return args;
}

public static Object invoke(Method m, Object instance, Object[] args) {
    try {
        m.setAccessible(true);
        return m.invoke(instance, args);
    } catch (InvocationTargetException e) {
        System.out.println("[ERROR] " + e.getTargetException().getMessage());
        return null;
    } catch (Exception e) {
        System.out.println("[ERROR] " + e.getMessage());
        return null;
    }
}
}
