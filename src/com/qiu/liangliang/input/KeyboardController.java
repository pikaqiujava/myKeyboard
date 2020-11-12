package com.qiu.liangliang.input;

import java.util.*;

public class KeyboardController {

    public static void main(String[] args) {
        // Play 10 times
        for (int i = 0; i < 10; i++){
            Scanner scanner = new Scanner(System.in);
            System.out.print("input: ");
            BuildCombination buildCombination = new BuildCombination();
            List<String> list = buildCombination.getCombination(scanner.next());
            System.out.println("out put: " + list.toString());
        }
    }
}

class BuildCombination{

    // Initialization Data
    private Map<String, String> map = new HashMap<String, String>() {{
        put("0", "");
        put("1", "");
        put("2", "ABC");
        put("3", "DEF");
        put("4", "GHI");
        put("5", "JKL");
        put("6", "MNO");
        put("7", "PQRS");
        put("8", "TUV");
        put("9", "WXYZ");
        put("#", "");
        put("*", "");
    }};
    // Response Body
    private List<String> result = new ArrayList<>();

    public List<String> getCombination(String digits) {
        if (digits.length() > 0) {
            buildLetter("", digits);
        }
        return result;
    }

    public void buildLetter(String combination, String next) {
        if (next.length() == 0) {
            result.add(combination);
        } else {
            // combination
            String substring = next.substring(0, 1);
            String letters = map.get(substring);
            if (!"".equals(letters)){  // Can Be Deleted Without Compensation
                for (int i = 0; i < letters.length(); i++) {
                    // recursive
                    buildLetter(combination + letters.substring(i, i + 1), next.substring(1));
                }
            }else {
                // compensation (situation: null + letter)
                buildLetter("", next.substring(1));
            }
        }
    }
}
