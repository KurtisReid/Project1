package dev.reid.services;

import dev.reid.daos.AppUserDAO;
import dev.reid.entity.AppUser;

public class LoginServiceImpl implements LoginService{
    private AppUserDAO appUserDAO;

    public LoginServiceImpl(AppUserDAO appUserDAO)
    {
        this.appUserDAO = appUserDAO;
    }
    @Override
    public AppUser validateUser(String username, String password) {
        AppUser appUser = this.appUserDAO.getAppUserByUsername(username);
        if (appUser == null)
        {
            throw new RuntimeException("No employee found");
        }
        if (!appUser.getPassword().equals(password))
        {
            throw new RuntimeException("password does not match");
        }
        return appUser;
    }
}
