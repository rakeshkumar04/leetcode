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
    public boolean isBalanced(TreeNode root) {
        return dfsHeight(root) != -1;
    }

    public int dfsHeight(TreeNode node){
        if(node==null) return 0;

        int leftH = dfsHeight(node.left);
        int rightH = dfsHeight(node.right);

        if(leftH == -1 || rightH == -1) return -1;
        if(Math.abs(rightH - leftH)>1) return -1;

        return 1 + Math.max(leftH, rightH);
    }
}