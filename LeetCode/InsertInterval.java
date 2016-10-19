package InterviewQuestions;
import java.util.*;

class Interval {
	 int start;
     int end;
	 Interval() { start = 0; end = 0; }
	 Interval(int s, int e) { start = s; end = e; }
}

public class InsertInterval {
	public static void main(String[] argv) {
		Interval interval1 = new Interval(3,5);
		Interval interval2 = new Interval(12,15);
		Interval newInterval = new Interval(6,6);
		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(interval1);
		intervals.add(interval2);
		List<Interval> result = insert(intervals, newInterval);
		for(int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i).start + " " + result.get(i).end);
		}
	}
	
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int size = intervals.size();
        int merge_start = 0;
        int merge_end = 0;
        int i;
        
        if(size == 1) {
        	if(newInterval.start > intervals.get(0).end) {
        		intervals.add(newInterval);
        		return intervals;
        	}
        	else if(newInterval.end < intervals.get(0).start) {
        		intervals.add(0, newInterval);
        		return intervals;
        	}
        	else {
        		if(newInterval.start < intervals.get(0).start) intervals.get(0).start = newInterval.start;
        		if(newInterval.end > intervals.get(0).end) intervals.get(0).end = newInterval.end;
        		return intervals;
        	}
        }
        
        for(i = 0; i < size; i++) {
            if(intervals.get(i).end >= newInterval.start) {
                merge_start = i;
                break;
            }
        }
        if(i == size) {
        	intervals.add(newInterval);
        	return intervals;
        }
        for(i = 0; i < size; i++) {
            if(intervals.get(i).start > newInterval.end) {
                merge_end = i-1;
                break;
            }
        }
        if(merge_end == -1) {
        	intervals.add(0,newInterval);
        	return intervals;
        }
        else if(i == size) {
        	merge_end = size-1;
        }
        if(merge_start > merge_end) {
        	intervals.add(merge_start, newInterval);
        	return intervals;
        }
        if(newInterval.start > intervals.get(merge_start).start) newInterval.start = intervals.get(merge_start).start;
        if(newInterval.end < intervals.get(merge_end).end) newInterval.end = intervals.get(merge_end).end;
        for(i=merge_start; i < merge_end-merge_start+1; i++) {
            intervals.remove(merge_start);
        }
        intervals.get(merge_start).start = newInterval.start;
        intervals.get(merge_start).end = newInterval.end;
        return intervals;
    }
	
	public List<Interval> insert2(List<Interval> intervals, Interval newInterval) {
        int i = 0;
        while(i < intervals.size() && intervals.get(i).end < newInterval.start) i++;
        while(i < intervals.size() && intervals.get(i).start <= newInterval.end){
            newInterval = new Interval(Math.min(intervals.get(i).start, newInterval.start), Math.max(intervals.get(i).end, newInterval.end));
            intervals.remove(i);
        }
        intervals.add(i,newInterval);
        return intervals;
    }
}
