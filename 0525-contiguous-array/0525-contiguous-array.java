import java.util.*;

class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int sum = 0;
        int maxLen = 0;
        
        map.put(0, -1); // important
        
        for (int i = 0; i < nums.length; i++) {
            // convert
            if (nums[i] == 0) sum -= 1;
            else sum += 1;
            
            if (map.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }
        
        return maxLen;
    }
}