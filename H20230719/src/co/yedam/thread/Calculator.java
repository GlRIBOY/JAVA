package co.yedam.thread;

public class Calculator {
	private int memory;

	public int getMemory() {
		return memory;
	}

	public synchronized/*임계영역*/ void setMemory(int memory) {
		this.memory = memory;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName() + " : " + this.memory);

	}
}
