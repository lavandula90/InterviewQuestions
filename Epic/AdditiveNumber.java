package Epic;

public class AdditiveNumber {
	public static void main(String[] args) {
		additiveNumber(100, 1000, 0);
	}
	public static void additiveNumber(int start, int end, int num) {
		if(num > end) return;
		if(num > 0 && num > start) {
			System.out.println(num + " ");
		}
		for(int i = 1; i <= 9; i++) {
			for(int j = 0; j <= 9; j++) {
				int next = i + j;
				if(next <= 9) {
					additiveNumber(start, end, num*1000 + i*100 + j*10 + next);
				}
				else if(next <= 18) {
					additiveNumber(start, end, num*10000 + i*1000 + j*100 + next);
				}
			}
		}
	}
}
