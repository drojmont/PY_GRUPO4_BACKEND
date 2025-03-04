package com.backend.tourBooking.controller;

import com.backend.tourBooking.auth.AuthResponse;
import com.backend.tourBooking.auth.LoginRequest;
import com.backend.tourBooking.dto.input.UserInputDTO;
import com.backend.tourBooking.dto.output.UserOutputDTO;
import com.backend.tourBooking.service.IUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {
    
    @Autowired
    private IUserService userService;
    
    @PostMapping("/registro")
    public ResponseEntity<?> registrarUsuario(@Valid @RequestBody UserInputDTO inputDTO) {
        UserOutputDTO usuario = userService.registrar(inputDTO);
        
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Usuario registrado exitosamente");
        response.put("usuario", usuario);
        
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/iniciar-sesion")
    public ResponseEntity<AuthResponse> iniciarSesion(@RequestBody LoginRequest loginRequest){
        AuthResponse response = userService.login(loginRequest);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}