package com.ellp.boot.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ellp.boot.dao.AlunoDao;
import com.ellp.boot.domain.Aluno;

@Service
@Transactional(readOnly = true)
public class AlunoServiceImpl implements AlunoService {
	
	@Autowired
	private AlunoDao dao;

	@Transactional(readOnly = false)
	@Override
	public void salvar(Aluno aluno) {
		dao.save(aluno);
	}

	@Transactional(readOnly = false)
	@Override
	public void editar(Aluno funcionario) {
		dao.update(funcionario);
	}

	@Transactional(readOnly = false)
	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override
	public Aluno buscarPorId(Long id) {
		
		return dao.findById(id);
	}

	@Override
	public List<Aluno> buscarTodos() {
		
		return dao.findAll();
	}

	@Override
	public List<Aluno> buscarPorNome(String nome) {
		
		return dao.findByNome(nome);
	}

	@Override
    public List<Aluno> buscarPorDatas(LocalDate entrada, LocalDate saida) {
	    if (entrada != null && saida != null) {	    	
            return dao.findByDataEntradaDataSaida(entrada, saida);
        } else if (entrada != null) {        	
	        return dao.findByDataEntrada(entrada);
        } else if (saida != null) {        	
	        return dao.findByDataSaida(saida);
        } else {
        	return new ArrayList<>();
        }
    }
}
