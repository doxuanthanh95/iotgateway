package iot.gateway.log;

import iot.gateway.dto.UserDto;

public interface UserLog {
	public UserDto getUserById(Integer userId);
}
