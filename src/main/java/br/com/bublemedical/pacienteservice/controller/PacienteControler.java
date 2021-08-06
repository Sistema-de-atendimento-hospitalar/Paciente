package br.com.bublemedical.pacienteservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.bublemedical.pacienteservice.domain.dto.EnderecoDto;
import br.com.bublemedical.pacienteservice.domain.dto.TelefoneDto;
import br.com.bublemedical.pacienteservice.domain.model.Endereco;
import br.com.bublemedical.pacienteservice.domain.model.Paciente;
import br.com.bublemedical.pacienteservice.domain.model.Telefone;
import br.com.bublemedical.pacienteservice.domain.request.CartaoSaudeRequest;
import br.com.bublemedical.pacienteservice.domain.request.PacienteRequest;
import br.com.bublemedical.pacienteservice.domain.request.PutPacienteRequest;
import br.com.bublemedical.pacienteservice.domain.response.PacienteResponse;
import br.com.bublemedical.pacienteservice.domain.response.TokenUserResponse;
import br.com.bublemedical.pacienteservice.service.CartaoSaudeService;
import br.com.bublemedical.pacienteservice.service.EnderecoService;
import br.com.bublemedical.pacienteservice.service.PacienteService;
import br.com.bublemedical.pacienteservice.service.TelefoneService;

@RestController
@CrossOrigin()
public class PacienteControler {

	@Autowired
	private PacienteService pacienteService;

	@Autowired
	private EnderecoService enderecoService;

	@Autowired
	private TelefoneService telefoneService;

	@Autowired
	private CartaoSaudeService cartaoSaudeService;

	@GetMapping("/v1/paciente")
	public Object findAll(@RequestParam(required = false) String nome,
			@RequestParam(required = false, defaultValue = "0") int pagina,
			@RequestParam(required = false, defaultValue = "20") int quantidade,
			@RequestParam(required = false, defaultValue = "nome") String campoOrdenado,
			@RequestParam(required = false, defaultValue = "") String directionType) {
		Direction direction = "desc".equalsIgnoreCase(directionType) ? Direction.DESC : Direction.ASC;
		return ResponseEntity.ok().body(pacienteService.findAll(PageRequest.of(pagina, quantidade, Sort.by(direction, campoOrdenado))));
	}

