package iot.gateway.util;

import javax.servlet.http.HttpSession;

import iot.gateway.dto.UserDto;

public class MyUtil {
	public static void storeLoginedUser(HttpSession session, UserDto loginedUser) {
		session.setAttribute("loginedUser", loginedUser);
	}

	public static UserDto getLoginedUser(HttpSession session) {
		UserDto loginedUser = (UserDto) session.getAttribute("loginedUser");
		return loginedUser;
	}
}
