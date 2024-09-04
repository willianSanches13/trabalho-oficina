package com.ellp.boot.repository;

import com.ellp.boot.domain.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    @Query("SELECT a.motivoSaida, COUNT(a) FROM Aluno a WHERE (:motivoSaida IS NULL OR a.motivoSaida = :motivoSaida) GROUP BY a.motivoSaida")
    List<Object[]> countByMotivoSaida(@Param("motivoSaida") String motivoSaida);

    @Query("SELECT s.rendaFamilia, COUNT(a) FROM Aluno a JOIN a.socioeconomico s WHERE (:rendaFamilia IS NULL OR s.rendaFamilia = :rendaFamilia) GROUP BY s.rendaFamilia")
    List<Object[]> countByRendaFamiliar(@Param("rendaFamilia") String rendaFamilia);

    @Query("SELECT YEAR(a.dataEntrada), COUNT(a) FROM Aluno a WHERE (:anoLetivo IS NULL OR YEAR(a.dataEntrada) = :anoLetivo) GROUP BY YEAR(a.dataEntrada)")
    List<Object[]> countByAnoLetivo(@Param("anoLetivo") Integer anoLetivo);

    @Query("SELECT s.possuiComputador, COUNT(a) FROM Aluno a JOIN a.socioeconomico s WHERE (:possuiComputador IS NULL OR s.possuiComputador = :possuiComputador) GROUP BY s.possuiComputador")
    List<Object[]> countByPossuiComputador(@Param("possuiComputador") Boolean possuiComputador);

    @Query("SELECT s.escolaridadePai, COUNT(a) FROM Aluno a JOIN a.socioeconomico s WHERE (:escolaridadePai IS NULL OR s.escolaridadePai = :escolaridadePai) GROUP BY s.escolaridadePai")
    List<Object[]> countByEscolaridadePai(@Param("escolaridadePai") String escolaridadePai);

    @Query("SELECT s.escolaridadeMae, COUNT(a) FROM Aluno a JOIN a.socioeconomico s WHERE (:escolaridadeMae IS NULL OR s.escolaridadeMae = :escolaridadeMae) GROUP BY s.escolaridadeMae")
    List<Object[]> countByEscolaridadeMae(@Param("escolaridadeMae") String escolaridadeMae);

    @Query("SELECT s.carroFamilia, COUNT(a) FROM Aluno a JOIN a.socioeconomico s WHERE (:carroFamilia IS NULL OR s.carroFamilia = :carroFamilia) GROUP BY s.carroFamilia")
    List<Object[]> countByCarroFamilia(@Param("carroFamilia") Boolean carroFamilia);
}