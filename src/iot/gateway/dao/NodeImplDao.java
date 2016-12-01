package iot.gateway.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import iot.gateway.dto.NodeDto;
import iot.gateway.util.ConnPoolUtil;

public class NodeImplDao extends BaseImplDao implements NodeDao{

	public NodeImplDao(ConnPoolUtil cp) {
		super(cp);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ResultSet getNodeByMapId(Integer mapId) {
		String sql = "SELECT * FROM node WHERE mapid = ?";
		PreparedStatement pstm;
		try {
			pstm = this.connection.prepareStatement(sql);
			pstm.setInt(1, mapId);
			return this.get(pstm);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ResultSet getNodeById(Integer nodeId) {
		String sql = "SELECT * FROM node WHERE nodeid = ?";
		PreparedStatement pstm;
		try {
			pstm = this.connection.prepareStatement(sql);
			pstm.setInt(1, nodeId);
			return this.get(pstm);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateNode(NodeDto nodeDto) {
		String sql = "UPDATE node SET temp = ?, humi = ?, light = ?, status = ? WHERE nodeid = ?";
		try {
			PreparedStatement pstm = this.connection.prepareStatement(sql);
			pstm.setFloat(1, nodeDto.getTemp());
			pstm.setFloat(2, nodeDto.getHumi());
			pstm.setFloat(3, nodeDto.getLight());
			pstm.setInt(4, nodeDto.getStatus());
			pstm.setInt(5, nodeDto.getNodeId());
			return this.executeUpdate(pstm);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

}
