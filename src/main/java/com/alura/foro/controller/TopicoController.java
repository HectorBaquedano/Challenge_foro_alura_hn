package com.alura.foro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alura.foro.domain.topico.DatosActualizarTopico;
import com.alura.foro.domain.topico.DatosListadoTopico;
import com.alura.foro.domain.topico.DatosRegistroTopico;
import com.alura.foro.domain.topico.Topico;
import com.alura.foro.domain.topico.TopicoRepository;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/topicos")
public class TopicoController {
	
	@Autowired
	private TopicoRepository topicoRepository;
	
	@PostMapping
	public void registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico) {
		topicoRepository.save(new Topico(datosRegistroTopico));
	}
	
	@GetMapping
	public Page<DatosListadoTopico> listadoTopicos(@PageableDefault(size = 10) Pageable paginacion){
		return topicoRepository.findByActivoTrue(paginacion).map(DatosListadoTopico :: new);		
	}
	
	@PutMapping
	@Transactional
	public void actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
		Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
		topico.actualizarTopico(datosActualizarTopico);		
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public void eliminarTopico(@PathVariable Long id) {
		Topico topico = topicoRepository.getReferenceById(id);
		topico.desactivarTopico();
	}
// DELETE EN BASE DE DATOS	
//	public void eliminarTopico(@PathVariable Long id) {
//		Topico topico = topicoRepository.getReferenceById(id);
//		topicoRepository.delete(topico);
//	}

}
