package com.edusoft.desafio.controllers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edusoft.desafio.dtos.AlunoDto;
import com.edusoft.desafio.models.AlunoModel;
import com.edusoft.desafio.services.AlunoService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/aluno")
public class AlunoController {

	final AlunoService alunoService;

	public AlunoController(AlunoService alunoService) {
		this.alunoService = alunoService;
	}

	@PostMapping
	public ResponseEntity<Object> saveAluno(@RequestBody @Valid AlunoDto alunoDto) {
		AlunoModel alunoModel = new AlunoModel();
		BeanUtils.copyProperties(alunoDto, alunoModel);
		return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.save(alunoModel));
	}

	@GetMapping
	public ResponseEntity<List<AlunoModel>> getAllAluno() {
		return ResponseEntity.status(HttpStatus.OK).body(alunoService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getOneAluno(@PathVariable(value = "id") UUID id) {
		Optional<AlunoModel> alunoModelOptional = alunoService.findById(id);
		if (!alunoModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado");
		}
		return ResponseEntity.status(HttpStatus.OK).body(alunoModelOptional.get());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteAluno(@PathVariable(value = "id") UUID id) {
		Optional<AlunoModel> alunoModelOptional = alunoService.findById(id);
		if (!alunoModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado");
		}
		
		alunoService.delete(alunoModelOptional.get());
		return ResponseEntity.status(HttpStatus.OK).body("Aluno deletado com sucesso!");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> updateAluno(@PathVariable(value = "id") UUID id, @RequestBody @Valid AlunoDto  alunoDto){
		Optional<AlunoModel> alunoModelOptional = alunoService.findById(id);
		if (!alunoModelOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado");
		}
		
		AlunoModel alunoModel =  alunoModelOptional.get();
		
		alunoModel.setCodigoAluno(alunoDto.getCodigoAluno());
		alunoModel.setNome(alunoDto.getNome());
		alunoModel.setNotas(alunoDto.getNotas());
		alunoModel.setQtdFaltas(alunoDto.getQtdFaltas());
		alunoModel.setTotalAulas(alunoDto.getTotalAulas());
		alunoModel.setMediaFinal(alunoDto.getMediaFinal());
		alunoModel.setStatus(alunoDto.getStatus());
		
		
		return ResponseEntity.status(HttpStatus.OK).body(alunoService.save(alunoModel));
	}
}
