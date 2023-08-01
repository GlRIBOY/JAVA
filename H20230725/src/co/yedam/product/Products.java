package co.yedam.product;

import java.io.Serializable;

public class Products implements Serializable {

	int code;	//제품코드
	String name;//제품명
	int price;	//가격
	int round;	//재고

	public Products(int code, String name, int price) {
		this.code = code;
		this.name = name;
		this.price = price;
		this.round = 0;
	}
}
