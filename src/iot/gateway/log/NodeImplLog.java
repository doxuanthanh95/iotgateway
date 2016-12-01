package iot.gateway.log;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import iot.gateway.dao.MapDao;
import iot.gateway.dao.MapImplDao;
import iot.gateway.dao.NodeDao;
import iot.gateway.dao.NodeImplDao;
import iot.gateway.dto.NodeDto;
import iot.gateway.util.ConnPoolUtil;

public class NodeImplLog implements NodeLog {
	private NodeDao nodeDao;

	public NodeImplLog(ConnPoolUtil cp) {
		this.nodeDao = new NodeImplDao(cp);
	}

	public ConnPoolUtil getConnectionPool() {
		return this.nodeDao.getConnectionPool();
	}

	public void refreshConnection(){
		this.nodeDao.refreshConnection();
	}
	public void releaseConnection() {
		this.nodeDao.releaseConnection();
	}

	public void refreshConnectionPool() {
		this.nodeDao.refreshConnectionPool();
	}

	@Override
	public List<NodeDto> getNodeByMapId(Integer mapId) {
		ResultSet rs = this.nodeDao.getNodeByMapId(mapId);
		try {
			List<NodeDto> listNode = new ArrayList<>();
			while (rs.next()) {
				listNode.add(new NodeDto(rs.getInt("nodeid"), rs.getFloat("temp"), rs.getFloat("humi"),
						rs.getFloat("light"), rs.getInt("mapid"), rs.getInt("status")));
			}
			return listNode;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public NodeDto getNodeById(Integer nodeId) {
		ResultSet rs = this.nodeDao.getNodeById(nodeId);
		try {
			if (rs.next()) {
				return new NodeDto(rs.getInt("nodeid"), rs.getFloat("temp"), rs.getFloat("humi"),
						rs.getFloat("light"), rs.getInt("mapid"), rs.getInt("status"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateNode(NodeDto nodeDto) {
		// TODO Auto-generated method stub
		return this.nodeDao.updateNode(nodeDto);
	}
}
