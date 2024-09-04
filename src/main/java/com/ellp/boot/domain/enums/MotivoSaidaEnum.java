package com.ellp.boot.domain.enums;

public enum MotivoSaidaEnum {
    MUDANCA("Mudança de cidade"),
    CONCLUSAO("Conclusão do curso"),
    DESISTENCIA("Desistência"),
    TRANSFERENCIA("Transferência"),
    OUTRO("Outro motivo");

    private final String descricao;

    MotivoSaidaEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
