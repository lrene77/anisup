package anisup.service;

import java.util.List;

import anisup.model.File;

public interface FileService {
	/**
	 * 파일 정보를 저장
	 * @param file
	 * @throws Exception
	 */
	public void addListFile(File file) throws Exception;
	
	/**
	 * 하나의 listboard 게시물에 종속된 파일 목록을 조회한다.
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public List<File> selectListFileList(File file) throws Exception;
	
	/** 
	 * 후원 파일 정보 저장
	 * @param file
	 * @throws Exception
	 */
	public void addSupFile(File file) throws Exception;
	
	/**
	 * 애니 파일 정보를 저장
	 * @param file
	 * @throws Exception
	 */
	public void addAniFile(File file) throws Exception;
	
	public List<File> selectAniList(File file) throws Exception;
	
	/**
	 * 하나의 listboard에 종속된 파일 목록을 삭제
	 * @param file
	 * @throws Exception
	 */
	public void deleteListFileAll(File file) throws Exception;
	
	/**
	 * 하나의 단일 파일에 대한 정보를 조회
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public File selectFile(File file) throws Exception;
	
	/**
	 * 하나의 단일 파일 정보를 삭제
	 * @param file
	 * @throws Exception
	 */
	public void deleteFile(File file) throws Exception;
	
	/**
	 * 하나의 후원 게시글에 속한 파일목록을 조회한다. 
	 * @param file
	 * @return 
	 * @throws Exception
	 */
	public List<File> selectListSupList(File file) throws Exception;
}
