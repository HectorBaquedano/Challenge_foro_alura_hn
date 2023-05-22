package com.alura.foro.domain.topico;

import java.time.LocalDateTime;

public record DatosListadoTopico(Long id, String titulo, String mensaje,
		LocalDateTime fechaCreacion, StatusTopico estatus) {
	
	public DatosListadoTopico(Topico topico) {
	this(topico.getId(),topico.getTitulo(), topico.getMensaje(), topico.getfechaCreacion(), topico.getStatus());
	}	
}
