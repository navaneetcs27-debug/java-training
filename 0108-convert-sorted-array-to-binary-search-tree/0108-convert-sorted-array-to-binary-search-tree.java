class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return createTree(nums, 0, nums.length - 1);
    }

    public TreeNode createTree(int[] nums, int left, int right) {

        // Base case
        if (left > right) {
            return null;
        }

        // Find middle
        int mid = left + (right - left) / 2;

        // Create root
        TreeNode root = new TreeNode(nums[mid]);

        // Create left subtree
        root.left = createTree(nums, left, mid - 1);

        // Create right subtree
        root.right = createTree(nums, mid + 1, right);

        return root;
    }
}