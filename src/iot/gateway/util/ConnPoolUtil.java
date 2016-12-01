package iot.gateway.util;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnPoolUtil {
	public void initConnPool();

	public Connection getConnFromPool() throws ClassNotFoundException, SQLException;

	public void releaseConnToPool(Connection conn) throws SQLException;
	
	public void refreshConnInPool(Connection conn) throws SQLException, ClassNotFoundException;
}
