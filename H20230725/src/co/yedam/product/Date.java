package co.yedam.product;

import java.io.Serializable;

public class Date implements Serializable{

	int code;		//productList 제품코드
	String name;	//productList 제품명
	int round;		//productList 판매 및 구매 수량
	String date;	//productList 판매 및 구매 날짜
	String state;	//productList 구-판매 구분

	public Date(int code, String name, int round, String date, String state) {
		this.code = code;
		this.name = name;
		this.round = round;
		this.date = date;
		this.state = state;
	}

}