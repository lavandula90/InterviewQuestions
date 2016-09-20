package InterviewQuestions;

public class RemoveNthNodeFromEndofList {
	public static void main(String[] args) {
		
	}
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if(head == null || n < 0) return head;
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode preDeleted = dummy;
		
		for(int i = 0; i < n; i++) {
			if(head == null) return null;
			head = head.next;
		}
		
		while(head != null) {
			head = head.next;
			preDeleted = preDeleted.next;
		}
		
		preDeleted.next = preDeleted.next.next;
		
		return dummy.next;
        
    }
}
