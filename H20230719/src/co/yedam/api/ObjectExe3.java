package co.yedam.api;

public class ObjectExe3 {
	public static void main(String[] args) {
		String[] numbers = {"9802031234567", "0502033234567", "980203-1234567", "980203-2234567", "020203 1234567",
				"030203 2234567" };
		// 1 3 1 2 1 2
		

//		char a = (char)1;
//		char b = (char)3;
		int len;
		char ch;
		for (String num : numbers) {
			
			len = num.length() - 13;
			ch = num.charAt(6+len);
			int chs = Character.getNumericValue(ch);
				if (chs == 1 || chs == 3) {
					System.out.println( "남");
				}else if(chs == 2 || chs == 4){
					System.out.println( "여");
				
				}
		
			

	}


	}
}
