package InterviewQuestions;

public class IntersectionOfLinkedList {
	public static void main(String[] args) {
		ListNode a1 = new ListNode(3);
		ListNode a2 = new ListNode(4);
		ListNode b1 = new ListNode(2);
		a1.next = a2;
		b1.next = a2;
		System.out.println(getIntersectionNode(a1,b1).val);
	}
	
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null || headB == null) return null;
		if(headA.equals(headB)) return headA;
		ListNode res = null;
		return getNode_r(headA, headB, res);
    }
	
	public static ListNode getNode_r(ListNode headA, ListNode headB, ListNode p) {
		ListNode n1 = headA;
		ListNode n2 = headB;
        while(n1.next != p && n1.next != null) {
        	n1 = n1.next;
        }
        while(n2.next != p && n2.next != null) {
        	n2 = n2.next;
        }
        if(n1.equals(n2)) {
        	p = n1;
        	p = getNode_r(headA, headB, p);
        }
        else {
        	return p;
        }
        return p;
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	    next = null;
	}
}
