package iot.gateway.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import iot.gateway.util.ConnPoolUtil;


public class UserImplDao extends BaseImplDao implements UserDao{
	public UserImplDao(ConnPoolUtil cp){
		super(cp);
	}

	@Override
	public ResultSet getUserById(int userId) {
		String sql = "SELECT * FROM user WHERE userid = ?";
		try {
			PreparedStatement pstm = this.connection.prepareStatement(sql);
			pstm.setInt(1, userId);
			return this.get(pstm);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
