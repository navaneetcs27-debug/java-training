class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> ans = new ArrayList<>();

        postorder(root, ans);

        return ans;
    }

    void postorder(TreeNode root, List<Integer> ans) {

        if (root == null) {
            return;
        }

        // Left
        postorder(root.left, ans);

        // Right
        postorder(root.right, ans);

        // Root
        ans.add(root.val);
    }
}