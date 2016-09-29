package InterviewQuestions;

import java.util.*;

public class DesignHitCounter {
	public class HitCounter {
		Queue<Integer> q = null;
		public HitCounter() {
			q = new LinkedList<Integer>();
		}
		public void hit(int timestamp) {
			q.offer(timestamp);
		}
		public int getHits(int timestamp) {
			while(!q.isEmpty() && timestamp - q.peek() >= 300) {
				q.poll();
			}
			return q.size();
		}
	}
}
