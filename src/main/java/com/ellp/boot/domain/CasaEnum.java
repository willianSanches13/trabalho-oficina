package com.ellp.boot.domain;

import lombok.Getter;

@Getter
public enum CasaEnum {

    PROPRIA("Própria"),
    ALUGADA("Alugada");

    private final String descricao;

    CasaEnum(String descricao) {
        this.descricao = descricao;
    }
    }
