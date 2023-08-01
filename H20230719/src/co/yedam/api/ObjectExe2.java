package co.yedam.api;

public class ObjectExe2 {
	public static void main(String[] args) {
		String[] numbers = { "9802031234567", "0502033234567", "980203-1234567", "980203-2234567", "020203 1234567",
				"030203 2234567" };
		// 1 3 1 2 1 2
		for (String num : numbers) {
			System.out.println(checkGender(num));

		}
	}

	static String checkGender(String no) {

		int len = no.length() - 13;
		char ch = no.charAt(6 + len);
		int chs = Character.getNumericValue(ch);
		if (chs == 1 || chs == 3) {
			return "남";
		} else if (chs == 2 || chs == 4) {
			return "여";

		} else {
			return "에러";
		}
	}
}
