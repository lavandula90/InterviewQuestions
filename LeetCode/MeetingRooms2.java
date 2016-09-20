package InterviewQuestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRooms2 {
	public static void main(String[] args) {
		Interval a = new Interval();
		a.start = 0;
		a.end = 30;
		Interval b = new Interval();
		b.start = 5;
		b.end = 10;
		Interval c = new Interval();
		c.start = 15;
		c.end = 20;
		Interval[] intervals = {a, b, c};
		System.out.println(minMeetingRooms(intervals));
		
	}
	public static int minMeetingRooms(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
        	public int compare(Interval a, Interval b) {return a.start - b.start;}
        });
        
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {
        	public int compare(Interval a, Interval b) {return a.end - b.end;}
        });
        
        pq.offer(intervals[0]);
        for(int i = 1; i < intervals.length; i++) {
        	Interval interval = pq.poll();
        	if(intervals[i].start >= interval.end) {
        		interval.end = intervals[i].end;
        	}
        	else {
        		pq.offer(intervals[i]);
        	}
        	pq.offer(interval);
        }
        return pq.size();
    }
}
