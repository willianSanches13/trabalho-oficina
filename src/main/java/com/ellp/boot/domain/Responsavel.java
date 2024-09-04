package com.ellp.boot.domain;

import com.ellp.boot.domain.enums.ParentescoEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@SuppressWarnings("serial")
@Entity
@Table(name = "RESPONSAVEL")
public class Responsavel extends AbstractEntity<Long> {

	@NotBlank
	@Size(max = 255, min = 3)
	@Column(nullable = false)
	private String nome;

	@NotBlank
//	@Pattern(regexp = "^\\(\\d{2}\\)\\s\\d{4,5}-\\d{4}$", message = "{Pattern.aluno.telefone}")
	@Column(name = "telefone", nullable = false)
	private String telefone;

	@Enumerated(EnumType.STRING)
	private ParentescoEnum parentesco;
}
