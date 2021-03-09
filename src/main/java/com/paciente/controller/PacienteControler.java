package com.paciente.controller;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

import com.paciente.model.Paciente;
import com.paciente.repository.PacienteRepository;
import com.paciente.request.PacienteRequest;
import com.paciente.response.PacienteDto;


@RestController
@RequestMapping({ "/pacientes" })
public class PacienteControler {

	@Autowired
	private PacienteRepository repository;

	@GetMapping
	public Page<PacienteDto> findAll(@RequestParam(required = false) String nome,
			@RequestParam(required = false, defaultValue = "0") int pagina,
			@RequestParam(required = false, defaultValue = "10") int quantidade,
			@RequestParam(required = false, defaultValue = "nome") String campoOrdenado,
			@RequestParam(required = false, defaultValue = "") String directionType) {
		Direction direction = "desc".equalsIgnoreCase(directionType) ? Direction.DESC : Direction.ASC;
		return repository.findAll(PageRequest.of(pagina, quantidade, Sort.by(direction, campoOrdenado)))
				.map(PacienteDto::toDto);
	}

	@GetMapping(path = { "/cpf/{cpf}" })
	public ResponseEntity<PacienteDto> findById(@PathVariable @Valid String cpf) {
		return repository.findByCpf(cpf).map(record -> {
			return ResponseEntity.ok().body(PacienteDto.toDto(record));
		}).orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<PacienteDto> create(@RequestBody @Valid PacienteRequest pacienteRequest) throws Exception {
		Paciente paciente = PacienteRequest.toModel(pacienteRequest);

		try {
			paciente = repository.save(paciente);
		} catch (DataIntegrityViolationException e) {
			throw new Exception("Error sistemico");
		}
		return ResponseEntity.ok().body(PacienteDto.toDto(paciente));
	}

	@PutMapping(value = "/{pacienteId}")
	public ResponseEntity<PacienteDto> update(@PathVariable("pacienteId") long pacienteid,
			@RequestBody PacienteRequest pacienteRequest) {
		return repository.findById(pacienteid).map(record -> {
			BeanUtils.copyProperties(pacienteRequest, record, "pacienteId");
			return ResponseEntity.ok().body(PacienteDto.toDto(repository.save(record)));
		}).orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping(path = { "/{pacienteId}" })
	public ResponseEntity<Object> delete(@PathVariable @Valid long pacienteId) {
		return repository.findById(pacienteId).map(record -> {
			repository.deleteById(pacienteId);
			return ResponseEntity.noContent().build();
		}).orElse(ResponseEntity.notFound().build());
	}

}
