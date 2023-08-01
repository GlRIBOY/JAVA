package co.yedam.board;

public class BoardExe {

	public static void main(String[] args) {
		// 1.로그인기능 (아이디/비번) -> "(아이디) 로그인"
		// 1.글등록 2.글수정 3.글삭제 4.목록 5.종료 9.비밀번호변경(비번수정)
		// user.java -> userList -> userList.txt && user => Board
		// 오브젝트 저장말고 텍스트 저장

		UserApp uApp = UserApp.getUserApp();

		uApp.homeMenu();

	}

}
