package co.yedam.thread;

class PrintThread extends Thread {

	@Override
	public void run() {
		System.out.println("프린트 스레드 실행");
	}
}

public class ThreadExe {

	public static void main(String[] args) {
		Thread mainThread = Thread.currentThread();
		System.out.println(mainThread.getName());

		PrintThread thread = new PrintThread();
		thread.start();

		System.out.println("end");

	}

}
