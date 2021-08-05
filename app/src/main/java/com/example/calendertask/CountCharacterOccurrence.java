package com.example.calendertask;

import java.util.HashMap;
import java.util.Map;

public class CountCharacterOccurrence {
    private String countChar(String inputStr) {
        Map<Character, Integer> map = new HashMap<>();
        String result = "";
        // search count of characters
        for (char i : inputStr.toCharArray()) {
            if (map.containsKey(i)) {
                int x = map.get(i);
                map.put(i, ++x);
            } else {
                map.put(i, 1);
            }
        }
        // for display count result
        for (char c : map.keySet()) {
            String string = "" + c;
            result = result + (string.toUpperCase() + "" + map.get(c));
        }
        return result;
    }
}
