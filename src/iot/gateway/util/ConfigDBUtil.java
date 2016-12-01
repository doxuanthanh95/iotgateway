package iot.gateway.util;

import java.io.IOException;
import java.util.Properties;

public class ConfigDBUtil {
	private String dbUser;
	private String dbPassword;
	private String dbUrl;
	private Integer dbMaxConn;

	private static ConfigDBUtil config = new ConfigDBUtil();

	public static ConfigDBUtil getInstance() {
		return config;
	}

	public ConfigDBUtil() {
		this.init();
	}

	public void init() {
		Properties p = new Properties();
		try {
			p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("iot/gateway/conf/database_info.properties"));
			this.dbUser = p.getProperty("DB_USER");
			this.dbPassword = p.getProperty("DB_PASSWORD");
			this.dbUrl = p.getProperty("DB_URL");
			this.dbMaxConn = Integer.parseInt(p.getProperty("DB_MAX_CONNECTION"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getDbUser() {
		return dbUser;
	}

	public void setDbUserName(String dbUser) {
		this.dbUser = dbUser;
	}

	public String getDbPassword() {
		return dbPassword;
	}

	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}

	public String getDbUrl() {
		return dbUrl;
	}

	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}

	public Integer getDbMaxConn() {
		return dbMaxConn;
	}

	public void setDbMaxConn(Integer dbMaxConn) {
		this.dbMaxConn = dbMaxConn;
	}
}
