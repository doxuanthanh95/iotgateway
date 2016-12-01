package iot.gateway.dto;

public class UserDto {
	private Integer userId;
	private String userName;
	private String password;
	private Integer roles;
	
	public UserDto(){
		
	}
	
	public UserDto(Integer userId, String userName, String password, Integer roles){
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.roles = roles;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getRoles() {
		return roles;
	}

	public void setRoles(Integer roles) {
		this.roles = roles;
	}
	
	
}
