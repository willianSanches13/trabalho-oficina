package com.ellp.boot.domain.enums;

public enum ParentescoEnum {
    PAI("Pai"),
    MAE("Mãe"),
    IRMAO("Irmão"),
    IRMA("Irmã"),
    AVO("Avô/Avó"),
    TIO("Tio/Tia"),
    PRIMO("Primo/Prima"),
    OUTRO("Outro");

    private final String descricao;

    ParentescoEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}