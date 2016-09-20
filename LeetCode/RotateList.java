package InterviewQuestions;

public class RotateList {
	public static void main(String[] args) {
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		a1.next = a2;
		ListNode a = rotateRight(a1, 3);
		while(a != null) {
			System.out.println(a.val);
			a = a.next;
		}
	}
	
	private static int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            length ++;
            head = head.next;
        }
        return length;
    }
	
	public static ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0) return head;
        int length = getLength(head);
        k = k % length;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode preRotate = head;
        for(int i = 0; i < k; i++) {
        	if(head.next == null) return dummy.next;
        	head = head.next;
        }
        
        while(head.next != null) {
        	preRotate = preRotate.next;
        	head = head.next;
        }
        
        head.next = dummy.next;
        dummy.next = preRotate.next;
        preRotate.next = null;
        
        return dummy.next;
        
    }
}
