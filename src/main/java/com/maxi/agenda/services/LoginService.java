package com.maxi.agenda.services;

import com.maxi.agenda.dtos.LoginCreateDTO;
import com.maxi.agenda.dtos.LoginDTO;
import com.maxi.agenda.dtos.NewLoginCreatedDTO;
import com.maxi.agenda.dtos.PersolLoggedDTO;

public interface LoginService {
    public NewLoginCreatedDTO createLogin(LoginCreateDTO obj);

    public PersolLoggedDTO login(LoginDTO obj);
}
