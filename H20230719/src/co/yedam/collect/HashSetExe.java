package co.yedam.collect;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExe {

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		
		set.add("Apple");
		set.add("Banana");
		set.add("Cherry");
		set.add("Apple");
		
		Iterator<String> iter = set.iterator();	//반복자 반환
		while(iter.hasNext()) { //가져올값이 있으면 트루 없으면 폴스 = hasNext
			String str = iter.next();
			System.out.println(str);
		}
		
		//확장 for
		for(String fruit : set) {
			System.out.println(fruit);
		}
		
		set.remove("Apple");
		set.clear();
		
		if(set.isEmpty()) {
			System.out.println("빔");
		}
		
		System.out.println(set.size());
		
		
		Set<Integer> lotto = new HashSet<>();//중복값 거를 때 유용한 set
		//1~10 임의번호 저장
		while(lotto.size() < 5) {
			int temp = (int)(Math.random()*10) + 1;
			lotto.add(temp);
		}
		System.out.println(lotto);

		
	}

}
