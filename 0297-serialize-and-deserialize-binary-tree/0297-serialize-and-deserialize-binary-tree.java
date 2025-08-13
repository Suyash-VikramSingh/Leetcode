/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        StringBuilder str = new StringBuilder();

        while(!q.isEmpty()){
            int n = q.size();
            for(int i = 0; i < n; i++){
                TreeNode node = q.poll();

                if(node == null) str.append("#,");
                else {
                    str.append(Integer.toString(node.val) +",");

                    if(node.left != null) q.offer(node.left);
                    else q.offer(null);

                    if(node.right != null) q.offer(node.right);
                    else q.offer(null);
                }
            }
        }

        str.deleteCharAt(str.length() - 1);

        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;

        String[] str = data.split(",");

        TreeNode root = new TreeNode(Integer.valueOf(str[0]));

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int idx = 1;

        while(!q.isEmpty()){
            int n = q.size();
            for(int i = 0; i < n; i++){
                TreeNode node = q.poll();

                if(!str[idx].equals("#")){
                    TreeNode l = new TreeNode(Integer.valueOf(str[idx]));
                    node.left = l;
                    q.offer(l);
                }
                // else    
                //     node.left = null;
                idx++;

                if(!str[idx].equals("#")){
                    TreeNode r = new TreeNode(Integer.valueOf(str[idx]));
                    node.right = r;
                    q.offer(r);
                }
                // else
                //     node.right = null;
                idx++;
            }
        }

        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));