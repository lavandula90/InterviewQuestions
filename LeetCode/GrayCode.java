package InterviewQuestions;

import java.util.*;

public class GrayCode {
	public List<Integer> grayCode(int n) {
        List<Integer> rst = new ArrayList<Integer>();
        rst.add(0);
        for(int i = 0; i < n; i++) {
        	int base = 1 << i;
        	for(int j = rst.size() - 1; j >= 0; j--) {
        		rst.add(base + rst.get(j));
        	}
        }
        return rst;
    }
}
