package anisup.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

import anisup.model.Member;
import anisup.service.MemberService;

public class MemberServiceImpl implements MemberService {

	Logger logger;
	SqlSession sqlSession;

	public MemberServiceImpl(SqlSession sqlSession, Logger logger) {
		this.sqlSession = sqlSession;
		this.logger = logger;
	}

	@Override
	public void selectUserIdCount(Member member) throws Exception {
		// 아이디중복검사
		try {
			int result = sqlSession.selectOne("MemberMapper.selectUserIdCount", member);

			if (result > 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("이미 사용중인 아이디 입니다.");
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("아이디 중복검사에 실패했습니다.");
		}
	}

	@Override
	public void selectEmailCount(Member member) throws Exception {
		// 이메일 중복검사
		try {
			int result = sqlSession.selectOne("MemberMapper.selectEmailCount", member);

			if (result > 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("이미 사용중인 이메일 입니다.");
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("이메일 중복검사에 실패했습니다.");
		}
	}

	@Override
	public void insertMember(Member member) throws Exception {
		// 회원가입
		selectUserIdCount(member);
		selectEmailCount(member);

		try {
			int result = sqlSession.insert("MemberMapper.addMember", member);
			if (result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("저장된 회원정보가 없습니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("회원가입에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
	}

	@Override
	public Member selectLoginInfo(Member member) throws Exception {
		// 로그인

		Member result = null;

		try {
			result = sqlSession.selectOne("MemberMapper.selectLoginInfo", member);
			if (result == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("아이디나 비밀번호가 잘못되었습니다.");
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("로그인에 실패했습니다.");
		}
		return result;
	}

	@Override
	public void updateMemberPasswordByEmail(Member member) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void selectMemberPasswordCount(Member member) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteMember(Member member) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateMember(Member member) throws Exception {
		//회원정보 수정
		
		try{
			int result = sqlSession.update("MemberMapper.editMember",member);
			if(result == 0){
				throw new NullPointerException();
			}
		}catch(NullPointerException e){
			sqlSession.rollback();
			throw new Exception("변경된 회원정보가 없습니다.");
		}catch (Exception e) {
			sqlSession.rollback();
			throw new Exception("회원정보 수정에 실패했습니다.");
		}finally {
			sqlSession.commit();
		}

	}

	@Override
	public Member selectMember(Member member) throws Exception {
		//일련번호에 의한 회원정보 조회
		
		Member result = null;
		
		try{
			result = sqlSession.selectOne("MemberMapper.selectMember",member);
			if(result==null){
				throw new NullPointerException();
			}
		}catch(NullPointerException e){
			throw new Exception("조회된 회원 정보가 없습니다.");
		}catch(Exception e){
			logger.error(e.getLocalizedMessage());
			throw new Exception("회원정보 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public Member selectIdSear(Member member) throws Exception {
		//아이디 찾기
		Member result = null;
		
		try {
			result = sqlSession.selectOne("MemberMapper.selectIdSear", member);
			if (result == null) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			throw new Exception("가입된 아이디가 아닙니다.");
		} catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("아이디 찾기에 실패했습니다.");
		}
		return result;
	}

	@Override
	public void updateMemberPassword(Member member) throws Exception {
		//비밀번호 찾기
		
		try{
			int result=sqlSession.update("MemberMapper.updateMemberPassword",member);
			if(result == 0){
				throw new NullPointerException();
			}
		}catch(NullPointerException e){
			sqlSession.rollback();
			throw new Exception("가입된 아이디가 아닙니다.");
		}catch(Exception e){
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("비밀번호 찾기에 실패했습니다.");
		}finally {
			sqlSession.commit();
		}
	}

	@Override
	public List<Member> selectAdmin(Member member) throws Exception {
		//관리자 회원 리스트 조회
		
		List<Member> result = null;
		
		try{
			result=sqlSession.selectList("MemberMapper.selectAdmin", member);
			if(result == null){
				throw new NullPointerException();
			}
		}catch(NullPointerException e){
			throw new Exception("조회된 회원이 없습니다.");
		}catch (Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("회원 조회에 실패했습니다.");
		}
		return result;
	}
	
	
	@Override
	public void myUpdateMember(Member member) throws Exception {
		try {
			int result = sqlSession.update("MemberMapper.updateMember", member);
			if (result == 0) {
				throw new NullPointerException();
			}
		} catch (NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("변경된 회원정보가 없습니다.");
		} catch (Exception e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("회원정보 수정에 실패했습니다.");
		} finally {
			sqlSession.commit();
		}
	}	
}
