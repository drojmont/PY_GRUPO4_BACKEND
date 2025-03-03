package com.backend.tourBooking.dto.input;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserInputDTO {
    
    @NotBlank(message = "El nombre es requerido")
    @Size(min = 3, message = "El nombre debe tener mas de 3 caracteres")
    private String nombre;
    
    @NotBlank(message = "El apellido es requerido")
    @Size(min = 4, message = "El apellido debe tener mas de 4 caracteres")
    private String apellido;
    
    @NotBlank(message = "El correo electrónico es requerido")
    @Email(message = "Debe ser un correo electrónico válido")
    private String correoElectronico;
    
    @NotBlank(message = "La contraseña es requerida")
    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    private String password;

    public UserInputDTO(String nombre, String apellido, String correoElectronico, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correoElectronico = correoElectronico;
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
