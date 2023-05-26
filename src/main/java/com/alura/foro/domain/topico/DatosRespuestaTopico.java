package com.alura.foro.domain.topico;

import java.time.LocalDateTime;

import com.alura.foro.domain.curso.Curso;
import com.alura.foro.domain.usuario.Usuario;

public record DatosRespuestaTopico(
		Long id,
		String titulo,
		String mensaje,
		StatusTopico estatus,
		LocalDateTime fechaCreacion,
		Usuario autor,
		Curso curso
		) {

}
