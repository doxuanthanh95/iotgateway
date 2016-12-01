package iot.gateway.dto;

public class MapDto {
	private Integer mapId;
	private Integer numberNode;
	public MapDto(Integer mapId, Integer numberNode) {
		super();
		this.mapId = mapId;
		this.numberNode = numberNode;
	}
	public Integer getMapId() {
		return mapId;
	}
	public void setMapId(Integer mapId) {
		this.mapId = mapId;
	}
	public Integer getNumberNode() {
		return numberNode;
	}
	public void setNumberNode(Integer numberNode) {
		this.numberNode = numberNode;
	}
}
