package com.backend.tourBooking.dto.output;

import com.backend.tourBooking.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserOutputDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String correoElectronico;
    private Role role;

}
