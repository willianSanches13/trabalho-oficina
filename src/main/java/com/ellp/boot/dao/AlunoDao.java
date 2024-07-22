package com.ellp.boot.dao;

import java.time.LocalDate;
import java.util.List;

import com.ellp.boot.domain.Aluno;

public interface AlunoDao {
    
	void save(Aluno funcionario);

    void update(Aluno funcionario);

    void delete(Long id);

    Aluno findById(Long id);

    List<Aluno> findAll();
    
    List<Aluno> findByNome(String nome);

	List<Aluno> findByCargoId(Long id);

	List<Aluno> findByDataEntradaDataSaida(LocalDate entrada, LocalDate saida);

	List<Aluno> findByDataEntrada(LocalDate entrada);

	List<Aluno> findByDataSaida(LocalDate saida);
}
