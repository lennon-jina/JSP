package model;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.ConnectionPool;

// 비지니스 로직을 처리하는 부분
public class UserService {
	private UserDAO dao = UserDAO.getInstance();
	private ConnectionPool cp = ConnectionPool.getInstance();
	
	private static UserService instance = new UserService();
	public static UserService getInstance() {
		return instance;
	}
	
	private UserService() { };
	// 로그인 처리
	public UserVO loginUser(String id, String pw) {
		Connection conn = cp.getConnection();
		UserVO user;
		try {
			user = dao.selectUser(conn, id);
			if(user != null && user.getUserPw().equals(pw)) {
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) cp.releaseConnection(conn);   // 사용 완료 후 돌려주기
		}
		return null;
	}
	// 회원 정보
	public UserVO userInfo(String id) {
		Connection conn = cp.getConnection();
		try {
			return dao.selectUser(conn, id);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) cp.releaseConnection(conn);  
		}
		return null;
	}
	// 회원가입
	public int insertUser(UserVO vo) {
		Connection conn = cp.getConnection();
		try {
			return dao.insertUser(conn, vo);
		}catch (SQLException e) {
			System.out.println("중복된 아이디!?");
			e.printStackTrace();
		} finally {
			if(conn != null) cp.releaseConnection(conn);
		}
		return 0;
	}
	// 게시글 조회
	public ArrayList<BbsVO> bbsList() {
		Connection conn = cp.getConnection();
		try {
			return dao.bbsList(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(conn != null) cp.releaseConnection(conn);
		}
		return null;
	}
	// 회원 정보 수정
	public int updateUser(UserVO vo) {
		Connection conn = cp.getConnection();
		try {
			return dao.updateUser(conn, vo);
		} catch (SQLException e) {
			System.out.println("변경되지 않음.");
			e.printStackTrace();
		} finally {
			if(conn != null) cp.releaseConnection(conn);
		}
		return 0;
	}
}
