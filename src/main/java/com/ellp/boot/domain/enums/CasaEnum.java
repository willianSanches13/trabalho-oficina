package com.ellp.boot.domain.enums;

import lombok.Getter;

@Getter
public enum CasaEnum {

    PROPRIA("Própria"),
    ALUGADA("Alugada"),
    CEDIDA("Cedida");

    private final String descricao;

    CasaEnum(String descricao) {
        this.descricao = descricao;
    }
    }
