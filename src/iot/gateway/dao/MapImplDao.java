package iot.gateway.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import iot.gateway.util.ConnPoolUtil;

public class MapImplDao extends BaseImplDao implements MapDao{

	public MapImplDao(ConnPoolUtil cp) {
		super(cp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultSet getAllMap() {
		String sql = "SELECT * FROM map";
		return this.get(sql);
	}

	@Override
	public ResultSet getMapById(Integer mapId) {
		String sql = "SELECT * FROM map WHERE mapid = ?";
		try {
			PreparedStatement pstm = this.connection.prepareStatement(sql);
			pstm.setInt(1, mapId);
			return this.get(pstm);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
