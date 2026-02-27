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
    int index=0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0 || (preorder[0]==-1 && inorder[0]==-1)) return new TreeNode(-1);

        index = 0;
        int left = 0;
        int right = preorder.length-1;

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }

        return recurseBuildTree(preorder, inorder, left, right, map);

    }

    public TreeNode recurseBuildTree(int[] preorder, int[] inorder, int left, int right, HashMap<Integer, Integer> map){
        if(left>right) return null;

        int curr = preorder[index];
        index++;

        TreeNode node = new TreeNode(curr);

        if(left==right) return node;

        int currIndex = map.get(curr);

        node.left = recurseBuildTree(preorder, inorder, left, currIndex-1, map);
        node.right = recurseBuildTree(preorder, inorder, currIndex+1, right, map);

        return node;
    }
}