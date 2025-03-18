package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// DAO Data Access Object
public class UserDAO {

	private static UserDAO instance = new UserDAO();
	public static UserDAO getInstance() {
		return instance;
	};
	private UserDAO() {};
	// user 조회
	public UserVO selectUser(Connection conn, String id) throws SQLException {
		// DB 조회하는 부분
		StringBuffer query = new StringBuffer();
		query.append(" SELECT user_id");
		query.append("      ,user_pw");
		query.append("      ,user_nm");
		query.append(" FROM tb_user");
		query.append(" WHERE user_yn = 'Y' ");
		query.append(" AND user_id = ? ");
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		// 결과를 리턴
		UserVO vo = new UserVO();
		while(rs.next()) {
			vo.setUserId(rs.getString("user_id"));
			vo.setUserPw(rs.getString("user_pw"));
			vo.setUserNm(rs.getString("user_nm"));
		}
		if(ps != null) ps.close();
		if(rs != null) rs.close();
		return vo;
	}
	// 회원가입
	public int insertUser(Connection conn, UserVO vo) throws SQLException {
		StringBuffer query = new StringBuffer();
		query.append(" INSERT INTO tb_user(user_id, user_pw, user_nm, user_yn)");
		query.append(" VALUES(?, ?, ?, 'Y')");
		// insert 쿼리
		PreparedStatement ps = conn.prepareStatement(query.toString());
		int idx = 1;
		ps.setString(idx++, vo.getUserId());
		ps.setString(idx++, vo.getUserPw());
		ps.setString(idx++, vo.getUserNm());
		int cnt = ps.executeUpdate();
		if(ps != null) ps.close();
		
		// 정상적으로 insert는 1
		return cnt;
		
	}
	// bbs 조회
	public ArrayList<BbsVO> bbsList(Connection conn) throws SQLException {
		// DB 조회하는 부분
		StringBuffer query = new StringBuffer();
		query.append(" SELECT discussion_id");
		query.append("     , item_code");
		query.append("     , title");
		query.append("     , writer_id");
		query.append("     , read_count");
		query.append(" FROM member.stock_bbs");
		PreparedStatement ps = conn.prepareStatement(query.toString());
		ResultSet rs = ps.executeQuery();
		// 결과를 리턴
		ArrayList<BbsVO> bbsArr = new ArrayList<BbsVO>();
		while(rs.next()) {
			BbsVO bbs = new BbsVO();
			bbs.setDiscussionId("discussion_id");
			bbs.setItemCode(rs.getString("item_code"));
			bbs.setTitle(rs.getString("title"));
			bbs.setWriterId(rs.getString("writer_id"));
			bbs.setReadCount(rs.getString("read_count"));
			bbsArr.add(bbs);
		}
		if(ps != null) ps.close();
		if(rs != null) rs.close();
		return bbsArr;
	}
	// 회원 정보 수정
	public int updateUser(Connection conn, UserVO user) throws SQLException {
		StringBuffer query = new StringBuffer();
		// update로 '입력 아이디의 이름을 수정하는'
		query.append(" UPDATE tb_user");
		query.append(" SET user_nm = ? ");
		query.append(" WHERE user_id = ?");
		
		PreparedStatement ps = conn.prepareStatement(query.toString());
		ps.setString(1, null);
		ps.setString(2, null);
		int cnt = ps.executeUpdate();
		if(ps != null) ps.close();
		return cnt;
	}
}
