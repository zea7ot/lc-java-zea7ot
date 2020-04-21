package main.java.lcidiot.lc0987;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import main.java.lcidiot.data_structure.tree.TreeNode;

import java.util.PriorityQueue;

public class Solution {
    private Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new HashMap<>();
    private int minX = 0, maxX = 0;
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        helper(root, 0, 0);
        List<List<Integer>> vertical = new ArrayList<List<Integer>>();
        for(int i = minX; i <= maxX; i++){
            List<Integer> level = new ArrayList<Integer>();
            for(int key : map.get(i).keySet()){
                while(!(map.get(i).get(key)).isEmpty()){
                    level.add(map.get(i).get(key).poll());
                }
            }
            
            vertical.add(level);
        }
        
        return vertical;
    }
    
    private void helper(TreeNode node, int x, int y){
        if(node == null) return;
        minX = Math.min(minX, x);
        maxX = Math.max(maxX, x);
        if(map.get(x) == null){
            map.put(x, new TreeMap<Integer, PriorityQueue<Integer>>());
        }
        if(map.get(x).get(y) == null){
            map.get(x).put(y, new PriorityQueue<Integer>());
        }
        map.get(x).get(y).add(node.val);
        helper(node.left, x - 1, y + 1);
        helper(node.right, x + 1, y + 1);
    }
}