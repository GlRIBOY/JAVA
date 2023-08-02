package com.physical.management.menu;

import java.util.List;
import java.util.Scanner;

import com.physical.management.client.service.ClientService;
import com.physical.management.client.service.ClientVO;
import com.physical.management.client.serviceImpl.ClientServiceImpl;

public class MainMenu {
	private Scanner sc = new Scanner(System.in);
	private ClientService cs = new ClientServiceImpl();

	private void appTitle() {
		System.out.println("   -메  뉴-");
		System.out.println("[1] 고객정보 조회");
		System.out.println("[2] 고객정보 등록");
		System.out.println("[3] 고객정보 수정");
		System.out.println("[4] 고객정보 삭제");
		System.out.println("[0] 종료\n");
		System.out.print("선택>> ");
	}

	private void appTitle2() {
		System.out.println(" -고객정보 조회-");
		System.out.println("[1] 전체고객 조회");
		System.out.println("[2] 단일고객 조회");
		System.out.println("[3] 종 목 별 조회");
		System.out.println("[0] 뒤로\n");
		System.out.print("선택>> ");
	}

	public void run() {
		boolean b = false;

		do {
			appTitle();
			int menu = 0;
			try {
				menu = sc.nextInt();
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("존재하지 않는 메뉴번호입니다.\n");
				continue;
			}
			sc.nextLine();
			if (menu > 4 || menu < 0) {
				System.out.println("존재하지 않는 메뉴번호입니다.\n");
				continue;
			}
			switch (menu) {
			case 1:
				run2();
				break;
			case 2:
				clientInsert();
				break;
			case 3:
				clientUpdate();
				break;
			case 4:
				clientDelete();
				break;
			case 0:
				b = true;
				System.out.println("어플종료");
				break;
			}
		} while (!b);
		sc.close();
	}

	public void run2() {
		boolean b = false;

		do {
			appTitle2();
			int menu = 0;
			try {
				menu = sc.nextInt();
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("존재하지 않는 메뉴번호입니다.\n");
				continue;
			}
			sc.nextLine();
			if (menu > 3 || menu < 0) {
				System.out.println("존재하지 않는 메뉴번호입니다.\n");
				continue;
			}
			switch (menu) {
			case 1:
				clientList();
				break;
			case 2:
				run3();
				break;
			case 3:
				clientSelects();
				break;
			case 0:
				b = true;
				System.out.println("");
			}
		} while (!b);
	}

	public void run3() {
		boolean b = false;
		do {
			int menu = 0;
			System.out.println(" -단일고객조회-");
			System.out.println("[1] 아이디 조회");
			System.out.println("[2] 성 명 조회");
			System.out.println("[0] 뒤로\n");
			System.out.print("선택>> ");
			///////////////////////////////////
			try {
				menu = sc.nextInt();
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("존재하지 않는 메뉴번호입니다.\n");
				continue;
			}
			sc.nextLine();
			///////////////////////////////////////////////////
			if (menu > 2 || menu < 0) {
				System.out.println("존재하지 않는 메뉴번호입니다.\n");
			}
			switch (menu) {
			case 1:
				clientSelect();
				break;
			case 2:
				clientSelectName();
				break;
			case 0:
				b = true;
				System.out.println("");
			}
		} while (!b);
	}

	private String stringCategory(int category) {
		String cate = "";
		switch (category) {
		case 1:
			cate = "　웨이트　";
			break;
		case 2:
			cate = ("파워리프팅");
			break;
		case 3:
			cate = ("　요　가　");
			break;
		case 4:
			cate = (" 크로스핏 ");
			break;
		}
		return cate;
	}

	private void clientList() {
		List<ClientVO> clients = cs.clientList();
		if (!clients.isEmpty()) {
			System.out.println("번호 종목    성명  나이 키 몸무게   전화번호");
			///////////////////////////////////////////////////////////
			for (ClientVO client : clients) {
				client.toString();
			}

			System.out.println("");
		} else {
			System.out.println("등록된 고객정보가 없습니다.\n");
		}
	}

