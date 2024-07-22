package com.ellp.boot.service;

import java.time.LocalDate;
import java.util.List;

import com.ellp.boot.domain.Aluno;

public interface AlunoService {

    void salvar(Aluno aluno);

    void editar(Aluno aluno);

    void excluir(Long id);

    Aluno buscarPorId(Long id);

    List<Aluno> buscarTodos();

	List<Aluno> buscarPorNome(String nome);

	List<Aluno> buscarPorCargo(Long id);
	
	List<Aluno> buscarPorDatas(LocalDate entrada, LocalDate saida);
}
