package dictionary;

import java.util.HashMap;

public class Dictionary {
    private final HashMap<String, String> words = new HashMap<>();

    public void addWord(String word, String meaning) {
        if (word == null || word.isBlank()) return;
        words.put(word.trim().toLowerCase(), meaning);
    }

    public String findMeaning(String word) {
        if (word == null) return null;
        return words.get(word.trim().toLowerCase());
    }
}
