package com.polania.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.polania.demo.entities.TipoServicio;
import com.polania.demo.repository.TipoRepository;

@RestController
@CrossOrigin(origins = "*") 
@RequestMapping("/tipo")
public class TipoController {
	
	private TipoRepository tiporepo;
	
	@Autowired
	public TipoController(TipoRepository tiporepo) {
		this.tiporepo=tiporepo;
		
	}
	
	@GetMapping
    public ResponseEntity<List<TipoServicio>> getAllServicios() {
        List<TipoServicio> tiposervicios = tiporepo.findAll();
        return ResponseEntity.ok(tiposervicios);
    }
	
	@PostMapping("/save")
    public ResponseEntity<TipoServicio> createServicio(@RequestBody TipoServicio tiposervicio) {
        TipoServicio newTipoServicio = tiporepo.save(tiposervicio);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newTipoServicio.getId()).toUri();
        return ResponseEntity.created(location).body(newTipoServicio);
    }
	

}
