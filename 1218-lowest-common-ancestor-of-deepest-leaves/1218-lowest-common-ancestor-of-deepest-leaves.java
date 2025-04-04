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
    int max=0;
    TreeNode lca;
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        findDepth(root,0);
        return lca;
    }
    public int findDepth(TreeNode node,int d){
        if (node==null) return d;
        int dleft=findDepth(node.left,d+1);
        int dright=findDepth(node.right,d+1);
        max=Math.max(max,Math.max(dleft,dright));
        if(dleft==max && dright==max){
             lca=node;
        }
        return Math.max(dleft,dright);
    }
}