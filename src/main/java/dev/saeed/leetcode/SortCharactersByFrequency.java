package dev.saeed.leetcode;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SortCharactersByFrequency {

    public static String frequencySort(String s) {
        return Arrays.stream(s.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((item1, item2) -> item2.getValue().compareTo(item1.getValue()))
                .map(entry -> entry.getKey().repeat(entry.getValue().intValue()))
                .collect(Collectors.joining());
    }

    public String frequencySort2(String s) {
        Map<Character, Integer> charCounts = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (charCounts.containsKey(s.charAt(i))) {
                int newCount = charCounts.get(s.charAt(i)) + 1;
                charCounts.put(s.charAt(i), newCount);
            } else {
                charCounts.put(s.charAt(i), 1);
            }
        }
        List<Map.Entry<Character, Integer>> charsCountEntrySet = new ArrayList<>(charCounts.entrySet());
        charsCountEntrySet.sort((item1, item2) -> item2.getValue().compareTo(item1.getValue()));
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Character, Integer> item : charsCountEntrySet) {
            int count = item.getValue();
            Character currentChar = item.getKey();
            result.append(String.valueOf(currentChar).repeat(Math.max(0, count)));
        }
        return result.toString();
    }
}
