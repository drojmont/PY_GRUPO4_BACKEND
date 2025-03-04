package com.backend.tourBooking.service.impl;

import com.backend.tourBooking.auth.AuthResponse;
import com.backend.tourBooking.auth.LoginRequest;
import com.backend.tourBooking.auth.jwt.JwtService;
import com.backend.tourBooking.dto.input.UserInputDTO;
import com.backend.tourBooking.dto.output.UserOutputDTO;
import com.backend.tourBooking.entity.User;
import com.backend.tourBooking.entity.enums.Role;
import com.backend.tourBooking.exception.AuthenticationFailedException;
import com.backend.tourBooking.exception.CustomException;
import com.backend.tourBooking.exception.UserNotFoundException;
import com.backend.tourBooking.repository.UserRepository;
import com.backend.tourBooking.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements IUserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

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
        user.setRole(Role.CLIENT);
        //user.setPassword(passwordEncoder.encode(inputDTO.getPassword()));
        if (inputDTO.getPassword() == null || inputDTO.getPassword().isEmpty()) {
            user.setPassword("defaultpassword");
        } else {
            user.setPassword(inputDTO.getPassword());
        }

        User savedUser = userRepository.save(user);

        return toOutputDTO(savedUser);
    }

    @Override
    public boolean existeCorreoElectronico(String correoElectronico) {
        return userRepository.existsByCorreoElectronico(correoElectronico);
    }

    @Override
    public AuthResponse login(LoginRequest loginRequest) {
        try {

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getCorreoElectronico(), loginRequest.getPassword()));

            User user = userRepository.findByCorreoElectronico(loginRequest.getCorreoElectronico()).orElseThrow(() -> new UserNotFoundException("Usuario no encontrado"));

            if (!user.isActivo()) {
                throw new LockedException("Cuenta bloqueada, contacta con el administrador");
            }

            //devuelve un token con los datos del usuario
            String token = jwtService.generateToken(user);

            UserOutputDTO userOutputDTO = toOutputDTO(user);

            //devuelvo una instancia AuthReponse para contruir mis instancias de clase
//         return AuthResponse.builder()
//                 .token(token)
//                 .userOutputDTO(userOutputDTO)
//                 .build();

            //Es la forma conocida de instanciar
            return new AuthResponse(token, userOutputDTO);

        } catch (BadCredentialsException e) {
            throw new AuthenticationFailedException("Correo y/o Contraseña inválido");

        } catch (UserNotFoundException e) {
            throw new UsernameNotFoundException(e.getMessage());

        } catch (LockedException e) {
            throw new LockedException(e.getMessage());
        }

    }

    private UserOutputDTO toOutputDTO(User usuario) {
        UserOutputDTO outputDTO = new UserOutputDTO();
        outputDTO.setId(usuario.getId());
        outputDTO.setNombre(usuario.getNombre());
        outputDTO.setApellido(usuario.getApellido());
        outputDTO.setCorreoElectronico(usuario.getCorreoElectronico());
        outputDTO.setRole(usuario.getRole());
        return outputDTO;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserDetails user = userRepository.findByCorreoElectronico(username).orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(), "", user.getAuthorities());

    }
}
