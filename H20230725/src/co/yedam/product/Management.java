package co.yedam.product;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Management {
	Management(){
		readFromFileP();
		readFromFileD();
	}
	Scanner scn = new Scanner(System.in);
	List<Products> productList = new Vector<>();

	List<Date> dateList = new Vector<>(); // 판매 및 구매 일자 리스트

	int code; // 제품코드 담는 필드

	public void add() {
		try {
			code = productList.size() + 1;// 제품코드생성
			
			int result = 1; // 동명제품 여부 [0 = 중복, 1 = 추가가능]
			
			System.out.print("※공백X\n제품명: ");
			String pName = scn.nextLine();
			
			if (pName.equals("") || pName.contains(" ")) { // 무값 또는 공백 거르는 작업
				System.out.println("정상적인 제품명을 입력하시오.");
				return;
			}
			
			for (int i = 0; i < productList.size(); i++) {// 입력한 제품명이 리스트에 있는지
				String str = productList.get(i).name; //////
				if (pName.equals(str)) { ///////////////////
					System.out.println("동일한 제품이 있습니다.");
					result = 0; ////////////////////////////
								////////////////////////////
					break; /////////////////////////////////
				} else { ///////////////////////////////////
					result = 1; ////////////////////////////
					break; /////////////////////////////////
				} //////////////////////////////////////////
			} //////////////////////////////////////////////
			if (result == 0) { /////////////////////////////
				return; ////////////////////////////////////
			} //////////////////////////////////////////////

			System.out.print("제품가격: ");
			int pPirce = Integer.parseInt(scn.nextLine());
			if (pPirce <= 0) {
				System.out.println("정상적인 값을 입력하시오.");
				return;
			}
			
			if (productList.add(new Products(code, pName, pPirce))) { // 제품등록
				System.out.println("정상 등록.(제품코드:" + code + ")\n");
			} else {
				System.out.println("등록 에러.\n");
			}
		} catch (Exception e) {
			System.out.println("정상적인 값을 입력하시오.\n");
		}

	}// end add 완료

	public void sell() {// 완료
		try {
			System.out.print("제품코드: ");
			int pCode = Integer.parseInt(scn.nextLine());
			Products product;
			if (pCode > productList.size() || pCode == 0) {
				System.out.println("없는 제품 코드입니다.");
				return;
			}
			
			for (int i = 0; i < productList.size(); i++) {
				if (productList.get(i).code == pCode) {
					product = productList.get(i);

					if (product.round == 0) {

						System.out.println("재고가 없습니다.\n     제품명      |     재고     \n-----------------------------");
						System.out.printf("  %-10s |     %-5d \n\n", product.name, product.round);
						break;
					}

					System.out.println("     제품명      |     재고     \n-----------------------------");
					System.out.printf("  %-10s |     %-5d \n\n", product.name, product.round);
					System.out.print("판매 수량: ");

					int sellRound = Integer.parseInt(scn.nextLine());
					if (sellRound <= 0) {
						System.out.println("정확한 값을 입력하시오.");
						continue;
					}
					if (product.round - sellRound < 0) {
						System.out.println("재고가 부족합니다.\n");
						break;
					}

					System.out.print("판매 날짜(yyyy/MM/dd): ");
					String sellDate = scn.nextLine();

					if (sellDate.contains(" ") || sellDate.length() < 10) {
						System.out.println("정확한 값을 입력하시오.");
						continue;
					}
					dateList.add(new Date(product.code, product.name, sellRound, sellDate, "sell"));
					product.round -= sellRound;
					System.out.println("판매등록\n");
					break;

				}
			}
		} catch (Exception e) {
			System.out.println("정확한 값을 입력하시오.");
		}
	}// end sell clear

	public void buy() {// 완료
		try {
			System.out.print("제품코드: ");
			int pCode = Integer.parseInt(scn.nextLine());

			Products product;
			if (pCode > productList.size() || pCode == 0) {
				System.out.println("없는 제품 코드입니다.");
				return;
			}
			for (int i = 0; i < productList.size(); i++) {
				if (productList.get(i).code == pCode) {
					product = productList.get(i);
					System.out.println("     제품명      |     재고     \n-----------------------------");
					System.out.printf("  %-10s |     %-5d \n\n", product.name, product.round);
					System.out.print("구매 수량: ");
					int buyRound = Integer.parseInt(scn.nextLine());
					if (buyRound <= 0) {
						System.out.println("정확한 값을 입력하시오.");
						continue;
					}
					System.out.print("구매 날짜(yyyy/MM/dd): ");
					String buyDate = scn.nextLine();
					if (buyDate.contains(" ") || buyDate.length() < 10) {
						System.out.println("정확한 값을 입력하시오.");
						continue;
					}
					dateList.add(new Date(product.code, product.name, buyRound, buyDate, "buy"));
					product.round += buyRound;
					System.out.println("구매등록\n");
					break;

				}
			}
		} catch (Exception e) {
			System.out.println("정확한 값을 입력하시오.");
		}
	}// end buy clear

	public void round() {
		System.out.print("제품코드: ");
		int pCode = Integer.parseInt(scn.nextLine());
		if (pCode > productList.size() || pCode == 0) {
			System.out.println("없는 제품 코드입니다.");
			return;
		}
		Products product;
		for (int i = 0; i < productList.size(); i++) {
			if (productList.get(i).code == pCode) {
				product = productList.get(i);
				System.out.println("     제품명      |     재고     \n-----------------------------");
				System.out.printf("  %-10s |     %-5d \n\n", product.name, product.round);

//				System.out.println("제품명: " + product.name + " / 재고: " + product.round + "\n");
				break;
			}
		}
	}// end list

	public void sellList() {
		System.out.print("제품코드: ");
		int pCode = Integer.parseInt(scn.nextLine());
		if (pCode > productList.size() || pCode == 0) {
			System.out.println("없는 제품 코드입니다.");

			return;
		}
		Date date;
		System.out.println("     제품명      |  판매 수량  |    판매일자    \n----------------------------------------");

		for (int i = 0; i < dateList.size(); i++) {
			if (dateList.get(i).code == pCode && dateList.get(i).state.equals("sell")) {
				date = dateList.get(i);
				System.out.printf("  %-10s |     %-5d | %-10s\n\n", date.name, date.round, date.date);
//				System.out.println("제품명: " + date.name + " / 판매수량: " + date.round + " / 판매일자: " + date.date + "\n");

			}
		}
	}// end list

	public void buyList() {
		System.out.print("제품코드: ");
		int pCode = Integer.parseInt(scn.nextLine());
		if (pCode > productList.size() || pCode == 0) {
			System.out.println("없는 제품 코드입니다.");
			return;
		}
		Date date;
		System.out.println("     제품명      |  판매 수량  |    판매일자    \n----------------------------------------");
		for (int i = 0; i < dateList.size(); i++) {
			if (dateList.get(i).code == pCode && dateList.get(i).state.equals("buy")) {
				date = dateList.get(i);
				System.out.printf("  %-10s |     %-5d | %-10s\n\n", date.name, date.round, date.date);
//				System.out.println("제품명: " + date.name + " / 구매수량: " + date.round + " / 구매일자: " + date.date + "\n");

			}
		}
	}// end list

	public void storeToFileP() {
		// 출력스트림. 객체에 담아야함
		try {
			FileOutputStream fos = new FileOutputStream("C:/Temp/productList.db");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(productList);
			oos.flush();
			oos.close();
			fos.flush();
			fos.close();
		} catch (Exception e) {
			System.out.println("저장 오류");
		}
	}
	
	public void storeToFileD() {
		// 출력스트림. 객체에 담아야함
		try {
			FileOutputStream fos = new FileOutputStream("C:/Temp/dateList.db");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(dateList);
			oos.flush();
			oos.close();
			fos.flush();
			fos.close();
		} catch (Exception e) {
			System.out.println("저장 오류");
		}
	}

	public void storeToFile(List list, String path) {
		// 출력스트림. 객체에 담아야함
		try {
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
			oos.flush();
			oos.close();
			fos.flush();
			fos.close();
		} catch (Exception e) {
			System.out.println("저장 오류");

		}
	}

	public void readFromFileP() {
		// 입력스트림. 객체에 담아야함

		try {
			FileInputStream fis = new FileInputStream("C:/Temp/productList.db");
			ObjectInputStream ois = new ObjectInputStream(fis);
			productList = (List<Products>) ois.readObject();
			ois.close();
			fis.close();

		} catch (Exception e) {
			System.out.println("불러오기 오류");

		}
	}

	public void readFromFileD() {
		// 입력스트림. 객체에 담아야함

		try {
			FileInputStream fis = new FileInputStream("C:/Temp/dateList.db");
			ObjectInputStream ois = new ObjectInputStream(fis);
			dateList = (List<Date>) ois.readObject();
			ois.close();
			fis.close();

		} catch (Exception e) {
			System.out.println("불러오기 오류");

		}
	}

}// end class
