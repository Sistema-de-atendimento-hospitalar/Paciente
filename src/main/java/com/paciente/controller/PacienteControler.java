package com.paciente.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.paciente.domain.request.CartaoSaudeRequest;
import com.paciente.domain.request.EnderecoRequest;
import com.paciente.domain.request.PacienteRequest;
import com.paciente.domain.request.TelefoneRequest;
import com.paciente.domain.response.PacienteResponse;
import com.paciente.service.PacienteService;

@RestController
@RequestMapping({ "/paciente" })
public class PacienteControler {

	@Autowired
	private PacienteService pacienteService;

	@GetMapping
	public Page<PacienteResponse> findAll(@RequestParam(required = false) String nome,
			@RequestParam(required = false, defaultValue = "0") int pagina,
			@RequestParam(required = false, defaultValue = "20") int quantidade,
			@RequestParam(required = false, defaultValue = "nome") String campoOrdenado,
			@RequestParam(required = false, defaultValue = "") String directionType) {
		Direction direction = "desc".equalsIgnoreCase(directionType) ? Direction.DESC : Direction.ASC;
		return pacienteService.findAll(PageRequest.of(pagina, quantidade, Sort.by(direction, campoOrdenado)));
	}

	@GetMapping(path = { "/cpf/{cpf}" })
	public ResponseEntity<PacienteResponse> findByCpf(@PathVariable @Valid String cpf) {
		PacienteResponse pacienteDto = pacienteService.findByCpf(cpf);
		return ResponseEntity.ok().body(pacienteDto);
	}

	@GetMapping(path = { "/{pacienteId}" })
	public ResponseEntity<PacienteResponse> findById(@PathVariable @Valid Long pacienteId) throws Exception {
		PacienteResponse pacienteDto = pacienteService.findById(pacienteId);
		return ResponseEntity.ok().body(pacienteDto);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<PacienteResponse> create(@RequestBody @Valid PacienteRequest pacienteRequest) throws Exception {
		PacienteResponse pacienteDto = pacienteService.save(pacienteRequest);
		return ResponseEntity.ok().body(pacienteDto);
	}

	@PostMapping("/{pacienteId}/endereco")
	@ResponseStatus(HttpStatus.CREATED)
	public void createAddress(@RequestBody @Valid List<EnderecoRequest> enderecoRequest,
			@PathVariable("pacienteId") Long pacienteId) throws Exception {
		pacienteService.createAddress(enderecoRequest, pacienteId);
	}
	
	@PostMapping("/{pacienteId}/telefone")
	@ResponseStatus(HttpStatus.CREATED)
	public void createTelefone(@RequestBody @Valid List<TelefoneRequest> telefoneRequest,
			@PathVariable("pacienteId") Long pacienteId) throws Exception {
		pacienteService.createTelefone(telefoneRequest, pacienteId);
	}
	
	@PostMapping("/{pacienteId}/cartaoSaude")
	@ResponseStatus(HttpStatus.CREATED)
	public void createCartaoSaude(@RequestBody @Valid CartaoSaudeRequest cartaoSaudeRequest,
			@PathVariable("pacienteId") Long pacienteId) throws Exception {
		pacienteService.createCartaoSaude(cartaoSaudeRequest, pacienteId);
	}

	@PutMapping(value = "/{pacienteId}")
	public ResponseEntity<PacienteResponse> update(@PathVariable("pacienteId") long pacienteId,
			@RequestBody PacienteRequest pacienteRequest) throws Exception {
		PacienteResponse pacienteDto = pacienteService.update(pacienteRequest, pacienteId);
		return ResponseEntity.ok().body(pacienteDto);
	}

	@DeleteMapping(path = { "/{pacienteId}" })
	public ResponseEntity<Object> delete(@PathVariable long pacienteId) throws Exception {
		pacienteService.delete(pacienteId);
		return ResponseEntity.noContent().build();
	}

}
