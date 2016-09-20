package InterviewQuestions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class EvaluateDivision {
	public static void main(String[] args) {
		String[] equation1 = {"a", "b"};
		String[] equation2 = {"c", "d"};
		String[][] equations = {equation1, equation2};
		
		double[] values = {1.0, 1.0};
		
		String[] query1 = {"a", "c"};
		String[] query2 = {"b", "d"};
		String[] query3 = {"b", "a"};
		String[] query4 = {"d", "c"};
		
		String[][] queries = {query1, query2, query3, query4};
		
		double[] result = calcEquation(equations, values, queries);
		
		System.out.print(result);
	}
	public static double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Integer> words = new HashMap<String, Integer>();
        int num = 0;
        for(String[] equation: equations) {
        	if(!words.containsKey(equation[0])) {
        		words.put(equation[0], num++);
        	}
        	if(!words.containsKey(equation[1])) {
        		words.put(equation[1], num++);
        	}
        }
        
        Double[][] graph = new Double[num][num];
        for(int i = 0; i < equations.length; i++) {
        	int num1 = words.get(equations[i][0]);
        	int num2 = words.get(equations[i][1]);
        	if(values[i] != 0) {
        		graph[num2][num1] = 1/values[i];
        	}
        	graph[num1][num2] = values[i];
        	graph[num1][num1] = 1.0;
        	graph[num2][num2] = 1.0;
        }
        
        double[] rst = new double[queries.length];
        for(int i = 0; i < queries.length; i++) {
        	if(!words.containsKey(queries[i][0]) || !words.containsKey(queries[i][1])) {
        		rst[i] = -1.0;
        	}
        	else {
        		int start = words.get(queries[i][0]);
            	int end = words.get(queries[i][1]);
            	rst[i] = cal(graph, start, end);
        	}
        }
        return rst;
    }
	
	public static double cal(Double[][] graph, int start, int end) {
		if(graph[start][end] != null) return graph[start][end];
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 0; i < graph.length; i++) {
			if(graph[start][i] != null) q.offer(i);
		}
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i = 0; i < graph.length; i++) {
				if(graph[cur][i] != null && graph[start][i] == null) {
					graph[start][i] = graph[start][cur] * graph[cur][i];
					graph[i][start] = 1 / graph[start][i];
					q.offer(i);
					if(i == end) return graph[start][end];
				}
			}
		}
		return -1.0;
	}
}
