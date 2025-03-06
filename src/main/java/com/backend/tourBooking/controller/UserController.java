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
import org.springframework.http.MediaType;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/registro")
    public ResponseEntity<?> registrarUsuario(@Valid @RequestBody UserInputDTO inputDTO) {
        AuthResponse response = userService.registrar(inputDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/iniciar-sesion")
    public ResponseEntity<AuthResponse> iniciarSesion(@RequestBody LoginRequest loginRequest) {
        AuthResponse response = userService.login(loginRequest);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<UserOutputDTO>> getUsers() {
        try {
            List<UserOutputDTO> users = userService.listarTodosLosUsuarios();
            if (users != null) {
                return ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(users);
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); 
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); 
        }
    }

    @PostMapping(value = "/{userId}/role", produces = MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<UserOutputDTO> updateUserRole(
        @PathVariable Long userId,
        @RequestBody Map<String, Boolean> requestBody
) {
    Boolean isAdmin = requestBody.get("isAdmin");
    UserOutputDTO updatedUser = userService.cambiarRolUsuario(userId, isAdmin);
    return ResponseEntity.ok(updatedUser);
}
}