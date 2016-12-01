package iot.gateway.log;
import java.sql.ResultSet;
import java.sql.SQLException;

import iot.gateway.dao.UserDao;
import iot.gateway.dao.UserImplDao;
import iot.gateway.dto.UserDto;
import iot.gateway.util.ConnPoolUtil;

public class UserImplLog implements UserLog {

	private UserDao userDao;

	public UserImplLog(ConnPoolUtil cp) {
		this.userDao = new UserImplDao(cp);
	}

	public ConnPoolUtil getConnectionPool() {
		return this.userDao.getConnectionPool();
	}

	public void releaseConnection() {
		this.userDao.releaseConnection();
	}

	public void refreshConnectionPool() {
		this.userDao.refreshConnectionPool();
	}

	@Override
	public UserDto getUserById(Integer userId) {
		// TODO Auto-generated method stub
		ResultSet rs = this.userDao.getUserById(userId);
		try {
			if (rs.next()) {
				return new UserDto(rs.getInt("userid"), rs.getString("username"), rs.getString("password"),
						rs.getInt("roles"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
