package InterviewQuestions;

import java.util.*;

public class PascalTriangle {
	public static void main(String[] args) {
		
	}
	
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> listOfList = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        if(numRows == 0) return listOfList;
        list.add(1);
        listOfList.add(list);
        if(numRows == 1) return listOfList;
        
        
        
        return listOfList;
    }
}
