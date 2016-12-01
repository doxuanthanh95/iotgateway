package iot.gateway.dao;

import java.sql.ResultSet;

public interface UserDao extends BaseDao{
    public ResultSet getUserById(int userId);
}
