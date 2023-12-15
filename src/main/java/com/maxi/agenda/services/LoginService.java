package com.maxi.agenda.services;

import com.maxi.agenda.domains.Login;
import com.maxi.agenda.dtos.LoginCreateDTO;
import com.maxi.agenda.dtos.NewLoginCreatedDTO;

public interface LoginService {
    public NewLoginCreatedDTO createLogin(LoginCreateDTO obj);

    public Login login(String user, String password);

    // public PersolLoggedDTO login(LoginDTO obj);
}
