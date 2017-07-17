package work.model.service;

import java.util.ArrayList;

import work.model.dao.MemberDao;
import work.model.dto.Member;

public class MemberService {
	// Member 테이블 DAO 하기위한 객체 생성
	private MemberDao dao = new MemberDao();
	
	/** 등록 회원수 조회 메서드 */
	public int getCount() {
		return 0;
	}
	
	/**
	 * 회원 아이디 존재 유무 및 저장위치 조회 메서드
	 * @param memberId 조회 회원 아이디
	 * @return 존재시 true, 미존재시 false 반환
	 */
	public boolean isExist(String memberId) {
		return false;
	}
	
	/**
	 * 회원 등록
	 * @param dto 등록 회원객체
	 * @return 등록적용 행수 반환
	 */
	public int addMember(Member dto) {
		return dao.insert(dto);
	}
	
	
	/**
	 * 회원 정보 조회
	 * @param memberId 조회 회원 아이디
	 * @return 조회회원 객체, 미존재시 null 반환
	 */
	public Member getMember(String memberId) {
		return dao.selectOne(memberId);
	}
	
	/**
	 * 내정보변경
	 * @param dto 변경 회원객체 정보
	 * @return 변경적용 행수 반환
	 */
	public int updateMember(Member dto) {
		return dao.update(dto);
	}
	
	/**
	 * 암호 변경
	 * @param memberId 회원 아이디
	 * @param memberPw 회원 암호
	 * @param modifyMemberPw 회원 변경 암호
	 */
	public void updateMemberPw(String memberId, String memberPw, String modifyMemberPw) {
	}
	
	/**
	 * 회원 탈퇴
	 * @param memberId 탈퇴 회원 아이디
	 * @return 탈퇴적용 행수 반환
	 */
	public int deleteMember(String memberId) {
		return dao.delete(memberId);
	}
	
	/**
	 * 전체회원 조회
	 * @return 전체회원 객체정보
	 */
	public ArrayList<Member> getMember() {
		return dao.selectList();
	}
	
	public ArrayList<Member> getMemberGrade(String grade) {
		return dao.selectList(grade);
	}
	
}
