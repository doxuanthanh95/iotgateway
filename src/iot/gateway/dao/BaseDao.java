package iot.gateway.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import iot.gateway.util.ConnPoolUtil;

public interface BaseDao {
	public ConnPoolUtil getConnectionPool();

	public void releaseConnection();
	
	public void refreshConnection();

	public void refreshConnectionPool();

	public boolean add(PreparedStatement pre);

	public boolean edit(PreparedStatement pre);

	public boolean del(PreparedStatement pre);

	public ResultSet get(PreparedStatement pre);

	public ResultSet get(String sql);
}
