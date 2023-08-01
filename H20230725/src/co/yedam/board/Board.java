package co.yedam.board;

import java.util.Date;

public class Board {

	int no;
	String title;
	String board;
	String writer;
	String date;

	Board(int no, String title, String board, String writer, String date) {
		this.no = no;
		this.title = title;
		this.board = board;
		this.writer = writer;
		this.date = date;

	}

	public String getBoard() {
		return board;
	}

	public void setBoard(String board) {
		this.board = board;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
