package InterviewQuestions;

import java.util.*;

public class MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        return mergeHelper(lists, 0, lists.length - 1);
    }
	
	public static ListNode mergeHelper(ListNode[] lists, int start, int end) {
		if(start == end) return lists[start];
		int mid = start + (end - start) / 2;
		ListNode left = mergeHelper(lists, start, mid);
		ListNode right = mergeHelper(lists, mid + 1, end);
		return mergeTwoLists(left, right);
	}
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode lastNode = dummy;
		
		while(l1 != null && l2 != null) {
			if(l1.val < l2.val) {
				lastNode.next = l1;
				l1 = l1.next;
			}
			else  {
				lastNode.next = l2;
				l2 = l2.next;
			}
			lastNode = lastNode.next;
		}
		
		if(l1 != null) {
			lastNode.next = l1;
		}
		else {
			lastNode.next = l2;
		}	
		return dummy.next;
    }
	
	//PriorityQueue
	public ListNode mergeKLists(List<ListNode> lists) {
        if (lists==null||lists.size()==0) return null;
        
        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.size(),new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else 
                    return 1;
            }
        });
        
        ListNode dummy = new ListNode(0);
        ListNode tail=dummy;
        
        for (ListNode node:lists)
            if (node!=null)
                queue.add(node);
            
        while (!queue.isEmpty()){
            tail.next=queue.poll();
            tail=tail.next;
            
            if (tail.next!=null)
                queue.add(tail.next);
        }
        return dummy.next;
    }
}
