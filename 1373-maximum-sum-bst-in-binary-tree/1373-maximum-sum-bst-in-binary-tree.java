class Solution {

    int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int[] dfs(TreeNode root) {
        // {isBST, min, max, sum}
        if (root == null) {
            return new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        // Check BST condition
        if (left[0] == 1 && right[0] == 1 &&
            left[2] < root.val && root.val < right[1]) {

            int sum = left[3] + right[3] + root.val;
            maxSum = Math.max(maxSum, sum);

            int min = Math.min(left[1], root.val);
            int max = Math.max(right[2], root.val);

            return new int[]{1, min, max, sum};
        }

        return new int[]{0, 0, 0, 0};
    }
}