package InterviewQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeInterval {
	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<Interval>();
		Interval a = new Interval(1, 3);
		Interval b = new Interval(2, 6);
		Interval c = new Interval(8, 10);
		Interval d = new Interval(15, 18);
		intervals.add(a);
		intervals.add(b);
		intervals.add(c);
		intervals.add(d);
		System.out.print(merge(intervals));
	}
	public static List<Interval> merge(List<Interval> intervals) {
        if(intervals == null || intervals.size() <= 1) return intervals;
        Collections.sort(intervals, new IntervalComparator()); 
        List<Interval> rst = new ArrayList<Interval>();
        Interval last = intervals.get(0);
        for(int i = 0; i < intervals.size(); i++) {
        	Interval cur = intervals.get(i);
        	if(cur.start <= last.end) {
        		last.end = Math.max(cur.end, last.end);
        	}
        	else {
        		rst.add(last);
        		last = cur;
        	}
        }
        
        rst.add(last);
        return rst;
    }
	
	private static class IntervalComparator implements Comparator<Interval> {
        public int compare(Interval a, Interval b) {
            return a.start - b.start;
        }
    }
}
