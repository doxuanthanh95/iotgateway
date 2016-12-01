package iot.gateway.dao;

import java.sql.ResultSet;

import iot.gateway.dto.NodeDto;

public interface NodeDao extends BaseDao {
	public ResultSet getNodeByMapId(Integer mapId);
	public ResultSet getNodeById(Integer nodeId);
	public boolean updateNode(NodeDto nodeDto);
}
