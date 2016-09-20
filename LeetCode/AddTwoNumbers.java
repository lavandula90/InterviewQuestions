package InterviewQuestions;

public class AddTwoNumbers {
	public static void main(String[] s) {
		ListNode1 l1 = new ListNode1(1);
		
		ListNode1 l2 = new ListNode1(9);
		l2.next = new ListNode1(9);
		
		ListNode1 res = addTwoNumbers(l1, l2);
		
		while(res != null) {
			System.out.println(res.val);
			res = res.next;
		}
		
	}
	
	public static ListNode1 addTwoNumbers(ListNode1 l1, ListNode1 l2) {
		
		if(l1 == null && l2 == null) return null;
		else if(l1 == null) return l2;
		else if(l2 == null) return l1;
		
		int flag = 0;
		int sum = l1.val + l2.val;
		ListNode1 result = new ListNode1(sum % 10);
		ListNode1 res = result;
		if ( sum >= 10 ) flag = sum / 10;
		
		l1 = l1.next;
		l2 = l2.next;
		
		while(l1 != null && l2 != null) {
			sum = l1.val + l2.val + flag;
			result.next = new ListNode1(sum % 10);
			if ( sum >= 10 ) flag = sum / 10;
			else flag = 0;
			l1 = l1.next;
			l2 = l2.next;
			result = result.next;
		}
		
		if ( l1 != null) {
			while( l1 != null ) {
				sum = l1.val + flag;
				result.next = new ListNode1(sum % 10);
				if ( sum >= 10 ) flag = sum / 10;
				else flag = 0;
				l1 = l1.next;
				result = result.next;
			}
			
		}
		
		else if ( l2 != null) {
			while( l2 != null ) {
				sum = l2.val + flag;
				result.next = new ListNode1(sum % 10);
				if ( sum >= 10 ) flag = sum / 10;
				else flag = 0;
				l2 = l2.next;
				result = result.next;
			}
		}
		
		if ( flag != 0 ) result.next = new ListNode1(flag); 
		
		return res;
	}
}

class ListNode1 {
	int val;
	ListNode1 next;
	ListNode1(int x) { val = x; }
}

