package InterviewQuestions;

import java.util.Random;

public class LinkedListRandomNode {
	
	ListNode head = null;
	Random random = new Random();
	/** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
	public void Solution(ListNode head) {
		this.head = head;
	}

	/** Returns a random node's value. */
	public int getRandom() {
		ListNode cur = head;
		ListNode rst = null;
		for(int i = 1; cur != null; i++) {
			if(random.nextInt(i) == 0) rst = cur;
			cur = cur.next;
		}
		return rst.val;
	}
}
