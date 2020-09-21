package leetcode.companies.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Occurrences After Bigram
 * Given words first and second, consider occurrences in some text of the form "first second third", where second comes immediately after first, and third comes immediately after second.
 * <p>
 * For each such occurrence, add "third" to the answer, and return the answer.
 * <p>
 * Example 1:
 * <p>
 * Input: text = "alice is a good girl she is a good student", first = "a", second = "good"
 * Output: ["girl","student"]
 * Example 2:
 * <p>
 * Input: text = "we will we will rock you", first = "we", second = "will"
 * Output: ["we","rock"]
 * <p>
 * Note:
 * <p>
 * 1 <= text.length <= 1000
 * text consists of space separated words, where each word consists of lowercase English letters.
 * 1 <= first.length, second.length <= 10
 * first and second consist of lowercase English letters.
 */
public class FirstSecondThird {

    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        List<String> resList = new ArrayList<>();
        int n = words.length;
        for (int i = 0; i < n; i++) {
            if (first.equals(words[i])) {
                if (i + 1 < n && second.equals(words[i + 1])) {
                    if (i + 2 < n) resList.add(words[i + 2]);
                }
            }
        }
        int m = resList.size();
        String[] result = new String[m];
        for (int i = 0; i < m; i++) result[i] = resList.get(i);
        return result;
    }

    public static void main(String[] args) {
        FirstSecondThird f = new FirstSecondThird();
        System.out.println(Arrays.toString(f.findOcurrences("alice is a good girl she is a good student", "a", "good")));
    }

}