	@GetMapping(path = { "/v1/paciente/cpf/{cpf}" })
	public ResponseEntity<PacienteResponse> findByCpf(@PathVariable @Valid String cpf) {
		PacienteResponse pacienteDto = pacienteService.findByCpf(cpf);
		if (pacienteDto == null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok().body(pacienteDto);
	}
	
	@GetMapping(path = { "/v1/paciente/cpf/{cpf}/verify" })
	public ResponseEntity<TokenUserResponse> verifyExistsCpf(@PathVariable @Valid String cpf) {
		PacienteResponse pacienteDto = pacienteService.findByCpf(cpf);
		if (pacienteDto == null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok().body(new TokenUserResponse(pacienteDto.getCpf(), pacienteDto.getEmail()));
	}

	@GetMapping(path = { "/v1/paciente/{pacienteId}" })
	public ResponseEntity<PacienteResponse> findById(@PathVariable @Valid Long pacienteId) throws Exception {
		PacienteResponse pacienteDto = pacienteService.findById(pacienteId);
		return ResponseEntity.ok().body(pacienteDto);
	}

	@PostMapping("/v1/paciente")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<PacienteResponse> create(@RequestBody @Valid PacienteRequest pacienteRequest)
			throws Exception {
		PacienteResponse pacienteDto = pacienteService.save(pacienteRequest);
		return ResponseEntity.ok().body(pacienteDto);
	}

	@PostMapping("/v1/paciente/{pacienteId}/endereco")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<List<Endereco>> createAddress(@RequestBody @Valid List<EnderecoDto> enderecoRequest,
			@PathVariable("pacienteId") Long pacienteId) throws Exception {
		return ResponseEntity.ok().body(pacienteService.createAddress(enderecoRequest, pacienteId));
	}

	@PostMapping("/v1/paciente/{pacienteId}/telefone")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<List<Telefone>> createTelefone(@RequestBody @Valid List<TelefoneDto> telefoneRequest,
			@PathVariable("pacienteId") Long pacienteId) throws Exception {
		return ResponseEntity.ok().body(pacienteService.createTelefone(telefoneRequest, pacienteId));
	}

	@PostMapping("/v1/paciente/{pacienteId}/cartaoSaude")
	@ResponseStatus(HttpStatus.CREATED)
	public void createCartaoSaude(@RequestBody @Valid CartaoSaudeRequest cartaoSaudeRequest,
			@PathVariable("pacienteId") Long pacienteId) throws Exception {
		pacienteService.createCartaoSaude(cartaoSaudeRequest, pacienteId);
	}

	@PutMapping(value = "/v1/paciente/{pacienteId}")
	public ResponseEntity<PacienteResponse> update(@PathVariable("pacienteId") long pacienteId,
			@RequestBody @Valid PacienteRequest pacienteRequest) throws Exception {
		PacienteResponse pacienteDto = pacienteService.update(pacienteRequest, pacienteId);
		return ResponseEntity.ok().body(pacienteDto);
	}

	@PutMapping(value = "/v1/paciente/{pacienteId}/endereco")
	public void updateEndereco(@RequestBody @Valid List<EnderecoDto> enderecoRequest,
			@PathVariable("pacienteId") long pacienteId) throws Exception {
		enderecoService.update(enderecoRequest, pacienteId);
	}

	@PutMapping(value = "/v1/paciente/{pacienteId}/telefone")
	public void updateTelefone(@RequestBody @Valid List<TelefoneDto> telefoneRequest,
			@PathVariable("pacienteId") long pacienteId) throws Exception {
		telefoneService.update(telefoneRequest, pacienteId);
	}

	@PutMapping(value = "/v1/paciente/{pacienteId}/cartaoSaude")
	public void updateCartaoSaude(@RequestBody @Valid CartaoSaudeRequest cartaoSaudeRequest,
			@PathVariable("pacienteId") long pacienteId) throws Exception {
		cartaoSaudeService.update(cartaoSaudeRequest, pacienteId);
	}

	@PutMapping(value = "/v2/paciente/{pacienteId}")
	public ResponseEntity<PacienteResponse> updateV2(@PathVariable("pacienteId") long pacienteId,
			@RequestBody PutPacienteRequest pacienteRequest) throws Exception {
		PacienteResponse pacienteDto = pacienteService.updateV2(pacienteRequest, pacienteId);
		return ResponseEntity.ok().body(pacienteDto);
	}

	@DeleteMapping(path = { "/v1/paciente/{pacienteId}" })
	public ResponseEntity<Paciente> delete(@PathVariable long pacienteId) throws Exception {
		pacienteService.delete(pacienteId);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(path = { "/v1/paciente/{pacienteId}/endereco/{enderecoId}" })
	public ResponseEntity<Paciente> deleteEndereco(@PathVariable Long pacienteId, @PathVariable Long enderecoId)
			throws Exception {
		enderecoService.deleteByPacienteId(pacienteId, enderecoId);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(path = { "/v1/paciente/{pacienteId}/telefone/{telefoneId}" })
	public ResponseEntity<Paciente> deleteTelefone(@PathVariable Long pacienteId, @PathVariable Long telefoneId)
			throws Exception {
		telefoneService.deleteByPacienteId(pacienteId, telefoneId);
		return ResponseEntity.noContent().build();
	}

	@DeleteMapping(path = { "/v1/paciente/{pacienteId}/cartaoSaude/{convenioId}" })
	public ResponseEntity<Paciente> deleteCartaoSaude(@PathVariable Long pacienteId, @PathVariable Long cartaoSaudeId)
			throws Exception {
		cartaoSaudeService.delete(pacienteId, cartaoSaudeId);
		return ResponseEntity.noContent().build();
	}

}
