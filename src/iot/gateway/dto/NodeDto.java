package iot.gateway.dto;

public class NodeDto {
	private Integer nodeId;
	private Float temp;
	private Float humi;
	private Float light;
	private Integer mapId;
	private Integer status;
	public NodeDto(){
		this.nodeId=0;
		this.mapId=0;
		this.status = 1;
	}
	public NodeDto(Integer nodeId, Float temp, Float humi, Float light, Integer mapId, Integer status) {
		super();
		this.nodeId = nodeId;
		this.temp = temp;
		this.humi = humi;
		this.light = light;
		this.mapId = mapId;
		this.status = status;
	}
	public Integer getNodeId() {
		return nodeId;
	}
	public void setNodeId(Integer nodeId) {
		this.nodeId = nodeId;
	}
	public Float getTemp() {
		return temp;
	}
	public void setTemp(Float temp) {
		this.temp = temp;
	}
	public Float getHumi() {
		return humi;
	}
	public void setHumi(Float humi) {
		this.humi = humi;
	}
	public Float getLight() {
		return light;
	}
	public void setLight(Float light) {
		this.light = light;
	}
	public Integer getMapId() {
		return mapId;
	}
	public void setMapId(Integer mapId) {
		this.mapId = mapId;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public void show(){
		System.out.println("Temperature: " + this.getTemp() + " | Humirity: " + this.getHumi() + " | Light: " + this.getLight());
	}
	
}
