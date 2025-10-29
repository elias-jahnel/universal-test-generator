# Universal Testcase Generator ☕️

Ein ironisch übermotiviertes Projekt von Elias Jahnel.  
Ziel: Einen universellen Testcase-Generator zu erschaffen, der jede Java-Klasse automatisch durchreflektiert,
Parameter errät, Rückgabewerte inspiziert und Tests generiert, ohne zu wissen, was er da eigentlich testet.

## Features
- Erzeugt Instanzen per Reflection
- Generiert zufällige Eingabewerte
- Führt öffentliche Methoden aus
- Ignoriert private Methoden (meistens)
- Gibt Ergebnisse formatiert aus

---

## 🚀 Beispiel: Eigene Klasse testen

```bash
# Beispielklasse anlegen
mkdir -p src/main/java/org/example
cat <<'EOF' > src/main/java/org/example/MyClass.java
package org.example;

public class MyClass {
    public int add(int a, int b) { return a + b; }
    public double divide(double x, double y) {
        if (y == 0) throw new IllegalArgumentException("Division durch Null!");
        return x / y;
    }
    public String greet(String name) { return "Hallo, " + name + "!"; }
}
EOF

# Generator starten
mvn clean compile exec:java -Dexec.mainClass="org.elias.testgen.Main"

Der Generator erzeugt automatisch Testeingaben, führt alle öffentlichen Methoden aus und gibt die Ergebnisse in der Konsole aus.

Beispielausgabe:

Analysiere org.example.MyClass...
[TEST] add([17, 42]) -> 59
[TEST] divide([5.6, 0.2]) -> 28.0
[TEST] greet([AutoGen_123]) -> Hallo, AutoGen_123!

Lizenz

MIT – weil Chaos geteilt werden sollte.
EOF


---

### 🧩 4. Bonus: Selbsttest-Variante
Wenn du’s ganz meta willst:  
Ersetz im `Main.java` einfach `org.example.MyClass` durch `org.elias.testgen.TestcaseGenerator`.  
Dann testet der Generator sich selbst.  
Ergebnis: philosophische Leere und vermutlich ein Stacktrace, der Nietzsche hätte gefallen.

---
