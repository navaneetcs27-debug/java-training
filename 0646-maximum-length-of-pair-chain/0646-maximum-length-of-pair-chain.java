import java.util.Arrays;

class Solution {
    public int findLongestChain(int[][] pairs) {

        Arrays.sort(pairs, (a, b) -> Integer.compare(a[1], b[1]));

        int count = 0;
        int lastEnd = Integer.MIN_VALUE;

        for (int[] pair : pairs) {
            if (pair[0] > lastEnd) {
                count++;
                lastEnd = pair[1];
            }
        }

        return count;
    }
}