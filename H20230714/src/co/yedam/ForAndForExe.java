package co.yedam;

public class ForAndForExe {

	public static void main(String[] args) {
//		practice4();
		practice3();

	}// end of main
	
	public static void practice3() {
		//주사위: 1 ~ 6까지의 수. Math.random()

		boolean run = true;

		while(run) {
			int sum = 0;
			int num1 = (int) (Math.random() * 6) +1;
			int num2 = (int) (Math.random() * 6) +1;
			System.out.println(num1+", " + num2);
			sum = num1 + num2;
			switch(sum) {
			
			case 1:
			case 2:
			case 3:
			case 4:
			case 6:continue;
			case 5:System.out.println(num1+" + "+num2+" = "+sum);
					run = false;
				
			}
		}
	}
	
	public static void practice4() {
		System.out.printf("x => 5, y => 8");
		System.out.printf("x => 5, y => 8");
	}
	

	// 세로구구단
	public static void gugudan() {
		  for(int i = 1; i < 10; i++) {
			  System.out.println(i + "단"); 
			  for(int j = 1; j < 10; j++) { 
				  //System.out.println(i + " X " + j + " = " + (i * j));
				  System.out.printf("%d X %d = %2d \n", i, j, (i*j)); //또는 이렇게
			  	}
			  	System.out.println(); 
			  }
	}// end of gugudan
	
	// 가로 구구단
	public static void gugudan2() {
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 10; j++) {
				System.out.printf("%d X %d = %2d     ", j, i, (j * i));
			}
			System.out.println();
		}
	}// end of gugudan2
}
