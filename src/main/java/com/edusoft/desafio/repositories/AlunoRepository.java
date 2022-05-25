package com.edusoft.desafio.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edusoft.desafio.models.AlunoModel;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoModel, UUID> {
	
	

}
