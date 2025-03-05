package com.backend.tourBooking.dto.input;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateUserRoleDTO {
    @NotNull(message = "El ID de usuario es requerido")
    private Long userId;

    @NotNull(message = "El rol es requerido")
    private String role;
}
