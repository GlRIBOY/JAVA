package co.yedam.collect;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import co.yedam.friend.Friend;

public class ArrayListExe2 {

	public static void main(String[] args) {
		List<Friend> friends = new ArrayList<>();
		friends.add(new Friend("hong", "111"));
		Friend friend = new Friend("kim", "222");
		friends.add(friend);
		friends.remove(friend);
		
		System.out.println(friends.size());
		
		List<String> list = new Vector<>();
		list.add("hong");
		list.add("kim");
		list.remove(0);
	}

}
