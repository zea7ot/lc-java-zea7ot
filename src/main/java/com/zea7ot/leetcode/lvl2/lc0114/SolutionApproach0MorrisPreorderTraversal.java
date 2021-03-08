/**
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 * 
 * Time Complexity:     O(N)
 * Space Complexity:    O(1)
 * 
 * References:
 *  https://www.youtube.com/watch?v=wGXB9OWhPTg
 *  https://github.com/mission-peace/interview/blob/master/src/com/interview/tree/MorrisTraversal.java  
 */
package com.zea7ot.leetcode.lvl2.lc0114;

import java.util.ArrayList;
import java.util.List;

import com.zea7ot.util.data_structure.tree.TreeNode;

public class SolutionApproach0MorrisPreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        // sanity check
        if(root == null) return ans;
        
        TreeNode cur = root;
        while(cur != null){
            if(cur.left == null){
                ans.add(cur.val);
                cur = cur.right;
            }else{
                TreeNode predecessor = cur.left;
                while(predecessor.right != cur && predecessor.right != null)
                    predecessor = predecessor.right;
                
                if(predecessor.right == null){
                    predecessor.right = cur;
                    ans.add(cur.val);
                    cur = cur.left;
                }else{
                    predecessor.right = null;
                    cur = cur.right;
                }
            }
        }
        
        return ans;
    }
}