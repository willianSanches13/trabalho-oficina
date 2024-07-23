package com.ellp.boot.web.controller;

import com.ellp.boot.domain.*;
import com.ellp.boot.domain.enums.CasaEnum;
import com.ellp.boot.domain.enums.EscolaridadeEnum;
import com.ellp.boot.domain.enums.SimNaoEnum;
import com.ellp.boot.domain.enums.UfEnum;
import com.ellp.boot.web.validator.AlunoValidator;
import com.ellp.boot.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.time.LocalDate;

@Controller
@RequestMapping("/alunos")
public class AlunoController {
	
	@Autowired
	private AlunoService alunoService;
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new AlunoValidator());
	}
	
	@GetMapping("/cadastrar")
	public String cadastrar(Aluno aluno) {
		return "aluno/cadastro";
	}
	
	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("alunos", alunoService.buscarTodos());
		return "aluno/lista"; 
	}

	
	@PostMapping("/salvar")
	public String salvar(@Valid Aluno aluno, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "aluno/cadastro";
		}
		
		alunoService.salvar(aluno);
		attr.addFlashAttribute("success", "Aluno inserido com sucesso.");
		return "redirect:/alunos/cadastrar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("aluno", alunoService.buscarPorId(id));
		return "aluno/cadastro";
	}

	@GetMapping("/detalhes/{id}")
	public String findById(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("aluno", alunoService.buscarPorId(id));
		return "aluno/detalhes";
	}

	@PostMapping("/editar")
	public String editar(@Valid Aluno aluno, BindingResult result, RedirectAttributes attr) {
		
		if (result.hasErrors()) {
			return "aluno/cadastro";
		}
		
		alunoService.editar(aluno);
		attr.addFlashAttribute("success", "Aluno editado com sucesso.");
		return "redirect:/alunos/cadastrar";
	}	
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		alunoService.excluir(id);
		attr.addFlashAttribute("success", "Aluno removido com sucesso.");
		return "redirect:/alunos/listar";
	}	
	
	@GetMapping("/buscar/nome")
	public String getPorNome(@RequestParam("nome") String nome, ModelMap model) {		
		model.addAttribute("alunos", alunoService.buscarPorNome(nome));
		return "aluno/lista";
	}
	
    @GetMapping("/buscar/data")
    public String getPorDatas(@RequestParam("entrada") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate entrada,
                              @RequestParam("saida") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate saida,
                              ModelMap model) {

        model.addAttribute("alunos", alunoService.buscarPorDatas(entrada, saida));
        return "aluno/lista";
    }

	@ModelAttribute("ufs")
	public UfEnum[] getUFs() {
		return UfEnum.values();
	}

	@ModelAttribute("escolaridades")
	public EscolaridadeEnum[] getEscolaridades() {
		return EscolaridadeEnum.values();
	}


	@ModelAttribute("sNs")
	public SimNaoEnum[] getSimNao() {
		return SimNaoEnum.values();
	}

	@ModelAttribute("casas")
	public CasaEnum[] getCasa() {
		return CasaEnum.values();
	}
}
