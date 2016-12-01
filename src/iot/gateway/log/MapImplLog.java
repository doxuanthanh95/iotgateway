package iot.gateway.log;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import iot.gateway.dao.MapDao;
import iot.gateway.dao.MapImplDao;
import iot.gateway.dto.MapDto;
import iot.gateway.util.ConnPoolUtil;

public class MapImplLog implements MapLog {

	private MapDao mapDao;

	public MapImplLog(ConnPoolUtil cp) {
		this.mapDao = new MapImplDao(cp);
	}

	public ConnPoolUtil getConnectionPool() {
		return this.mapDao.getConnectionPool();
	}

	public void releaseConnection() {
		this.mapDao.releaseConnection();
	}
	
	public void refreshConnection(){
		this.mapDao.refreshConnection();
	}

	public void refreshConnectionPool() {
		this.mapDao.refreshConnectionPool();
	}

	@Override
	public List<MapDto> getAllMap() {

		ResultSet rs = this.mapDao.getAllMap();
		try {
			List<MapDto> listMap = new ArrayList<>();
			while (rs.next()) {
				listMap.add(new MapDto(rs.getInt("mapid"), rs.getInt("numbernode")));
			}
			return listMap;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MapDto getMapById(Integer mapId) {
		ResultSet rs = this.mapDao.getMapById(mapId);
		try {
			if (rs.next()) {
				return new MapDto(rs.getInt("mapid"), rs.getInt("numbernode"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		return null;
	}
}
