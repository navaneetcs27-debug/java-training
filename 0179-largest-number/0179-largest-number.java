import java.util.*;

class Solution {
    public String largestNumber(int[] nums) {

        // Convert int[] to String[]
        String[] arr = new String[nums.length];

        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        // Custom sorting
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));

        // If the largest number is 0
        if (arr[0].equals("0")) {
            return "0";
        }

        // Build answer
        StringBuilder result = new StringBuilder();

        for (String s : arr) {
            result.append(s);
        }

        return result.toString();
    }
}