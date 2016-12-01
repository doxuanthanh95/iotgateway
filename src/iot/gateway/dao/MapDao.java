package iot.gateway.dao;

import java.sql.ResultSet;

public interface MapDao extends BaseDao {
	public ResultSet getAllMap();
	public ResultSet getMapById(Integer mapId);
}
