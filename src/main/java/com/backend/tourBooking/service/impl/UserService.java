package com.backend.tourBooking.service.impl;

import com.backend.tourBooking.dto.input.UserInputDTO;
import com.backend.tourBooking.dto.output.UserOutputDTO;
import com.backend.tourBooking.entity.User;
import com.backend.tourBooking.exception.CustomException;
import com.backend.tourBooking.repository.UserRepository;
import com.backend.tourBooking.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements IUserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    @Transactional
    public UserOutputDTO registrar(UserInputDTO inputDTO) {
        // Verificar si el correo ya existe
        if (existeCorreoElectronico(inputDTO.getCorreoElectronico())) {
            throw new CustomException("El correo electrónico ya está en uso", HttpStatus.BAD_REQUEST);
        }
        
        User user = new User();
        user.setNombre(inputDTO.getNombre());
        user.setApellido(inputDTO.getApellido());
        user.setCorreoElectronico(inputDTO.getCorreoElectronico());
        user.setPassword(passwordEncoder.encode(inputDTO.getPassword()));
        
        User savedUser = userRepository.save(user);
        
        return toOutputDTO(savedUser);
    }
    
    @Override
    public boolean existeCorreoElectronico(String correoElectronico) {
        return userRepository.existsByCorreoElectronico(correoElectronico);
    }
    
    private UserOutputDTO toOutputDTO(User usuario) {
        UserOutputDTO outputDTO = new UserOutputDTO();
        outputDTO.setId(usuario.getId());
        outputDTO.setNombre(usuario.getNombre());
        outputDTO.setApellido(usuario.getApellido());
        outputDTO.setCorreoElectronico(usuario.getCorreoElectronico());
        return outputDTO;
    }
}
