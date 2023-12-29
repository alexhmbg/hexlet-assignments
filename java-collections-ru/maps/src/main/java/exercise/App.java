package exercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// BEGIN
class App {
    public static Map<String, Integer> getWordCount(String sentence) {
        var wordsCount = new HashMap<String, Integer>();
        if (sentence.isEmpty()) {
            return wordsCount;
        }

        var words = sentence.split(" ");
        for (var word : words) {
            var currentCount = wordsCount.getOrDefault(word, 0);
            wordsCount.put(word, currentCount + 1);
        }

        return wordsCount;
    }

    public static String toString(Map<String, Integer> wordsCountMap) {
        if (wordsCountMap.isEmpty()) {
            return "{}";
        }

        String wordsCountStr = "";
        for (var s : wordsCountMap.keySet()) {
                wordsCountStr += "  " + s + ": " + wordsCountMap.get(s) + "\n";
        }

        wordsCountStr = "{\n" + wordsCountStr + "}";

        return wordsCountStr;
    }
}
