package anisup.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.Logger;

import anisup.model.File;
import anisup.service.FileService;

public class FileServiceImpl implements FileService{
	Logger logger;
	SqlSession sqlSession;
	
	public FileServiceImpl(SqlSession sqlSession, Logger logger) {
		this.logger = logger;
		this.sqlSession = sqlSession;
	}

	public void addListFile(File file) throws Exception {
		// TODO Auto-generated method stub
		try {
			int result = sqlSession.insert("FileMapper.addListFile", file);
			if(result == 0) {
				throw new NullPointerException();
			}
		}catch(NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("저장된 파일 정보가 없습니다.");
		}catch(Exception e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("파일정보 등록에 실패했습니다.");
		}finally {
			sqlSession.commit();
		}
	}
	
	@Override
	public List<File> selectListFileList(File file) throws Exception {
		// TODO Auto-generated method stub
		List<File> result = null;
		
		try {
			result = sqlSession.selectList("FileMapper.selectListFileList", file);
		}catch(Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("파일 정보 조회에 실패했습니다.");
		}
		
		return result;
	}

	@Override
	public void addSupFile(File file) throws Exception {
		try {
			int result = sqlSession.insert("FileMapper.addSupFile", file);
			if(result == 0) {
				throw new NullPointerException();
			}
		}catch(NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("저장된 파일 정보가 없습니다.");
		}catch(Exception e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("파일정보 등록에 실패했습니다.");
		}finally {
			sqlSession.commit();
		}		
	}
	
	public void addAniFile(File file) throws Exception {
		// TODO Auto-generated method stub
		try {
			int result = sqlSession.insert("FileMapper.addAniFile", file);
			if(result == 0) {
				throw new NullPointerException();
			}
		}catch(NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("저장된 파일 정보가 없습니다.");
		}catch(Exception e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("파일정보 등록에 실패했습니다.");
		}finally {
			sqlSession.commit();
		}
	}
	
	@Override
	public List<File> selectAniList(File file) throws Exception {
		// TODO Auto-generated method stub
		List<File> result = null;
		
		try {
			result = sqlSession.selectList("FileMapper.selectAniList", file);
		}catch(Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("파일 정보 조회에 실패했습니다.");
		}
		
		return result;
	}

	@Override
	public void deleteListFileAll(File file) throws Exception {
		// TODO Auto-generated method stub
		try {
			sqlSession.delete("FileMapper.deleteListFileAll", file);
		}catch(Exception e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("첨부파일 정보 삭제에 실패했습니다.");
		}finally {
			sqlSession.commit();
		}
	}

	@Override
	public File selectFile(File file) throws Exception {
		// TODO Auto-generated method stub
		File result = null;
		try {
			result = sqlSession.selectOne("FileMapper.selectFile", file);
			if(result == null) {
				throw new NullPointerException();
			}
		}catch(NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("존재하지 않는 파일에 대한 요청입니다.");
		}catch(Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("파일 정보 조회에 실패했습니다.");
		}
		return result;
	}

	@Override
	public void deleteFile(File file) throws Exception {
		// TODO Auto-generated method stub
		try {
			int result = sqlSession.delete("FileMapper.deleteFile", file);
			if(result == 0) {
				throw new NullPointerException();
			}
		}catch(NullPointerException e) {
			sqlSession.rollback();
			throw new Exception("삭제된 파일 정보가 없습니다.");
		}catch(Exception e) {
			sqlSession.rollback();
			logger.error(e.getLocalizedMessage());
			throw new Exception("파일 정보 조회에 실패했습니다.");
		}finally {
			sqlSession.commit();
		}
	}
	
	@Override
	public List<File> selectListSupList(File file) throws Exception {
		List<File> result = null;
		try {
			result = sqlSession.selectList("FileMapper.selectListSupList", file);
		}catch(Exception e) {
			logger.error(e.getLocalizedMessage());
			throw new Exception("파일 정보 조회에 실패했습니다.");
		}
		return result;
	}

}
