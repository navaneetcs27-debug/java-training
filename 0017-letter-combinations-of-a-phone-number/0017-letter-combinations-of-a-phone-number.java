class Solution {

    String[] keypad = {
        "", "", "abc", "def", "ghi",
        "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits.length() == 0) {
            return result;
        }

        backtrack(digits, 0, "", result);

        return result;
    }

    public void backtrack(
        String digits,
        int index,
        String current,
        List<String> result
    ) {

        // Base case
        if (index == digits.length()) {
            result.add(current);
            return;
        }

        // Get current digit
        int digit = digits.charAt(index) - '0';

        // Get letters for that digit
        String letters = keypad[digit];

        // Try every letter
        for (int i = 0; i < letters.length(); i++) {

            char ch = letters.charAt(i);

            // Add letter
            backtrack(
                digits,
                index + 1,
                current + ch,
                result
            );
        }
    }
}