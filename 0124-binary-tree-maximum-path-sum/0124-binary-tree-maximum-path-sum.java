/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        
        int[] maxVal = {root.val};

        maxSum(root, maxVal);

        return maxVal[0];
    }

    public int maxSum(TreeNode root, int[] maxVal){
        if(root == null) return 0;

        int left = maxSum(root.left, maxVal);
        int right = maxSum(root.right, maxVal);

        maxVal[0] = Math.max(maxVal[0], root.val);
        maxVal[0] = Math.max(maxVal[0], root.val + left);
        maxVal[0] = Math.max(maxVal[0], root.val + right);
        maxVal[0] = Math.max(maxVal[0], root.val + left + right);

        return Math.max(root.val , Math.max(root.val + left, root.val + right));
    }
}