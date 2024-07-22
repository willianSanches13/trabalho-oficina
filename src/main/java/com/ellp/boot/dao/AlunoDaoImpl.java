package com.ellp.boot.dao;

import java.time.LocalDate;
import java.util.List;

import com.ellp.boot.domain.Aluno;
import org.springframework.stereotype.Repository;

@Repository
public class AlunoDaoImpl extends AbstractDao<Aluno, Long> implements AlunoDao {

	public List<Aluno> findByNome(String nome) {
		
		return createQuery("select f from Aluno f where f.nome like concat('%',?1,'%') ", nome);
	}

	@Override
	public List<Aluno> findByCargoId(Long id) {
		
		return createQuery("select f from Aluno f where f.cargo.id = ?1", id);
	}

	@Override
	public List<Aluno> findByDataEntradaDataSaida(LocalDate entrada, LocalDate saida) {
		String jpql = "select f from Aluno f " +
                "where f.dataEntrada >= ?1 and f.dataSaida <= ?2 " +
                "order by f.dataEntrada asc";
		return createQuery(jpql, entrada, saida);
	}

	@Override
	public List<Aluno> findByDataEntrada(LocalDate entrada) {
		String jpql = "select f from Aluno f " +
                "where f.dataEntrada = ?1 " +
                "order by f.dataEntrada asc";
		return createQuery(jpql, entrada);
	}

	@Override
	public List<Aluno> findByDataSaida(LocalDate saida) {
		String jpql = "select f from Aluno f " +
                "where f.dataSaida = ?1 " +
                "order by f.dataEntrada asc";
		return createQuery(jpql, saida);
	}	
	
}
