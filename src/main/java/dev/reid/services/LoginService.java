package dev.reid.services;

import dev.reid.entity.AppUser;

public interface LoginService {
    AppUser validateUser(String username, String password);
}
