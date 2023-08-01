package co.micol.miniproject.member.service;

import java.util.List;

public interface MemberService {	//CRUD
	public List<MemberVO> memberSelectList();	//멤버 전체 조회
	public MemberVO memberSelect(MemberVO vo);	//한 멤버 조회
	public int memberInsert(MemberVO vo);	//멤버등록
	public int memberDelete(MemberVO vo);	//멤버삭제
	public int memberUpdate(MemberVO vo);	//멤버변경
}
