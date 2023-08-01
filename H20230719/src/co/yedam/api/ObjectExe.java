package co.yedam.api;

import java.util.HashSet;
import java.util.Set;

public class ObjectExe {

	public static void main(String[] args) {
		Object obj1 = new Object();
		Object obj2 = new Object();
		boolean result = obj1.equals(obj1);
		
		Member mem1 = new Member(1001, "hong");
		Member mem2 = new Member(100, "hong");
		result = mem1.equals(mem2);
		System.out.println(result);
		printRect();
		
		Set<Member> set = new HashSet<>();
		//논리적으로 동등한 객체임을 판별할때 hashCode, equlas정의
		set.add(new Member(1001, "hong"));
		set.add(new Member(1002, "kim"));
		set.add(new Member(1003, "park"));
		set.add(new Member(1001, "hong"));
		
		for(Member str :set) {
			System.out.println(str);
		}
		
	}
	public static void printRect() {
		//1
		//2 3
		//4 5 6
		//7 8 9 10
		int n = 1;
		for(int i = 1; i < 5; i++) {
			for(int j = 0; j < i; j++) {
				
				System.out.print(n++);	
			}
			System.out.println("");
			
		}
	}
}
