/*
SOF_U1B2 - Pair Programming Lab (40 minutes)
Topic: Java Generics - Generic Interfaces

Names: Alan

Instructions:
- Complete each TODO.
- Run after each TODO chunk to test.
- NO bounds yet (no extends/super on type params).
- Keep solutions simple and readable.

Roles (switch halfway)

Driver: types, runs the code, shares keyboard
Navigator: reads instructions, catches mistakes, explains “why”

0–5 min: Assign roles, create file, run it once (expect TODO failures).
5–20 min: Complete Parts A–C + run tests after each part.
20 min: Switch Driver/Navigator.
20–35 min: Complete Parts D–E.
35–40 min: Clean up: confirm all tests run, add names, push to GitHub.

Each person will turn in a complete copy (make sure ALL work is present).

When finished turn this in on GitHub and Canvas.

This portion is worth 15 points.
*/

public class U1B02Act {

    public static void main(String[] args) {

        System.out.println("\n=== SOF_U1B2 PAIR LAB: GENERIC INTERFACES ===\n");

        // ============================================================
        // PART A (Warm-up): A generic interface with a default method
        // (Goal: implement Formatter<T> + a couple classes)
        // ============================================================

        Formatter<Integer> hex = new IntHexFormatter();
        hex.print(26); // expect 0x1A

        Formatter<String> bracket = new BracketFormatter<>();
        bracket.print("SOF"); // expect [SOF]

        // ============================================================
        // PART B: Generic interface with 2 type parameters
        // (Goal: build Transformer<IN, OUT> + a few implementations)
        // ============================================================

        Transformer<String, Integer> len = new StringLengthTransformer();
        System.out.println(len.transform("robot")); // expect 5

        Transformer<String, String> vip = new AddPrefixTransformer("VIP-");
        System.out.println(vip.transform("Ada")); // expect VIP-Ada

        Transformer<Integer, String> i2s = new IntToStringTransformer();
        System.out.println(i2s.transform(42)); // expect 42

        // ============================================================
        // PART C: Generic interface as a PARAMETER (no collections)
        // (Goal: write utility methods that accept your generic interfaces)
        // ============================================================

        Transformer<String, String> tag = new AddPrefixTransformer("#");
        System.out.println(applyOnce("hello", tag));     // expect #hello
        System.out.println(applyTwice("hi", tag));       // expect ##hi

        Transformer<String, Integer> length = new StringLengthTransformer();
        System.out.println(applyOnce("Katherine", length)); // expect 9

        // ============================================================
        // (SWITCH ROLES HERE)
        // ============================================================

        // ============================================================
        // PART D: Another generic interface + implementations (no collections)
        // (Goal: build Rule<T> and test multiple values)
        // ============================================================

        Rule<String> nonEmpty = new NonEmptyStringRule();
        System.out.println(allPass("Ada", "Grace", "Katherine", nonEmpty)); // expect true
        System.out.println(allPass("Ada", "   ", "Katherine", nonEmpty));   // expect false

        Rule<Integer> even = new EvenIntegerRule();
        System.out.println(allPass(2, 4, 6, even)); // expect true
        System.out.println(allPass(2, 3, 6, even)); // expect false

        Rule<Double> always = new AlwaysTrueRule<>();
        System.out.println(allPass(1.0, 2.5, 999.9, always)); // expect true
    }

    public static <IN, OUT> OUT applyOnce(IN input, Transformer<IN, OUT> transformer) {
        return transformer.transform(input);
    }

    public static <T> T applyTwice(T input, Transformer<T, T> transformer) {
        return transformer.transform(transformer.transform(input));
    }

    public static <T> boolean allPass(T a, T b, T c, Rule<T> rule) {
        return rule.test(a) && rule.test(b) && rule.test(c);
    }
}