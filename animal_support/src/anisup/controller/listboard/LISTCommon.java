package anisup.controller.listboard;

public class LISTCommon {
	private static LISTCommon current = null;
	
	public static LISTCommon getInstance() {
		if(current == null) {
			current = new LISTCommon();
		}
		return current;
	}
	
	public static void freeInstance() {
		current = null;
	}
	
	private LISTCommon() {
		super();
	}
	
	/**
	 * 카테고리 값을 추출하여 허용된 게시판인지 판별
	 * 허용된 게시판일 경우 게시판의 이름을 리턴. 그렇지 않을 경우 예외 발생
	 * @param category
	 * @return 게시판 이름
	 * @throws Exception
	 */
	public String getListName(String listcate) throws Exception{
		String listName = null;
		
		if(listcate != null) {
			if(listcate.equals("n")) {
				listName = "공지사항";
			}else if(listcate.equals("q")) {
				listName = "Q&A";
			}else if(listcate.equals("s")) {
				listName = "후원후기";
			}else if(listcate.equals("a")) {
				listName = "입양후기";
			}
		}
		
		if(listName == null) {
			throw new Exception ("존재하지 않는 게시판입니다.");
		}
		return listName;
	}
	
	public String getSmallName1(String listcate) throws Exception{
		String smallName1 = null;
		
		if(listcate != null) {
			if(listcate.equals("n")) {
				smallName1 = "공지사항이";
			}else if(listcate.equals("q")) {
				smallName1 = "질문/답변이";
			}else if(listcate.equals("s")) {
				smallName1 = "후원후기가";
			}else if(listcate.equals("a")) {
				smallName1 = "입양후기가";
			}
		}
		
		if(smallName1 == null) {
			throw new Exception ("존재하지 않는 게시판입니다.");
		}
		return smallName1;
	}
	
	public String getSmallName2(String listcate) throws Exception{
		String smallName2 = null;
		
		if(listcate != null) {
			if(listcate.equals("n")) {
				smallName2 = "활동";
			}else if(listcate.equals("q")) {
				smallName2 = "활동";
			}else if(listcate.equals("s")) {
				smallName2 = "후원";
			}else if(listcate.equals("a")) {
				smallName2 = "입양";
			}
		}
		
		if(smallName2 == null) {
			throw new Exception ("존재하지 않는 게시판입니다.");
		}
		return smallName2;
	}
}
