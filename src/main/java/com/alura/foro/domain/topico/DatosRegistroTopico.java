package com.alura.foro.domain.topico;

import com.alura.foro.domain.curso.Curso;
import com.alura.foro.domain.curso.DatosRegistroCurso;
import com.alura.foro.domain.usuario.DatosRegistroUsuario;
import com.alura.foro.domain.usuario.Usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
		@NotBlank
		String titulo, 
		@NotBlank
		String mensaje
		) {

}
