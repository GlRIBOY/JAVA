package co.yedam.dao;

public class MysqlDao implements Dao{
	
//	add(), modify(), del(), find()
	public void insert() {
		System.out.println("MySQL 등록");
	}
	
	public void modify() {
		System.out.println("MySQL 수정");
	}
	
	public void remove() {
		System.out.println("MySQL 삭제");
	}
	
	public void search() {
		System.out.println("MySQL 조회");
	}
}
