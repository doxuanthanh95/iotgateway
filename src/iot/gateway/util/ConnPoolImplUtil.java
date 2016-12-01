package iot.gateway.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Stack;

public class ConnPoolImplUtil implements ConnPoolUtil {
	private Stack<Connection> pool;

	private static ConnPoolImplUtil connetionPool = new ConnPoolImplUtil();

	public static ConnPoolImplUtil getInstance() {
		return connetionPool;
	}

	public ConnPoolImplUtil() {
		this.pool = new Stack<>();
		this.initConnPool();
	}

	public Integer getNumberConnection() {
		return pool.size();
	}

	@Override
	public void initConnPool() {

		try {
			while (!this.checkConnPoolIsFull()) {
				Connection newConn = this.createNewConnForPool();
				this.pool.push(newConn);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public synchronized Connection getConnFromPool() throws ClassNotFoundException, SQLException {
		System.out.println("So connection sau khi lay di: " + this.getNumberConnection());
		return this.pool.isEmpty() ? this.createNewConnForPool() : this.pool.pop();
	}

	@Override
	public synchronized void releaseConnToPool(Connection conn) throws SQLException {
		this.pool.push(conn);
		System.out.println("So connection sau khi tra lai: " + this.getNumberConnection());
	}

	public Connection createNewConnForPool() throws ClassNotFoundException, SQLException {
		ConfigDBUtil config = ConfigDBUtil.getInstance();
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(config.getDbUrl(), config.getDbUser(), config.getDbPassword());
		return conn;
	}

	public synchronized boolean checkConnPoolIsFull() {
		final int MAX_POOL_SIZE = ConfigDBUtil.getInstance().getDbMaxConn();
		return (this.pool.size() < MAX_POOL_SIZE) ? false : true;
	}

	@Override
	public synchronized void refreshConnInPool(Connection conn) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		if (!this.pool.empty()) {
			
			if (this.pool.peek().equals(conn)) {
				this.pool.pop().close();
				this.pool.push(this.createNewConnForPool());
				//System.out.println("So connection sau khi refresh: " + this.getNumberConnection());
			} else {
				System.out.println("Connection is not same");
			}
		}
	}

}
