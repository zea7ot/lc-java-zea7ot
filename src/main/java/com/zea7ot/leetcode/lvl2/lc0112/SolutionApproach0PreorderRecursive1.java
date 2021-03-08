/**
 * https://leetcode.com/problems/path-sum/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(H)
 */
package com.zea7ot.leetcode.lvl2.lc0112;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach0PreorderRecursive1 {
    public boolean hasPathSumRecursion(TreeNode root, int sum) {
        if (root == null)
            return false;

        sum -= root.val;
        if (root.left == null && root.right == null)
            return sum == 0;

        return hasPathSumRecursion(root.left, sum) || hasPathSumRecursion(root.right, sum);
    }
}