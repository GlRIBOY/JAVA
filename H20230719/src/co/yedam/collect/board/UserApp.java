package co.yedam.collect.board;

import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

public class UserApp {
	boolean run = true;
	Scanner scn = new Scanner(System.in);
	Map<String, String> users = new Hashtable<String, String>();
	
	UserApp(){
		users.put("user1", "1111");
		users.put("user2", "2222");
		users.put("admin", "3333");
	}
	
	boolean login(String id, String pw) {
		while(run) {
			System.out.println("아이디: ");
			String scnId = scn.nextLine();
			System.out.println("비밀번호: ");
			String scnPw = scn.nextLine();
			if(users.containsKey(scnId)) {
				if(users.get(scnId).equals(scnPw)) {
					run = false;
				}else {
					continue;
				}
			}else {
				continue;
			}
		}
		return true;

	}
	
}
