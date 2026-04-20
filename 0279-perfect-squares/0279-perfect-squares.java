class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n + 1];

        // Initialize with max value
        for (int i = 0; i <= n; i++) {
            dp[i] = i; // worst case: all 1's
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
            }
        }

        return dp[n];
    }
}