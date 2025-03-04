package com.backend.tourBooking.auth;

import com.backend.tourBooking.dto.output.UserOutputDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Data
@NoArgsConstructor
public class AuthResponse {

    private String token;

    private UserOutputDTO user;


}
