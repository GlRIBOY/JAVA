package co.yedam.collect;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExe {
	public static void main(String[] args) {
		Queue<String> que = new LinkedList<>();
		que.offer("hong");
		que.offer("choi");
		que.offer("park");
		
		while(!que.isEmpty()) {
			System.out.println(que.poll());
		}
		
		
	}
}
