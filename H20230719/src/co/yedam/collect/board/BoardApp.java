package co.yedam.collect.board;

import java.util.ArrayList;
import java.util.List;

public class BoardApp {

	List<Board> boards = new ArrayList<>();

	boolean addBoard(Board board) {
		return boards.add(board);
	}

	List<Board> boardList() {
		return null;
	}

	Board getBoard(int boardNo) {
		return null;
	}

	boolean delBoard(int boardNo) {
		return false;
	}

}
