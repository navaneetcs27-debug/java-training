import java.util.*;

class Solution {

    public List<TreeNode> generateTrees(int n) {
        return build(1, n);
    }

    private List<TreeNode> build(int start, int end) {

        List<TreeNode> result = new ArrayList<>();

        // No nodes
        if (start > end) {
            result.add(null);
            return result;
        }

        // Try every number as root
        for (int i = start; i <= end; i++) {

            // Generate all possible left subtrees
            List<TreeNode> leftTrees = build(start, i - 1);

            // Generate all possible right subtrees
            List<TreeNode> rightTrees = build(i + 1, end);

            // Combine left and right
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {

                    TreeNode root = new TreeNode(i);

                    root.left = left;
                    root.right = right;

                    result.add(root);
                }
            }
        }

        return result;
    }
}