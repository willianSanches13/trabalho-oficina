package com.ellp.boot.domain;

import lombok.Getter;

@Getter
public enum EscolaridadeEnum {
    SEM_INSTRUCAO("Sem Instrução"),
    ENSINO_FUNDAMENTAL_INCOMPLETO("Ensino Fundamental Incompleto"),
    ENSINO_FUNDAMENTAL_COMPLETO("Ensino Fundamental Completo"),
    ENSINO_MEDIO_INCOMPLETO("Ensino Médio Incompleto"),
    ENSINO_MEDIO_COMPLETO("Ensino Médio Completo"),
    ENSINO_SUPERIOR_INCOMPLETO("Ensino Superior Incompleto"),
    ENSINO_SUPERIOR_COMPLETO("Ensino Superior Completo"),
    POS_GRADUACAO("Pós-graduação"),
    MESTRADO("Mestrado"),
    DOUTORADO("Doutorado"),
    POS_DOUTORADO("Pós-doutorado");

    private final String descricao;

    EscolaridadeEnum(String descricao) {
        this.descricao = descricao;
    }

}
