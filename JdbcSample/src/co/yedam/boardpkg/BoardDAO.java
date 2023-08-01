package co.yedam.boardpkg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class BoardDAO implements BoardService {

	@Override
	public boolean login(String id, String pw) {
		return false;

	}

	@Override
	public boolean addBoard(Board board) {
		return false;
	}

	@Override
	public boolean editBoard(Board board) {
		return false;
	}

	@Override
	public boolean delBoard(int brdNo) {
		return false;
	}

	@Override
	public List<Board> boardList() {
		return null;
	}

	@Override
	public boolean modInfo(User user) {
		return false;
	}

}
