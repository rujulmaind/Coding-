import java.util.*;

class Solution {
    public List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s.toCharArray(), 0, result);
        return result;
    }

    private void backtrack(char[] s, int index, List<String> result) {
        if (index == s.length) {
            result.add(new String(s));
            return;
        }

        if (Character.isLetter(s[index])) {
            s[index] = Character.toLowerCase(s[index]);
            backtrack(s, index + 1, result);

            s[index] = Character.toUpperCase(s[index]);
            backtrack(s, index + 1, result);
        } else {
            backtrack(s, index + 1, result);
        }
    }
}