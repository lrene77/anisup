package anisup.service;

import java.util.List;

import anisup.model.Member;

public interface MemberService {
	//아이디 중복검사
	public void selectUserIdCount(Member member) throws Exception;
	
	//이메일 중복 검사
	public void selectEmailCount(Member member) throws Exception;
	
	//회원 가입
	public void insertMember(Member member) throws Exception;
	
	//로그인
	public Member selectLoginInfo(Member member) throws Exception;
	
	//비밀번호 변경
	public void updateMemberPasswordByEmail(Member member) throws Exception;
	
	//비밀번호 검사
	public void selectMemberPasswordCount(Member member) throws Exception;
	
	//회원 탈퇴
	public void deleteMember(Member member) throws Exception;
	
	//회원 정보 수정
	public void updateMember(Member member) throws Exception;
	
	//일련번호에 의한 회원정보 조회
	public Member selectMember(Member member) throws Exception;
	
	//아이디 찾기
	public Member selectIdSear(Member member) throws Exception;
	
	//비밀번호 찾기
	public void updateMemberPassword(Member member) throws Exception;
	
	//관리자 회원 조회
	public List<Member> selectAdmin(Member member) throws Exception;
	
	// 마이페이지 회원정보 수정
	public void myUpdateMember(Member member) throws Exception;
}
