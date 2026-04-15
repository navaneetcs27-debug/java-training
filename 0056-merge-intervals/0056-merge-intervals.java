import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        // Step 1: sort by start
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        List<int[]> result = new ArrayList<>();
        
        for (int[] interval : intervals) {
            // If no overlap
            if (result.isEmpty() || result.get(result.size() - 1)[1] < interval[0]) {
                result.add(interval);
            } 
            // Overlap → merge
            else {
                result.get(result.size() - 1)[1] = 
                    Math.max(result.get(result.size() - 1)[1], interval[1]);
            }
        }
        
        return result.toArray(new int[result.size()][]);
    }
}