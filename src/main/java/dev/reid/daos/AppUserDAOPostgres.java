package dev.reid.daos;

import dev.reid.app.App;
import dev.reid.entity.AppUser;
import dev.reid.utils.ConnectionUtil;

import java.sql.*;
import java.util.List;

public class AppUserDAOPostgres implements AppUserDAO{

    @Override
    public AppUser getAppUserByUsername(String username) {
        try(Connection connection = ConnectionUtil.createConnection())
        {
            String sql = "select * from appUser where username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, username);
            ResultSet rs = preparedStatement.executeQuery();
            rs.next();

            AppUser appUser = new AppUser();
            appUser.setUser_id(rs.getInt("user_id"));
            appUser.setUsername(rs.getString("username"));
            appUser.setPassword(rs.getString("password"));
            appUser.setRole(rs.getString("role"));



            return appUser;


        } catch (SQLException exception)
        {
            exception.printStackTrace();

        }
        return null;
    }
}
