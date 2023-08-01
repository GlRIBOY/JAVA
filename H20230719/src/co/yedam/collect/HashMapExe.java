package co.yedam.collect;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapExe {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();

		map.put("hong", 80);
		map.put("kim", 85);
		map.put("lee", 88);
		map.put("hong", 90);

		map.remove("hong");

		if (map.containsKey("kim")) {
			Integer result = map.get("kim");
			System.out.println(result);
		}

		// 반복된 요소 출력
		Set<String> keys = map.keySet();// 키에 해당되는 값만 set 컬렉션에 저장해준다
		for (String key : keys) {
			Integer val = map.get(key);
			System.out.println("키" + key + ", 값" + val);
		}

		Set<Entry<String, Integer>> entrySet = map.entrySet();// 키와 값 둘다뽑아줌
		for (Entry<String, Integer> entry : entrySet) {
			String key = entry.getKey();
			Integer val = entry.getValue();
			System.out.println(key + " " + val);
		}

		System.out.println("end");
	}

}
