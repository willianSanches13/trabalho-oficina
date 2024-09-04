package com.ellp.boot.web.controller;

import com.ellp.boot.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/relatorios")
public class RelatorioController {

    @Autowired
    private AlunoRepository alunoRepository;

    @GetMapping("/socioeconomico")
    public String mostrarFormulario(Model model) {
        List<String> headersMotivoSaida = Arrays.asList("Motivo de Saída", "Contagem");
        List<String> headersRendaFamiliar = Arrays.asList("Renda Familiar", "Contagem");
        List<String> headersAnoLetivo = Arrays.asList("Ano Letivo", "Contagem");
        List<String> headersSocioEconomico = Arrays.asList("Possui Computador", "Escolaridade do Pai", "Escolaridade da Mãe", "Carro na Família", "Contagem");

        model.addAttribute("headersMotivoSaida", headersMotivoSaida);
        model.addAttribute("headersRendaFamiliar", headersRendaFamiliar);
        model.addAttribute("headersAnoLetivo", headersAnoLetivo);
        model.addAttribute("headersSocioEconomico", headersSocioEconomico);

        return "relatorio/socioeconomico";
    }

    @PostMapping("/socioeconomico")
    public String gerarRelatorioSocioeconomico(@RequestParam String motivoSaida, @RequestParam String rendaFamiliar, @RequestParam Integer anoLetivo, @RequestParam Boolean possuiComputador, @RequestParam String escolaridadePai, @RequestParam String escolaridadeMae, @RequestParam Boolean carroFamilia, Model model) {
        model.addAttribute("countByMotivoSaida", alunoRepository.countByMotivoSaida(motivoSaida));
        model.addAttribute("countByRendaFamiliar", alunoRepository.countByRendaFamiliar(rendaFamiliar));
        model.addAttribute("countByAnoLetivo", alunoRepository.countByAnoLetivo(anoLetivo));
        model.addAttribute("countByPossuiComputador", alunoRepository.countByPossuiComputador(possuiComputador));
        model.addAttribute("countByEscolaridadePai", alunoRepository.countByEscolaridadePai(escolaridadePai));
        model.addAttribute("countByEscolaridadeMae", alunoRepository.countByEscolaridadeMae(escolaridadeMae));
        model.addAttribute("countByCarroFamilia", alunoRepository.countByCarroFamilia(carroFamilia));
        return "relatorio/socioeconomico";
    }
}