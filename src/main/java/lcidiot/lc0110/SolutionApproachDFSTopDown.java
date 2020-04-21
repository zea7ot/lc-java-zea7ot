/**
 * https://leetcode.com/problems/balanced-binary-tree/
 * 
 * https://leetcode.com/problems/balanced-binary-tree/discuss/35691/The-bottom-up-O(N)-solution-would-be-better
 * 
 * Time Complexity: O(NlogN)
 * https://leetcode.com/problems/balanced-binary-tree/discuss/35691/The-bottom-up-O(N)-solution-would-be-better/33948
 * 
 * Master Theorem:
 * https://en.wikipedia.org/wiki/Master_theorem_(analysis_of_algorithms)
 */
package main.java.lcidiot.lc0110;

import main.java.lcidiot.data_structure.tree.TreeNode;

class SolutionApproachDFSTopDown {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        
        return Math.abs(height(root.left) - height(root.right)) < 2
            && isBalanced(root.left)
            && isBalanced(root.right);
    }
    
    private int height(TreeNode root){
        if(root == null) return -1;
        
        return 1 + Math.max(height(root.left), height(root.right));
    }
}