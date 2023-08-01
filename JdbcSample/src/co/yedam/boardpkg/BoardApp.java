package co.yedam.boardpkg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoardApp implements BoardService {
	List<Board> boardList = new ArrayList<>();
	List<User> userList = new ArrayList<>();

	Scanner scn = new Scanner(System.in);
	Connection con; // DB연결세션
	Statement sm;
	ResultSet rs;

	public void DBConnection() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "1234");
			sm = con.createStatement();
		}catch(Exception e) {
			System.out.println("데이터베이스 연결 오류: " + e.getMessage());
		} 
	}
	
	public boolean isAdmin(String id, String pw) {
		try {
			String sql = "select * from users where user_id = '" + id + "' and user_pw = '" + pw+"'";
			rs = sm.executeQuery(sql);
			if(rs.next()) {
				return true;
			}
		}catch(Exception e) {
			System.out.println("데이터베이스 검색 오류: " + e.getMessage());
		}
		return false;
	}
	
	void disconn() {

		try {
			if (con != null) {
				con.close();
			}
			if (psm != null) {
				psm.close();
			}
			if (rs != null) {
				rs.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	BoardApp() {
		readFromFile();
	}

	void readFromFile() {
		try {
			FileReader fr1 = new FileReader("c:/Temp/userList.txt");
			FileReader fr2 = new FileReader("c:/Temp/boardList.txt");

			BufferedReader br = new BufferedReader(fr1);
			while (true) {
				String str = br.readLine();
				if (str == null)
					break;
				String[] data = str.split(" ");
				userList.add(new User(data[0], data[1], data[2]));
			}
			br = new BufferedReader(fr2);
			while (true) {
				String str = br.readLine();
				if (str == null)
					break;
				String[] data = str.split(" ");
				boardList.add(new Board(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4]));
			}
			br.close();
			fr2.close();
			fr1.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	void saveToFile() {
		try {
			FileWriter fw1 = new FileWriter("c:/Temp/userList.txt");
			FileWriter fw2 = new FileWriter("c:/Temp/boardList.txt");
			for (User user : userList) {
				fw1.write(user.getUserId() + " " + user.getUserName() + " " + user.getUserPw());
			}
			for (Board brd : boardList) {
				fw2.write(brd.getBrdNo() + " " + brd.getTitle() + " " + brd.getContent() + " " + brd.getWriter() + " "
						+ brd.getWriteDate());
			}
			fw1.flush();
			fw1.close();
			fw2.flush();
			fw2.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public boolean login(String id, String pw) {
		System.out.println("아이디: ");
		String ids = scn.nextLine();
		System.out.println("비밀번호: ");
		String pws = scn.nextLine();
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Not found OracleDriver");
			return false;
		}
		String url = ;
		try {
			System.out.println("로그인 \"hr\"");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("로그인 정보가 일치하지 않음");
			return false;
		}
	}

	// 글등록.
	public boolean addBoard(Board board) {
		String sql = "insert into boards (board_no, title, content, writer, write_date) values(?, ?, ?, ?, ?)";

		try {
			System.out.print("글번호: ");
			int no = Integer.parseInt(scn.nextLine());
			System.out.print("제목: ");
			String title = scn.nextLine();
			System.out.print("내용: ");
			String content = scn.nextLine();
			System.out.print("작성자: ");
			String writer = scn.nextLine();
			System.out.print("날짜: ");
			String writeDate = scn.nextLine();
			psm = conn.prepareStatement(sql);
			psm.setInt(1, no);
			psm.setString(2, title);
			psm.setString(3, content);
			psm.setString(4, writer);
			psm.setString(5, writeDate);
			int r = psm.executeUpdate();// 처리된 건수 반환
			if (r == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			disconn();

		}
		return false;

	}

	// 글수정.
	public boolean editBoard(Board board) {
		String sql = "update boards set content='?' where board_no=?";

		try {
			System.out.print("글번호: ");
			int no = Integer.parseInt(scn.nextLine());
			System.out.print("내용: ");
			String content = scn.nextLine();
			psm = conn.prepareStatement(sql);
			psm.setString(1, content);
			psm.setInt(2, no);
			int r = psm.executeUpdate();// 처리된 건수 반환
			if (r == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disconn();

		}
		return false;

	}

	// 글삭제.
	public boolean delBoard(int brdNo) {
		return false;
	}

	// 글목록.
	public List<Board> boardList() {
		return boardList;
	}

	// 개인정보수정.
	public boolean modInfo(User user) {
		return false;
	}

}
