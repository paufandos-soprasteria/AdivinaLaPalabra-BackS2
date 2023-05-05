package com.adivinaLaPalabra.squad2.back.AdivinaLaPalabra.dto;

import java.util.Base64;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginDTO {

    @NotBlank(message = "El nombre de usuario es obligatorio")
    @Size(min = 4, message = "El nombre de usuario debe tener mas de 4 caracteres")
    @Pattern(regexp = "[a-zA-Z0-9]*", message = "El nombre de usuario no puede contener caracteres especiales")
    private String name;

    @Size(min = 6, message = "La contraseña debe tener mas de 6 caracteres")
    @Size(max = 12, message = "La contraseña debe tener menos de 12 caracteres")
    private String password;

    public LoginDTO(String name, String password) {
        this.name = new String(Base64.getDecoder().decode(name.getBytes()));
        this.password = new String(Base64.getDecoder().decode(password.getBytes()));
    }
}
