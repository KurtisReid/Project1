package dev.reid.daos;

import dev.reid.app.App;
import dev.reid.entity.AppUser;

import java.util.List;

public interface AppUserDAO {
    AppUser getAppUserByUsername(String username);

}
