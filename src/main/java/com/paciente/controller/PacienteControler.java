package com.paciente.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paciente.request.PacienteRequest;
import com.paciente.response.PacienteDto;
import com.paciente.service.PacienteService;

@RestController
@RequestMapping({ "/pacientes" })
public class PacienteControler {

	@Autowired
	private PacienteService pacienteService;

	@GetMapping
	public Page<PacienteDto> findAll(@RequestParam(required = false) String nome,
			@RequestParam(required = false, defaultValue = "0") int pagina,
			@RequestParam(required = false, defaultValue = "10") int quantidade,
			@RequestParam(required = false, defaultValue = "nome") String campoOrdenado,
			@RequestParam(required = false, defaultValue = "") String directionType) {
		Direction direction = "desc".equalsIgnoreCase(directionType) ? Direction.DESC : Direction.ASC;
		return pacienteService.findAll(PageRequest.of(pagina, quantidade, Sort.by(direction, campoOrdenado)));
	}

	@GetMapping(path = { "/cpf/{cpf}" })
	public ResponseEntity<PacienteDto> findById(@PathVariable @Valid String cpf) {
		PacienteDto pacienteDto = pacienteService.findByCpf(cpf);
		return ResponseEntity.ok().body(pacienteDto);
	}

	@PostMapping
	public ResponseEntity<PacienteDto> create(@RequestBody @Valid PacienteRequest pacienteRequest) throws Exception {
		PacienteDto pacienteDto = pacienteService.save(pacienteRequest);
		return ResponseEntity.ok().body(pacienteDto);
	}

	@PutMapping(value = "/{pacienteId}")
	public ResponseEntity<PacienteDto> update(@PathVariable("pacienteId") long pacienteId,
			@RequestBody PacienteRequest pacienteRequest) throws Exception {
		PacienteDto pacienteDto = pacienteService.update(pacienteRequest, pacienteId);
		return ResponseEntity.ok().body(pacienteDto);
	}

	@DeleteMapping(path = { "/{pacienteId}" })
	public ResponseEntity<Object> delete(@PathVariable @Valid long pacienteId) throws Exception {
		pacienteService.delete(pacienteId);
		return ResponseEntity.noContent().build();
	}

}