	private void clientSelect() {
		ClientVO client = new ClientVO();
		int no = 0;
		do {
			System.out.println("");
			System.out.print("-아이디 조회- | [0] 취소\n고객번호: ");
			////////////////////////////////////////////////
			try {
				no = sc.nextInt();
				sc.nextLine();
				if (no == 0) {
					System.out.println("");
					return;
				}
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("존재하지 않는 메뉴번호입니다.\n");
				continue;
			}
			///////////////////////////////////////////////////
			client.setClientId(no);
			client = cs.clientSelect(client);
			if (client.getClientName() != null) {
				System.out.println("번호 종목    성명  나이 키 몸무게   전화번호");
				client.toString();
				System.out.println("");
			} else {
				System.out.println("존재하지 않는 고객번호입니다.\n");
			}
			continue;
		} while (true);
	}

	private void clientSelects() {
		do {
			System.out.println("-종목별 조회-");
			System.out.println("[1] 웨이트");
			System.out.println("[2] 파워리프팅");
			System.out.println("[3] 요가");
			System.out.println("[4] 크로스핏");
			System.out.println("[0] 취소");
			System.out.print("선택>> ");
			int intCategory = 0;
			///////////////////////////////////////////////
			try {
				intCategory = Integer.parseInt(sc.nextLine());
				if (intCategory < 0 || intCategory > 4) {
					System.out.println("존재하지 않는 메뉴번호입니다.\n");
					continue;
				} else if (intCategory == 0) {
					System.out.println("");
					return;
				}
				////////////////////////////////////////////////
				List<ClientVO> clients = cs.clientSelects(stringCategory(intCategory));
				//////////////////////////////////////////////////////////////////////
				if (clients.isEmpty()) {
					System.out.println("등록된 고객정보가 없습니다.\n");
					continue;
				}
				//////////////////////////////////////////////////////
				System.out.println("번호 종목    성명  나이 키 몸무게   전화번호");
				for (ClientVO client : clients) {
					client.toString();
				}
				System.out.println("");
			} catch (Exception e) {
				System.out.println("존재하지 않는 메뉴번호입니다.\n");
			}
			continue;
		} while (true);
	}

	private void clientSelectName() {
		String name = "";
		do {
			System.out.print("-성명 조회- | [0] 취소\n성명>> ");
			name = sc.nextLine();
			if (name.equals("0")) {
				return;
			}
			///////////////////////////////////////////////////
			List<ClientVO> client = cs.clientSelectName(name);
			//////////////////////////////////////////////////
			if (client.isEmpty()) {
				System.out.println("존재하지 않는 고객명입니다.\n");
				continue;
			}
			///////////////////////////////////////////////////
			System.out.println("번호 종목    성명  나이 키 몸무게   전화번호");
			for (ClientVO clients : client) {
				clients.toString();
				System.out.println("");
			}
		} while (true);
	}

