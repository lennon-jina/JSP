package jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

/**
 * class Name   : ConnectionPool
 * Author       : jina
 * Created Date : 2025. 3. 12.
 * version      : 1.0
 * Purpose      : java 기초
 * Description  : maxConn 수량 만큼 접속 객체를 생성해서 풀(pool)에 관리하는 클래스
 */
public class ConnectionPool {
	// 동기화 Synchronized 가 적용된 ArrayList
	private static Vector<Connection> pooL = new Vector<>();
	private static ConnectionPool instance = new ConnectionPool();
	// 싱글톤
	public static ConnectionPool getInstance() {
		return instance;
	}
	private ConnectionPool() {
		try {
			initPool();  // 클래스를 인스턴스화 할 때 init을 호출 (접속해놓음)
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// 외부에서 데이터베이스 사용 요청시
	public synchronized Connection getConnection() {
		if(pooL.size() == 0) {
			try {
				System.out.println("가능한 연결이 없어요... wait..");
				wait();  // 연결이 반환될 때 까지 대기
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Connection conn = pooL.get(0);
		pooL.remove(0);
		return conn;
	}
	// 사용후 반환
	public synchronized void releaseConnection(Connection conn) {
		System.out.println("사용 후 pool에 담기");
		pooL.add(conn);
		notifyAll();  // 대기중인 스레드 깨우기 
	}
	
	// 풀 초기화 메서드
	private synchronized void initPool() throws SQLException {
		ConnectionFactory factory = ConnectionFactory.getInstance();
		int maxConn = factory.getMaxConn();
		// maxConn 수량만큼 db 접속
		for(int i = 0; i < maxConn; i++) {
			pooL.add(factory.getConnection());
		}
	}
	// 풀 db 연결 닫기
	private synchronized void destroyPool() throws SQLException {
		for(int i = 0; i < pooL.size(); i ++) {
			pooL.get(i).close();  // 하나씩 닫기
		}
		pooL.clear();
	}
}
