package com.edusoft.desafio.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.edusoft.desafio.models.AlunoModel;
import com.edusoft.desafio.repositories.AlunoRepository;

@Service
public class AlunoService {

	final AlunoRepository alunoRepository;

	public AlunoService(AlunoRepository alunoRepository) {
		this.alunoRepository = alunoRepository;
	}

	@Transactional
	public AlunoModel save(AlunoModel alunoModel) {
		return alunoRepository.save(alunoModel);
	}

	public List<AlunoModel> findAll() {

		return alunoRepository.findAll();
	}

	public Optional<AlunoModel> findById(UUID id) {

		return alunoRepository.findById(id);
	}
	
	@Transactional
	public void delete(AlunoModel alunoModel) {
		alunoRepository.delete(alunoModel);

	}
	
	

}
