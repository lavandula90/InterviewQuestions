package InterviewQuestions;

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
}
