package iot.gateway.log;

import java.util.List;
import iot.gateway.dto.NodeDto;

public interface NodeLog {
	public List<NodeDto> getNodeByMapId(Integer mapId);
	public NodeDto getNodeById(Integer nodeId);
	public boolean updateNode(NodeDto nodeDto);
}
