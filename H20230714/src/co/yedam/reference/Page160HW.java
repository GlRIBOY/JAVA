package co.yedam.reference;

public class Page160HW {

	public static void main(String[] args) {
		//5번문제
		String star = "";
		for(int i = 0; i < 4; i++) {

				star += "*";

			System.out.println(star);

		}
		//6번문제
		String star2 = "";
		for(int i = 1; i < 5; i++) {
			for(int j = 3; j > i-1 ; j--) {
				star2 += " ";
			}

			for(int k = 0; k < i; k++) {
				star2 += "*";
			}
			System.out.println(star2);
			star2 = "";
		}




	}
}
