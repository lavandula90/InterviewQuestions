package InterviewQuestions;

import java.util.ArrayDeque;
import java.util.Queue;

public class MovingAverageFromDataStream {
	Queue<Integer> window;
	int sum;
	int size;
	
	public void MovingAverage(int size) {
        this.size = size;
        this.sum = 0;
        this.window = new ArrayDeque<Integer>();
    }
    
    public double next(int val) {
        window.offer(val);
        while(window.size() > size) {
        	sum -= window.poll();
        }
        sum += val;
        return (double)sum / window.size();
    }
}
