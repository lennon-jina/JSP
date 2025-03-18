package model;
// value object
public class UserVO {
	private String userId;   // camel 표기법 (테이블에서 사용되는 _ 를 기준으로)
	private String userPw;	 // USER_PW <-- userPw 언더바 뒤 첫글자 대문자
	private String userNm;   
	private String userYn;
	
	// 1. 기본 생성자
	// 2. setter, getter
	// 3. toString

		
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public String getUserYn() {
		return userYn;
	}
	public void setUserYn(String userYn) {
		this.userYn = userYn;
	}
	@Override
	public String toString() {
		return "UserVO [userId=" + userId + ", userPw=" + userPw + ", userNm=" + userNm + ", userYn=" + userYn + "]";
	}
	public UserVO() {
		
	}
	
}
