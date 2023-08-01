package co.yedam.thread;

public class User2 extends Thread {
	Calculator calculator;

	public void setCalculator(Calculator calculator) {
		setName("User2 Thread");
		this.calculator = calculator;
	}

	@Override
	public void run() {
		calculator.setMemory(50);
	}
}
