/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 */
package main.java.lcidiot.lc0138;

import java.util.HashMap;
import java.util.Map;

import main.java.lcidiot.data_structure.linkedlist.ListNodeWithRandomPtr;

class SolutionApproachTwoPassesWithHashMap {
    public ListNodeWithRandomPtr copyRandomList(ListNodeWithRandomPtr head) {
        if(head == null) return null;
        
        Map<ListNodeWithRandomPtr, ListNodeWithRandomPtr> map = new HashMap<ListNodeWithRandomPtr, ListNodeWithRandomPtr>();
        
        // 1st pass: to copy all the nodes
        ListNodeWithRandomPtr node = head;
        while(node != null){
            map.put(node, new ListNodeWithRandomPtr(node.val));
            node = node.next;
        }
        
        // 2nd pass: to assign next and random pointers
        node = head;
        while(node != null){
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        
        return map.get(head);
    }
}