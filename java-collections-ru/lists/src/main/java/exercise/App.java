package exercise;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

// BEGIN
class App {
    public static boolean scrabble(String letters, String word) {
        String[] lettersArr = letters.split("");
        String[] wordLettersArr = word.split("");
        List<String> lettersList = new ArrayList<>(Arrays.asList(lettersArr));
        List<String> wordLettersList = new ArrayList<>(Arrays.asList(wordLettersArr));

        for (var i = 0; i < word.length(); i++) {
            var wordLetter = wordLettersList.get(i).toLowerCase();
            var checkLetter = lettersList.remove(wordLetter);

            if (!checkLetter) {
                return false;
            }
        }

        return true;
    }
}
//END
