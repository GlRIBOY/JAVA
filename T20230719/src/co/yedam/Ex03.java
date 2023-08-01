package co.yedam;

public class Ex03 {

	public static void main(String[] args) {
		
		int max = 0;
		int min = 0;
		int Array[] = new int[5]; //배열 생성방법
		
		for(int i = 0; i < 5; i++) {
			Array[i] = (int)(Math.floor(Math.random() * (10 -1 + 1)) + 1);
		}
		for(int i = 0; i < 5; i++) {
			if(Array[i] > max) {
				max = Array[i];
			}
		}	
		min = Array[0];
		for(int i = 1; i < 5; i++) {
			if(Array[i] < min) {
				min = Array[i];
			}
		}
		
		System.out.printf("최소값: %d, 최대값: %d", min, max);
	}

}
