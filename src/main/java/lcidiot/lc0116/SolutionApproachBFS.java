/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */
package main.java.lcidiot.lc0116;

import java.util.LinkedList;
import java.util.Queue;

import main.java.lcidiot.data_structure.tree.TreeNodeWithNextPtr;

class SolutionApproachBFS {
    public TreeNodeWithNextPtr connect(TreeNodeWithNextPtr root) {
        if(root == null) return root;
        
        Queue<TreeNodeWithNextPtr> queue = new LinkedList<TreeNodeWithNextPtr>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNodeWithNextPtr node = queue.poll();
                if(i < size - 1) node.next = queue.peek();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }
        
        return root;
    }
}