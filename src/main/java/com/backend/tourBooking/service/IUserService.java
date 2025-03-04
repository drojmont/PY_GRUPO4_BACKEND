package com.backend.tourBooking.service;

import com.backend.tourBooking.auth.AuthResponse;
import com.backend.tourBooking.auth.LoginRequest;
import com.backend.tourBooking.dto.input.UserInputDTO;
import com.backend.tourBooking.dto.output.UserOutputDTO;

public interface IUserService {

    UserOutputDTO registrar(UserInputDTO inputDTO);
    boolean existeCorreoElectronico(String correoElectronico);
    AuthResponse login(LoginRequest loginRequest);
}