package iot.gateway.log;

import java.util.List;
import iot.gateway.dto.MapDto;

public interface MapLog {
	public List<MapDto> getAllMap();

	public MapDto getMapById(Integer mapId);
}
