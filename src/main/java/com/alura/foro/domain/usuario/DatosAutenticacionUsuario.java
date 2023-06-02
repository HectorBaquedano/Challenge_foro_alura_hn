package com.alura.foro.domain.usuario;

import jakarta.validation.constraints.NotBlank;

public record DatosAutenticacionUsuario(@NotBlank String nombre, @NotBlank String contrasena) {

}
