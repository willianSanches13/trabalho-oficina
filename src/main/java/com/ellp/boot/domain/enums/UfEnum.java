package com.ellp.boot.domain.enums;

import lombok.Getter;

@Getter
public enum UfEnum {

	AC("AC", "Acre"), 
	AL("AL", "Alagoas"),
	AM("AM", "Amazonas"),
	BA("BA", "Bahia"),
	CE("CE", "Ceará"),
	DF("DF", "Distrito Federal"),
	ES("ES", "Espírito Santo"),
	GO("GO", "Goiás"),
	MA("MA", "Maranhão"),
	MT("MT", "Mato Grosso"),
	MS("MS", "Mato Grosso do Sul"),
	MG("MG", "Minas Gerais"),
	PA("PA", "Pará"),
	PB("PB", "Paraíba"),
	PR("PR", "Paraná"),
	PE("PE", "Pernambuco"),
	PI("PI", "Piauí"),
	RJ("RJ", "Rio de Janeiro"),
	RN("RN", "Rio Grande do Norte"),
	RS("RS", "Rio Grande do Sul"),
	RO("RO", "Rondônia"),
	RR("RR", "Roraima"),
	SC("SC", "Santa Catarina"),
	SP("SP", "São Paulo"),
	SE("SE", "Sergipe"),
	TO("TO", "Tocantins");
	
	private final String sigla;
	private final String descricao;
	
	UfEnum(String sigla, String descricao) {
		this.sigla = sigla;
		this.descricao = descricao;
	}
}
