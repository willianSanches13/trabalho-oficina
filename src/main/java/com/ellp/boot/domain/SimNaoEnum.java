package com.ellp.boot.domain;

import lombok.Getter;

@Getter
public enum SimNaoEnum {
    SIM("Sim"),
    NAO("Nao");

    private final String descricao;

    SimNaoEnum(String descricao) {
        this.descricao = descricao;
    }
    }