	private void clientInsert() {
		ClientVO client = new ClientVO();
		boolean b = false;
		do {
			System.out.println("-고객정보등록-");
			System.out.println("종목:");
			System.out.println("[1] 웨이트");
			System.out.println("[2] 파워리프팅");
			System.out.println("[3] 요가");
			System.out.println("[4] 크로스핏");
			System.out.println("[0] 취소");
			System.out.print("선택>> ");
			///////////////////////////////////////////////////////
			try {
				int intCategory = Integer.parseInt(sc.nextLine());
				if (intCategory > 4 || intCategory < 0) {
					System.out.println("존재하지 않는 종목입니다.\n");
					continue;
				} else if (intCategory == 0) {
					return;
				}
				/////////////////////////////////////////////////////
				client.setClientCategory(stringCategory(intCategory));
//				switch (intCategory) {
//				case 1:
//					client.setClientCategory("　웨이트　");
//					break;
//				case 2:
//					client.setClientCategory("파워리프팅");
//					break;
//				case 3:
//					client.setClientCategory("　요　가　");
//					break;
//				case 4:
//					client.setClientCategory(" 크로스핏 ");
//					break;
//				case 0:
//					System.out.println("");
//					return;
//				}
				System.out.print("성명: ");
				client.setClientName(sc.nextLine());
				System.out.print("나이: ");
				client.setClientAge(Integer.parseInt(sc.nextLine()));
				System.out.print("키: ");
				client.setClientHeight(Integer.parseInt(sc.nextLine()));
				System.out.print("몸무게: ");
				client.setClientWeight(Integer.parseInt(sc.nextLine()));
				System.out.print("전화번호: ");
				client.setClientPhone(sc.nextLine());
				///////////////////////////////////////////////////////
				if (cs.clientInsert(client) != 0) {
					System.out.println("정상적으로 등록되었습니다.\n");
					b = true;
				} else {
					System.out.println("등록 오류\n");
					continue;
				}
			} catch (Exception e) {
				System.out.println("정상적인 값을 입력하시오.\n");
			}
		} while (!b);
	}

	private void clientDelete() {
		ClientVO client = new ClientVO();
		boolean b = false;
		do {
			int n = 0;

			System.out.print("-고객정보삭제- | [0] 취소\n고객번호: ");

			try {
				n = sc.nextInt();
				sc.nextLine();
				if (n == 0) {
					System.out.println("");
					return;
				}
				////////////////////////////////////////////////
				client.setClientId(n);
				///////////////////////////////////////////////
				if (cs.clientDelete(client) != 0) {
					System.out.println("정상적으로 삭제되었습니다.\n");
					b = true;
				} else {
					System.out.println("존재하지 않는 고객번호입니다.\n");
					continue;
				}
			} catch (Exception e) {
				System.out.println("정상적인 값을 입력하시오.\n");
				sc.nextLine();
				continue;
			}

		} while (!b);
	}

	private void clientUpdate() {
		ClientVO client = new ClientVO();
		boolean b = false;
		int n = 0;
		do {
			System.out.print("-고객정보수정- | [0] 취소\n고객번호: ");
			try {
				n = sc.nextInt();
				sc.nextLine();
				if (n == 0) {
					System.out.println("");
					return;
				}
				//////////////////////////////////////////////////
				client.setClientId(n);
				client = cs.clientSelect(client);
				if (client.getClientName() == (null)) {
					System.out.println("존재하지 않는 고객번호입니다.\n");
					continue;
				}
				System.out.println("번호 종목    성명  나이 키 몸무게   전화번호");
				client.toString();
				/////////////////////////////////////////////////////////
				System.out.println("종목:");
				System.out.println("[1] 웨이트");
				System.out.println("[2] 파워리프팅");
				System.out.println("[3] 요가");
				System.out.println("[4] 크로스핏");
				System.out.println("[0] 취소");
				System.out.print("선택>> ");

				int intCategory = sc.nextInt();
				sc.nextLine();
				if (intCategory > 4 || intCategory < 0) {
					System.out.println("존재하지 않는 종목입니다.\n");
					continue;
				} else if (intCategory == 0) {
					System.out.println("");
					return;
				}
				client.setClientCategory(stringCategory(intCategory));
				///////////////////////////////////////////////////////
				System.out.print("몸무게: ");
				client.setClientWeight(sc.nextInt());
				sc.nextLine();
				System.out.print("전화번호: ");
				client.setClientPhone(sc.nextLine());
				if (cs.clientUpdate(client) == 2) {
					System.out.println("정상적으로 수정되었습니다.\n");
					b = true;
				} else {
					System.out.println("수정 오류\n");
					continue;
				}
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("정상적인 값을 입력하시오.\n");
				continue;
			}
		} while (!b);
	}

}
