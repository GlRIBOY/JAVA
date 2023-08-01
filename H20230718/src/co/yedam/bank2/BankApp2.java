package co.yedam.bank2;

import java.util.Scanner;

public class BankApp2 {
Scanner scn = new Scanner(System.in);
//싱그톤 방식
	private static BankApp2 instance = new BankApp2();

//필드
	Account2[] accounts;
	int accountNum = 0;
	
	private BankApp2(){
		accounts = new Account2[10];
	}
	
	public static BankApp2 getInstance() {
		return instance;
	}
	
	boolean addAccount(Account2 acc) {
		if(accountNum >= 10) {
			return false;
		}else {
			accounts[accountNum++] = acc;
			return true;
		}
	}
	
	void deposit() {
		if(accountNum == 0){
			System.out.println("등록된 계좌가 없습니다");
		}else {
			System.out.print("계좌번호: ");
			for(int i = 0; i < accountNum; i++) {
				if(scn.nextLine().equals(accounts[i].accNum)) {
					System.out.print("입금금액: ");
					int de = Integer.parseInt(scn.nextLine());
					if(de < 0) {
						System.out.println("음수값은 입력할 수 없습니다");
					}else{
						accounts[i].accTal = accounts[i].accTal + de;
					}
				}else {
					System.out.println("없는 계좌입니다");
				}
			}
		}
	}
	
	void withdraw() {
		if(accountNum == 0){
			System.out.println("등록된 계좌가 없습니다");
		}else {
			System.out.print("계좌번호: ");
			for(int i = 0; i < accountNum; i++) {
				if(scn.nextLine().equals(accounts[i].accNum)) {
					System.out.print("출금금액: ");
					int wi = Integer.parseInt(scn.nextLine());
					if(wi < 0) {
						System.out.println("음수값은 입력할 수 없습니다");
					}else if(accounts[i].accTal >= wi) {
						accounts[i].accTal = accounts[i].accTal - wi;
					}else {
						System.out.println("잔액이 없습니다");
					}
				}else {
					System.out.println("없는 계좌입니다");
				}
			}
		}
	}
	
	void checkBalance(){
		if(accountNum == 0){
			System.out.println("등록된 계좌가 없습니다");
		}else {
			System.out.print("계좌번호: ");
			for(int i = 0; i < accountNum; i++) {
				if(scn.nextLine().equals(accounts[i].accNum)) {
					System.out.printf("계좌번호: %-10s 성명: %-10s 잔액: %-10d\n", accounts[i].accNum, accounts[i].accName, accounts[i].accTal);
				}else {
					System.out.println("없는 계좌입니다");
				}
			}
		}
	}
	
	void accountList(){
		if(accountNum == 0){
			System.out.println("등록된 계좌가 없습니다");
		}
		for(int i = 0; i < accountNum; i++) {
			System.out.printf("계좌번호: %-10s 성명: %-10s\n", accounts[i].accNum, accounts[i].accName);
		}
	}
}//end of class
