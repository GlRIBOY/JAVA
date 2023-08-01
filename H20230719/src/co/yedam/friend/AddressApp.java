package co.yedam.friend;

//친구의 연락처를 관리하는 앱
//일반정보: 이름, 연락처
//회사정보:+회사, 부서 / 학교정보:+학교, 전공 
//출력안함
public class AddressApp {
	
	Friend[] friends = new Friend[10]; //저장공간
	int friendN = 0;
	
	//추가 
	public boolean addFriend(Friend friend) {
		if(friend != null) {
			this.friends[friendN++] = friend;
			return true;
		}else {
			return false;
		}
	}
	
	//조회 
	public Friend findFriend(String name) {
		if(name != null) {
			for(int i = 0; i < friendN; i++) {
				if(name == this.friends[i].getName()) {
					String name2 = this.friends[i].getName();
					return name2;
				}
			}
		}
	}
	
	//수정
	public boolean editFriend(String name, String phone) {
		if(name != null) {
			for(int i = 0; i < friendN; i++) {
				if(name == this.friends[i].getName()) {
					this.friends[i].setPhone();
					return true;
				}
			}
			return false;
		}
	}
	
	//삭제
	public boolean delFriend(String name) {
		if(name != null) {
			for(int i = 0; i < friendN; i++) {
				if(name == this.friends[i].getName()) {
					this.friends[i] = null;
					return true;
				}
			}
			return false;
		}
	}

	
	//목록
	public Friend[] friendList() {
		for(int i = 0; i < friendN; i++) {
			return friends[i];
		}
	}
}
