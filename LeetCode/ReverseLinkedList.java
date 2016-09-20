package InterviewQuestions;

public class ReverseLinkedList {
	public static void main(String[] args) {
		
	}
	
	public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        ListNode prev = null;
        while(head != null) {
        	ListNode tmp = head.next;
        	head.next = prev;
        	prev = head;
        	head = tmp;		
        }
        return prev;
    }
}
