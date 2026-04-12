import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;

        String[] map = {
            "", "", "abc", "def", "ghi", "jkl",
            "mno", "pqrs", "tuv", "wxyz"
        };

        backtrack(res, digits, map, 0, new StringBuilder());
        return res;
    }

    private void backtrack(List<String> res, String digits, String[] map, int index, StringBuilder current) {
        if (index == digits.length()) {
            res.add(current.toString());
            return;
        }

        String letters = map[digits.charAt(index) - '0'];
        for (char c : letters.toCharArray()) {
            current.append(c);
            backtrack(res, digits, map, index + 1, current);
            current.deleteCharAt(current.length() - 1);
        }
    }
}