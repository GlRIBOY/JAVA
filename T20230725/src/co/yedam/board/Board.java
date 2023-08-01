package co.yedam.board;
import java.util.Date;


public class Board {
	int no;
	String title;
	String content;
	String writer;
	Date writeDate;

	public Board(int no, String title, String content, String writer) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.writer = writer;
		this.writeDate = new Date();
	}

}
