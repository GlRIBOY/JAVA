package co.yedam;

public class ConditionExe {
	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			int result = (int) (Math.random() * 6) + 1; // 0~ 10 사이 랜덤값
			System.out.println(result);
			
			if(result % 2 == 0) {
				System.out.println("2의 배수입니다.");
			}
		}
	}
}
