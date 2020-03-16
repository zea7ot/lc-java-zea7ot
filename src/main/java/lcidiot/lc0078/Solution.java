/**
 * https://leetcode.com/problems/subsets/
 */

package main.java.lcidiot.lc0078;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        dfs(ans, new ArrayList<Integer>(), nums, 0);
        
        return ans;
    }
    
    private void dfs(List<List<Integer>> ans, 
                     List<Integer> intermediate, 
                     int[] nums, 
                     int startPos){
        ans.add(new ArrayList<Integer>(intermediate));
        
        for(int i = startPos; i < nums.length; i++){
            intermediate.add(nums[i]);
            dfs(ans, intermediate, nums, i + 1);
            intermediate.remove(intermediate.size() - 1);
        }
    }
}