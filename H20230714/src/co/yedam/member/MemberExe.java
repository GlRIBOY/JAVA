package co.yedam.member;

import java.util.Scanner;

public class MemberExe {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		Member[] members = new Member[10];
		
		Member m3 = new Member();
		members[2] = m3;
		Member m4 = new Member(3001, "황철순", "010-123", Gender.MEN, "eorn 123");
		members[3] = m4;
		
		while(run) {
			System.out.println("1.등록 2.목록 3.수정 4.삭제 5.상세조회 6.남성회원조회 7.종료");
			System.out.print("선택>> ");
			int menu = Integer.parseInt(scn.nextLine());
			
			if(menu == 1) {
				System.out.print("회원번호입력> ");
				int mNo = Integer.parseInt(scn.nextLine());
				System.out.print("이름 입력> ");
				String mName = scn.nextLine();
				System.out.print("연락처 입력> ");
				String phone = scn.nextLine();
				System.out.print("성별 입력> ");
				
				Gender gender = null;
				String temp = scn.nextLine(); 
				if(temp.startsWith("남")) {
					gender = Gender.MEN;
				} else if(temp.startsWith("여")) {
					gender = Gender.WOMEN;
				}
				System.out.print("주소 입력> ");
				String addr = scn.nextLine();
				
				Member member = new Member();//instance
				member.setMemberNo(mNo);
				member.setMemberName(mName);
				member.setPhone(phone);
				member.setGender(gender);
				member.setAddress(addr);
				
				//10 memberInstance save to members
				for(int i = 0; i < members.length; i++) {
					if(members[i] == null){
						members[i] = member; //배열의 빈값에 저장
						break; //한건 저장 후 반복문 종료
					}
				}
				
			}else if(menu == 2) {
				boolean isExist = false;
				for(int i = 0; i < members.length; i++) {
					if(members[i] != null){
						System.out.println(members[i].showInfo());
						isExist = true;
					}
				}
				if (isExist == false) {
					System.out.println("회원정보가 없습니다");
				}
			}else if(menu == 3) {
				//찾기위해 회원정보 수정할것 연락처
				System.out.print("회원번호>> ");
				int no = Integer.parseInt(scn.nextLine());
				boolean isExist = false;
				
				for(int i = 0; i < members.length; i++) {
					if(members[i] !=null && members[i].getMemberNo() == no) {
						System.out.print("연락처 수정> ");
						members[i].setPhone(scn.nextLine());
						System.out.println("\n연락처 수정완료\n");
						System.out.print("주소 수정> ");
						members[i].setAddress(scn.nextLine());
						System.out.println("\n주소 수정완료\n");
						isExist = true;
					}

					}
				if (isExist == false) {
					System.out.println("찾는 회원이 없습니다");
				}
				
			}else if(menu == 4) {
				System.out.print("회원번호>> ");
				int no = Integer.parseInt(scn.nextLine());
				boolean isExist = false;
				
				for(int i = 0; i < members.length; i++) {
					if(members[i] !=null && members[i].getMemberNo() == no) {
						members[i] = null;
						isExist = true;
					}
				}
				if (isExist == false) {
					System.out.println("찾는 회원이 없습니다");
				}
			}else if(menu == 5) {
				System.out.print("회원번호>> ");
				int no = Integer.parseInt(scn.nextLine());
				boolean isExist = false;
				
				for(int i = 0; i < members.length; i++) {
					if(members[i] != null && members[i].getMemberNo() == no) {
						System.out.println(members[i].detailInfo());
						isExist = true;
					}
				}
				if (isExist == false) {
					System.out.println("찾는 회원이 없습니다");
				}
			}else if(menu == 6) {
				for(int i = 0; i < members.length; i++) {
					if(members[i] != null && members[i].getGender() == Gender.MEN) {
						System.out.println(members[i].showInfo());
					}
				}
			}else if(menu == 7) {
				run = false;
			}
		}
		System.out.println("end of prog.");
	}

}
