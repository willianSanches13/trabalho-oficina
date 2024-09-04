package com.ellp.boot.repository;


import java.util.List;

public interface AlunoRepositoryCustom {
    List<Object[]> countByMotivoSaida();
    List<Object[]> countByRendaFamiliar();
    List<Object[]> countByAnoLetivo();
    List<Object[]> countBySocioEconomico();
}
