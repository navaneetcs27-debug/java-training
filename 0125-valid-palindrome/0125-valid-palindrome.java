class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start < end) {
            // Skip non-alphanumeric chars at start
            if (!Character.isLetterOrDigit(s.charAt(start))) {
                start++;
            }
            // Skip non-alphanumeric chars at end
            else if (!Character.isLetterOrDigit(s.charAt(end))) {
                end--;
            }
            // Compare characters
            else {
                if (Character.toLowerCase(s.charAt(start)) !=
                    Character.toLowerCase(s.charAt(end))) {
                    return false;
                }
                start++;
                end--;
            }
        }

        return true;
    }
}