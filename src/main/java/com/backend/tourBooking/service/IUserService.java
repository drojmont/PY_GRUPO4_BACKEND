package com.backend.tourBooking.service;

import com.backend.tourBooking.auth.AuthResponse;
import com.backend.tourBooking.auth.LoginRequest;
import com.backend.tourBooking.dto.input.UserInputDTO;
import com.backend.tourBooking.dto.output.UserOutputDTO;

import java.util.List;
public interface IUserService {

    AuthResponse registrar(UserInputDTO inputDTO);
    boolean existeCorreoElectronico(String correoElectronico);
    AuthResponse login(LoginRequest loginRequest);
    List<UserOutputDTO> listarTodosLosUsuarios();
    UserOutputDTO cambiarRolUsuario(Long userId, Boolean isAdmin);
}