package InterviewQuestions;

public class AddTwoNumbers {
	public static void main(String[] s) {
		ListNode l1 = new ListNode(1);
		
		ListNode l2 = new ListNode(9);
		l2.next = new ListNode(9);
		
		ListNode res = addTwoNumbers(l1, l2);
		
		while(res != null) {
			System.out.println(res.val);
			res = res.next;
		}
		
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		
		if(l1 == null && l2 == null) {
            return null;
        }
            
        ListNode head = new ListNode(0);
        ListNode point = head;
        int carry = 0;
        while(l1 != null && l2!=null){
            int sum = carry + l1.val + l2.val;
            point.next = new ListNode(sum % 10);
            carry = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
            point = point.next;
        }
        
        while(l1 != null) {
            int sum =  carry + l1.val;
            point.next = new ListNode(sum % 10);
            carry = sum /10;
            l1 = l1.next;
            point = point.next;
        }
        
        while(l2 != null) {
            int sum =  carry + l2.val;
            point.next = new ListNode(sum % 10);
            carry = sum /10;
            l2 = l2.next;
            point = point.next;
        }
        
        if (carry != 0) {
            point.next = new ListNode(carry);
        }
        return head.next;
	}
}

