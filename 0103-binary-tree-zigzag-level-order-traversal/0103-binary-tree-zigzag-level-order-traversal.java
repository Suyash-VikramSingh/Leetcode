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
    public int height(TreeNode root){
        if(root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }
    public void nthLevel(TreeNode root, int l, int dir, List<Integer> ans){
        if(root == null) return;

        if(l == 0){
            ans.add(root.val);
            return;
        }

        l--;

        if(dir == 1){
            nthLevel(root.left, l, dir, ans);
            nthLevel(root.right, l, dir, ans);
        }
        else{
            nthLevel(root.right, l, dir, ans);
            nthLevel(root.left, l, dir, ans);
        }
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        int dir = 1;
        int level = height(root);

        for(int i = 0; i < level; i++){
            List<Integer> l = new ArrayList<>();

            nthLevel(root, i, dir, l);

            ans.add(l);

            dir ^= 1;
        }

        return ans;
    }
}