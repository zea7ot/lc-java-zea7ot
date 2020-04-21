/**
 * https://leetcode.com/problems/symmetric-tree/
 */
package main.java.lcidiot.lc0101;

import java.util.LinkedList;
import java.util.Queue;

import main.java.lcidiot.data_structure.tree.TreeNode;

class SolutionApproachInteration {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        queue.add(root);
        
        while(!queue.isEmpty()){
            TreeNode n1 = queue.poll();
            TreeNode n2 = queue.poll();
            
            if(n1 == null && n2 == null) continue;
            else if(n1 == null || n2 == null || n1.val != n2.val) return false;
            
            queue.add(n1.left);
            queue.add(n2.right);
            queue.add(n1.right);
            queue.add(n2.left);
        }
        
        return true;
    }
}