package com.alura.foro.domain.topico;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy;

import com.alura.foro.domain.curso.Curso;
import com.alura.foro.domain.respuesta.Respuesta;
import com.alura.foro.domain.usuario.Usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Topico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String mensaje;
	private LocalDateTime fechaCreacion = LocalDateTime.now();
	
	@Enumerated(EnumType.STRING)
	private StatusTopico estatus = StatusTopico.NO_RESPONDIDO;
//	private Usuario autor;
//	private Curso curso;
//	private List<Respuesta> respuestas = new ArrayList<>();
	private boolean activo;

	
	public Topico() {
		
	}
	
	public Topico(String titulo, String mensaje, Curso curso) {
		this.titulo = titulo;
		this.mensaje = mensaje;
//		this.curso = curso;
	}

	public Topico(DatosRegistroTopico datosRegistroTopico) {
		this.activo = true;
		this.titulo = datosRegistroTopico.titulo();
		this.mensaje = datosRegistroTopico.mensaje();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Topico other = (Topico) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public LocalDateTime getfechaCreacion() {
		return fechaCreacion;
	}

	public void setfechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public StatusTopico getStatus() {
		return estatus;
	}

	public void setStatus(StatusTopico status) {
		this.estatus = status;
	}

	public void actualizarTopico(DatosActualizarTopico datosActualizarTopico) {
		if(datosActualizarTopico.titulo() != null) {
			this.titulo = datosActualizarTopico.titulo();
		}
		
		if(datosActualizarTopico.mensaje() != null) {
			this.mensaje = datosActualizarTopico.mensaje();
		}
		if(datosActualizarTopico.estatus() != null) {
			this.estatus = datosActualizarTopico.estatus();
		}
				
	}

	public void desactivarTopico() {
		this.activo =false;
		
	}

//	public Usuario getAutor() {
//		return autor;
//	}
//
//	public void setAutor(Usuario autor) {
//		this.autor = autor;
//	}
//
//	public Curso getCurso() {
//		return curso;
//	}
//
//	public void setCurso(Curso curso) {
//		this.curso = curso;
//	}
//
//	public List<Respuesta> getRespuestas() {
//		return respuestas;
//	}
//
//	public void setRespuestas(List<Respuesta> respuestas) {
//		this.respuestas = respuestas;
//	}

}
