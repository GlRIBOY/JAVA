package co.yedam.collect;

import java.awt.List;
import java.util.ArrayList;

import co.yedam.friend.Friend;

public class ArrayListExe {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>(); //<타입> 정한 타입 정보만 담겠단얘기
		list.add("ghd");
//		list.add(10);
//		list.add(new Friend("rla", "010-111"));

		String obj = (String) list.get(0);
//		Integer num = (Integer) list.get(1);
//		System.out.println(obj + " " + num);

	}

}
