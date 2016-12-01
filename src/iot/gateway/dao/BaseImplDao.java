package iot.gateway.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import iot.gateway.util.ConnPoolImplUtil;
import iot.gateway.util.ConnPoolUtil;

public class BaseImplDao implements BaseDao {
	private ConnPoolUtil connectionPool;
	protected Connection connection;

	public BaseImplDao(ConnPoolUtil cp) {
	        if (cp == null) {
	            this.connectionPool = new ConnPoolImplUtil();
	        } else {
	            this.connectionPool = cp;
	        }
	        try {
	            this.connection = connectionPool.getConnFromPool();
	            if (this.connection.getAutoCommit()) {
	                this.connection.setAutoCommit(false);
	            }
	        } catch (SQLException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }

	@Override
	public ConnPoolUtil getConnectionPool() {
		return this.connectionPool;
	}

	@Override
	public void releaseConnection() {
		try {
			this.connectionPool.releaseConnToPool(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void refreshConnection() {
		// TODO Auto-generated method stub
		try {
			this.connectionPool.refreshConnInPool(this.connection);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public void refreshConnectionPool() {
		try {
			this.connectionPool.refreshConnInPool(this.connection);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public boolean executeUpdate(PreparedStatement pre) {
		if (pre != null) {
			try {
				int numRow = pre.executeUpdate();
				if (numRow == 0) {
					this.connection.rollback();
				} else {
					this.connection.commit();
					return true;
				}
			} catch (SQLException e) {
				try {
					this.connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
			return false;
		}
		return false;
	}

	@Override
	public boolean add(PreparedStatement pre) {
		return executeUpdate(pre);
	}

	@Override
	public boolean edit(PreparedStatement pre) {
		return executeUpdate(pre);
	}

	@Override
	public boolean del(PreparedStatement pre) {
		return executeUpdate(pre);
	}

	@Override
	public ResultSet get(PreparedStatement pre) {
		try {
			return pre.executeQuery();
		} catch (SQLException e) {
			try {
				this.connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultSet get(String sql) {
		try {
			PreparedStatement pre = this.connection.prepareStatement(sql);
			return this.get(pre);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


}
