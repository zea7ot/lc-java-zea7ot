/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 * 
 * a bottom-up approach
 */
package com.an7one.leetcode.lvl3.lc0236;

import com.an7one.util.data_structure.tree.TreeNode;

public class SolutionApproach0DFSRecursive2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null)
            return right;
        else if (right == null)
            return left;
        else
            return root;
    }
}