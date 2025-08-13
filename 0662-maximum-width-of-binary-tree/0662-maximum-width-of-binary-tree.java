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
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        Map<TreeNode, Integer> index = new HashMap<>();
        index.put(root, 0);

        int ans = 1;

        while(!q.isEmpty()){
            int n = q.size();

            int st = 0;
            int end = 0;

            for(int i = 0; i < n; i++){
                TreeNode temp = q.remove();
                int idx = index.get(temp) - 1;

                if(i == 0) st = idx;
                if(i == n - 1) end = idx;

                if(temp.left != null){
                    q.add(temp.left);

                    int pos = 2 * idx + 1;

                    index.put(temp.left, pos);
                }

                if(temp.right != null){
                    q.add(temp.right);

                    int pos = 2 * idx + 2;

                    index.put(temp.right, pos);
                }
            }

            ans = Math.max(ans, end-st+1);
        }

        return ans;
    }
}