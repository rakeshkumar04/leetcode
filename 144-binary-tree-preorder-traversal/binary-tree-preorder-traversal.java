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
    List<Integer> traversalList;
    public List<Integer> preorderTraversal(TreeNode root) {
        traversalList = new ArrayList<>();
        traversal(root, traversalList);
        return traversalList;
    }

    public void traversal(TreeNode node, List<Integer> preorderList){
        if(node == null){
            return;
        }

        preorderList.add(node.val);
        traversal(node.left, preorderList);
        traversal(node.right, preorderList);
    }
}