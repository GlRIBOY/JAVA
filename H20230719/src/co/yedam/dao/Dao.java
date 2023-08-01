package co.yedam.dao;

//MySQL DBMS > add(), modify(), del(), find()
//Oracle DBMS > insert(), modify(), remove(), search()
public interface Dao {
	
	
	public void insert();
	public void modify();
	public void remove();
	public void search();
}
