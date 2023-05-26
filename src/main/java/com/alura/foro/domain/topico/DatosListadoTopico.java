package com.alura.foro.domain.topico;

import java.time.LocalDateTime;

import com.alura.foro.domain.curso.Curso;
import com.alura.foro.domain.usuario.Usuario;

public record DatosListadoTopico(Long id, String titulo, String mensaje,
		LocalDateTime fechaCreacion, StatusTopico estatus, Usuario autor, Curso curso) {
	
	public DatosListadoTopico(Topico topico) {
	this(topico.getId(),topico.getTitulo(), topico.getMensaje(), topico.getfechaCreacion(), topico.getStatus(), topico.getAutor(), topico.getCurso());
	}	
}
