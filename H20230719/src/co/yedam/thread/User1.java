package co.yedam.thread;

public class User1 extends Thread {
	Calculator calculator;

	public void setCalculator(Calculator calculator) {
		setName("User1 Thread");
		this.calculator = calculator;

	}

	@Override
	public void run() {
		calculator.setMemory(100);
	}
}
