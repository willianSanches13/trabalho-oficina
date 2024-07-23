package com.ellp.boot.domain;

import com.ellp.boot.domain.enums.CasaEnum;
import com.ellp.boot.domain.enums.EscolaridadeEnum;
import com.ellp.boot.domain.enums.SimNaoEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@SuppressWarnings("serial")
@Entity
@Table(name = "SOCIOECONOMICOS")
public class SocioEconomico extends AbstractEntity<Long> {

	@Column(name = "computador", length = 5)
	@Enumerated(EnumType.STRING)
	private SimNaoEnum possuiComputador;

	@Column(name = "escolaridade_pai", length = 40)
	@Enumerated(EnumType.STRING)
	private EscolaridadeEnum escolaridadePai;

	@Column(name = "escolaridade_mae", length = 40)
	@Enumerated(EnumType.STRING)
	private EscolaridadeEnum escolaridadeMae;

	@Column(name = "carro_familia", length = 5)
	@Enumerated(EnumType.STRING)
	private SimNaoEnum carroFamilia;

	@Column(name = "emprego_pai")
	private String empregoPai;

	@Column(name = "emprego_mae")
	private String empregoMae;

	@Column(name = "num_filhos_familia")
	private Integer numeroFilhosFamilia;

	@Column(name = "casa", length = 10)
	@Enumerated(EnumType.STRING)
	private CasaEnum casa;

	@Column(name = "num_pesssoas_empregadas")
	private Integer numeroPessoasEmpregadas;

	@Column(name = "renda_familia", precision = 10, scale = 2)
	private Double rendaFamilia;

}
