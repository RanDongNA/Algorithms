Binary Tree Preorder Traversal
Given a binary tree, return the preorder traversal of its nodes' values.

For example:
 Given binary tree {1,#,2,3},



/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    // Can i solve this using that tricky solution in CS610?
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList al = new ArrayList();
        TreeNode lastNode;
        int flag = 0; // 0 then go left, 1 then go right
        lastNode = root;
        al.add(root.val);
        while(root.left != null && root.right != null){
            lastNode = root;
            root = root.left;
            al.add(root.val);
        }
        
        
        return al;
    }
    