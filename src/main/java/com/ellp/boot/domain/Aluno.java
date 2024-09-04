package com.ellp.boot.domain;

import com.ellp.boot.domain.enums.MotivoSaidaEnum;
import com.ellp.boot.domain.enums.SerieEnum;
import com.ellp.boot.domain.enums.SimNaoEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@SuppressWarnings("serial")
@Entity
@Table(name = "ALUNOS")
public class Aluno extends AbstractEntity<Long> {

	@NotBlank
	@Size(max = 255, min = 3)
	@Column(nullable = false)
	private String nome;

	@NotNull
	@PastOrPresent(message = "{PastOrPresent.aluno.dataNascimento}")
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name= "data_nascimento", nullable = false, columnDefinition = "DATE")
	private LocalDate dataNascimento;

	@PastOrPresent(message = "{PastOrPresent.aluno.dataEntrada}")
	@DateTimeFormat(iso = ISO.DATE, pattern = "")
	@Column(name= "data_entrada", nullable = false, columnDefinition = "DATE")
	private LocalDate dataEntrada;

	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "data_saida", columnDefinition = "DATE")
	private LocalDate dataSaida;

	@Column(name = "motivo_saida")
	@Enumerated(EnumType.STRING)
	private MotivoSaidaEnum motivoSaida;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "socioeconomico_id_fk")
	private SocioEconomico socioeconomico;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "endereco_id_fk")
	private Endereco endereco;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "responsavel_id_fk")
	private Responsavel responsavel;

	@NotBlank
	@Size(max = 255, min = 3)
	@Column(nullable = false)
	private String escola;

	@Enumerated(EnumType.STRING)
	private SerieEnum serie;

	@NotBlank
	@Column(name = "telefone", nullable = false)
	private String telefone;

	@NotNull
	@Digits(integer = 2, fraction = 0)
	@Column(name = "numero_grupo_familiar", nullable = false, length = 2)
	private Integer numeroFamiliares;

	@NotNull
	@Column(name = "trasporte", nullable = false, length = 5)
	@Enumerated(EnumType.STRING)
	private SimNaoEnum nececissadeTrasporte;

	@NotNull
	@Column(name = "internet", nullable = false, length = 5)
	@Enumerated(EnumType.STRING)
	private SimNaoEnum acessoInternet;
}