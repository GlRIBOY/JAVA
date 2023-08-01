package co.yedam.reference;

public class IntArrayExe {

	public static void main(String[] args) {
		int[] intAry = {10, 20 , 30};
		intAry = new int[] {10, 20 , 30};
		intAry = new int[5];
		
		intAry[0] = 15;
		intAry[intAry.length - 1] = 55;
		int sum = 0;
		for (int i = 0; i < intAry.length; i++) {
			System.out.println(intAry[i]);
			sum+= intAry[i];
			}
		System.out.println("sum: " + sum);
		
		//확장 for./
		for(int num : intAry) {
			System.out.println(num);
			sum += num;
		}
		System.out.println("sum: " + sum);
		
		//정수를 저장할 수 있는 배열 scores.
		//학생 1~ 학생 5: 80, 85, 75, 93, 100
		//학생점수의 합과 평균
		int sumA = 0;
		int i = 0;
		int[] scores = {80, 85, 77, 93, 100};
		for(i = 0; i < scores.length; i++) {
			sumA += scores[i];
		}
		double avgA = sumA/scores.length;
		System.out.printf("합 %d, 평균 %.1f", sumA, avgA);
		
		
		
	}
	

}
